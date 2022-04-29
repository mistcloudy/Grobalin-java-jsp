package Login;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;

public class LoginDAO {

	private Connection getConnection() {

		Connection con = null;

		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/GlobalStudy");
			con = ds.getConnection();
		} catch (Exception e) {
			System.out.println("Connection 연결 실패!!!!!!!!!!!!!!!!!!");
		}
		return con;
	}
	
	public boolean idCheck(String id) {
		boolean result = true;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			// 현재 id값이 뭐가 들어올지 모르므로 ?
			pstmt = con.prepareStatement("select * from S_MEMBER where M_id=?");
			pstmt.setString(1, id);
			// 조회하는 커리, db의 변화 없는 경우<->db변화가 있는 경우는 .executeUpdate();
			rs = pstmt.executeQuery();
			if (!rs.next())
				result = false;
		} catch (SQLException s1) {
			s1.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ss) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ss) {
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException ss) {
				}
		}
		return result;
	}
	
	
	public boolean memberInsert(LoginVO vo) {
		boolean flag=false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			String sql = "insert into S_MEMBER values(S_MEMBER_seq.nextval,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getLanName());
			pstmt.setString(5, vo.getLevel());
			pstmt.setString(6, vo.getEmail());
			pstmt.setString(7, vo.getPhone());
			int count = pstmt.executeUpdate();
			if(count>0) {flag = true;}
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			if (pstmt != null)try {pstmt.close();} catch (SQLException ss) {}
			if (con != null)try {con.close();} catch (SQLException ss) {}
		}
		return flag;
		}
	// 로그인 버튼을 클릭하면 우리가 입력한 id와 pass를 데이터베이스에 있는 id와 pass를 비교해서 같으면 로그인성공,다르면 로그인 실패
		// 1:로그인성공, 0:비밀번호 오류, -1:아이디 없음
		public int loginCheck(String id, String pw) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int check = -1;

			try {
				con = getConnection();
				String strQuery = "select M_PW from S_MEMBER where M_ID = ?";
				pstmt = con.prepareStatement(strQuery);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					String dbPw = rs.getString("M_PW"); // 데이터베이스에서 가져온 비밀번호
					if (pw.equals(dbPw))
						check = 1;
					else
						check = 0;
				}

			} catch (SQLException s1) {s1.printStackTrace();} finally {
				// if(rs!=null)try {rs.close();}catch(SQLException ss) {}
				if (pstmt != null)try {pstmt.close();} catch (SQLException ss) {}
				if (con != null)try {con.close();} catch (SQLException ss) {}
			}
			return check;
		}
	//end loginCheck

	//DB로부터 지정한 id의 회원정보를 가져오는 메소드
		public LoginVO getMemebr(String id) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			LoginVO vo = null;
			
			try {
				con=getConnection();
				pstmt=con.prepareStatement("select * from S_MEMBER where M_id=?");
				//바인딩 ?부분 처리
				pstmt.setString(1, id);
				rs=pstmt.executeQuery();
				//해당 id 존재의 유무 확인
				if(rs.next()) {
					vo = new LoginVO();
					vo.setMemCode(rs.getString("M_MEMCODE"));
					vo.setId(rs.getString("M_ID"));
					vo.setPw(rs.getString("M_PW"));
					vo.setName(rs.getString("M_NAME"));
					vo.setLanName(rs.getString("M_LANNAME"));
					vo.setLevel(rs.getString("M_LEVEL"));
					vo.setEmail(rs.getString("M_EMAIL"));
					vo.setPhone(rs.getString("M_PHONE"));
				}
			} catch (SQLException s1) {
				s1.printStackTrace();
			} finally {
				 if(rs!=null)try {rs.close();}catch(SQLException ss) {}
				if (pstmt != null)
					try {pstmt.close();} catch (SQLException ss) {}
				if (con != null)try {con.close();} catch (SQLException ss) {}
			}
			return vo;	
		}//end getMember;
		
		//정보 수정버튼을 클릭했을때 데이터베이스에 update를 수행함
		//정보를 수정처리할 메소드 구현
		public void updateMember(LoginVO vo) {
			
			Connection con=null;
			PreparedStatement pstmt=null;
			try {
				con=getConnection();
				String strQuery="update S_MEMBER set M_PW=?, M_LANNAME=?, M_LEVEL=?, "
						+ "M_EMAIL=?, M_PHONE=? where M_ID=?";
				pstmt=con.prepareStatement(strQuery);
				pstmt.setString(1, vo.getPw());
				pstmt.setString(2, vo.getLanName());
				pstmt.setString(3, vo.getLevel());
				pstmt.setString(4, vo.getEmail());
				pstmt.setString(5, vo.getPhone());
				pstmt.setString(6, vo.getId());
				pstmt.executeUpdate();
			} catch (SQLException s1) {
				s1.printStackTrace();
			} finally {
				if (pstmt != null)try {pstmt.close();} catch (SQLException ss) {}
				if (con != null)try {con.close();} catch (SQLException ss) {}
			}//end updateMember
		}
		//회원탈퇴 버튼을 클릭하면 회원의 비밀번호를 입력받앗어 데이터베이스의 비밀번화와 일치하는지를 비교
		//일치한다면 회원 탈퇴 처리가 완료, 그렇지 않으면 비밀번호가 틀렸다고 알려줌;
		public int deleteMember(String id, String pw) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String dbPass="";
			String memcode;
			int result = -1;
			try {
				con = getConnection();
				String strQuery = "select M_PW from s_member where M_id = ?";
				pstmt = con.prepareStatement(strQuery);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					dbPass = rs.getString("M_PW"); // 데이터베이스에서 가져온 비밀번호
					if (dbPass.equals(pw)) {
						pstmt=con.prepareStatement("select m_memcode from s_member where m_id=?");
						pstmt.setString(1, id);
						rs=pstmt.executeQuery();
						if(rs.next()) {
						memcode=rs.getString("m_memcode");
						pstmt=con.prepareStatement("delete from s_resist where m_memcode=?");
						pstmt.setString(1, memcode);
						pstmt.executeUpdate();
						pstmt=con.prepareStatement("delete from s_join where m_memcode=?");
						pstmt.setString(1, memcode);
						pstmt.executeUpdate();
						pstmt=con.prepareStatement("delete from s_member where M_id=?");
						pstmt.setString(1, id);
						pstmt.executeUpdate();
						}
						result=1;//회원 탈퇴성공
					}else //본인 확인 실패-비밀번호 오류
						result = 0;
				}

			} catch (SQLException s1) {
				s1.printStackTrace();
			} finally {
				if(rs!=null)try {rs.close();}catch(SQLException ss) {}
				if (pstmt != null)try {pstmt.close();} catch (SQLException ss) {}
				if (con != null)try {con.close();} catch (SQLException ss) {}
			}
			return result;
		}
		//id검색에 따른 멤버코드 멤버 네임 불러오는 메소드
		public LoginVO getinstance(String id) {
			Connection con = null;
			PreparedStatement pstmt=null;
			ResultSet rs = null;
			LoginVO vo = null;
			try {
				con=getConnection();
				String strQuery="select M_MemCode, M_NAME from S_MEMBER where M_ID=?";
				pstmt=con.prepareStatement(strQuery);
				pstmt.setString(1, id);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					vo = new LoginVO();
					vo.setMemCode(rs.getString("M_MEMCODE"));
					vo.setName(rs.getString("M_NAME"));
				}
			} catch (SQLException s1) {
				s1.printStackTrace();
			} finally {
				 if(rs!=null)try {rs.close();}catch(SQLException ss) {}
				if (pstmt != null)try {pstmt.close();} catch (SQLException ss) {}
				if (con != null)try {con.close();} catch (SQLException ss) {}
			}
			return vo;	
		}

		
	}
	
	