package MyStudy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class MyStudyDAO {

	private static MyStudyDAO instance = null;
	private MyStudyDAO() {
		
	}
	public static MyStudyDAO  getInstance() {
		if(instance==null) {
			synchronized(MyStudyDAO.class) {
				instance = new MyStudyDAO();
			}
		}
		return instance;
	}
	// singletone 싱글톤
	
	
	public int getArticleCount() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x =0;
		
		try {
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement("select count(*) from S_RESIST WHERE 수락여"); // 회원코드에서 수락여부 0 인 스터디 번호와 신청번호에서 수락여부 0 인 스터디 번호의 카운트
			rs=pstmt.executeQuery();
			if(rs.next()) {
				x= rs.getInt(1);
			}
		}catch(Exception ee) {
			ee.printStackTrace();
		}finally {
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
		return x; //x==글의 전체 갯수
	}//end getArticleCount()
	// 글 카운트 
	public List<MyStudyVO> getArticles(int start, int end){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MyStudyVO> articleList=null;
		
		try {
			con = ConnUtil.getConnection();
			//가장 최근에 입력한 글이 가장 처음으로 오게 내림차순 정렬하는 구문
//			pstmt = con.prepareStatement("select * from board order by num desc");
			pstmt = con.prepareStatement("select * from (select rownum rnum, num, writer, email, subject, pass, regdate, readcount, ref, step, depth, content, ip from "
					+ "(select * from board order by ref desc, step asc)) where rnum >=? and rnum <=?");//where뒤 rnum앞에가 start, 뒤의 rnum이 end값을 바인딩;"
							// 스터디 글 가져오는구문 
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				articleList = new ArrayList<MyStudyVO>(end-start+1); //end-start+1 -> 한 화면(페이지)에 나오는 게시글의 갯수
				do {
					MyStudyVO article = new MyStudyVO();
					//데이터베이스 값에서 가져옴
					article.setS_JOINCODE(rs.getString("S_JOINCODE"));
					article.setM_MEMCODE(rs.getString("M_MEMCODE"));
					article.setSJ_TITLE(rs.getString("SJ_TITLE"));
					article.setSJ_CONTENT(rs.getString("SJ_CONTENT"));
					article.setSJ_SUBMITYN(rs.getString("SJ_SUBMITYN"));
					article.setS_STUDYCODE(rs.getString("S_STUDYCODE"));
					article.setM_NAME(rs.getString("M_NAME"));
					article.setS_TITLE(rs.getString("S_TITLE"));
					article.setS_CONTENT(rs.getString("S_CONTENT"));
					article.setS_AREA(rs.getString("S_AREA"));
					article.setS_LANNAME(rs.getString("S_LANNAME"));
					article.setS_PARTTIME(rs.getString("S_PARTTIME"));
					article.setS_CHATLINK(rs.getString("S_CHATLINK"));
					article.setS_CHATLINK(rs.getString("S_CHATLINK"));
					article.setS_DELETEYN(rs.getString("S_DELETEYN"));
					article.setS_STARTDAY(rs.getString("S_STARTDAY"));
					article.setS_ENDDAY(rs.getString("S_ENDDAY"));
					article.setS_WRITEDAY(rs.getTimestamp("S_WRITEDAY"));
					article.setSJ_DATE(rs.getTimestamp("SJ_DATE"));
					article.setS_UPDATEDAY(rs.getTimestamp("S_UPDATEDAY"));
					article.setS_COUNT(rs.getInt("S_COUNT"));
					//리스트에 추가
					articleList.add(article);
				}while(rs.next());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
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
		return articleList;
	}//end list
	// 스터디 목록 가져오기 
	
	public MyStudyVO updateGetArticle2(int num) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MyStudyVO article = null;
		
		try {
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement("select * from board where num=?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				article = new BoardVO();
				article.setNum(rs.getInt("num"));
				article.setWriter(rs.getString("writer"));
				article.setEmail(rs.getString("email"));
				article.setSubject(rs.getString("subject"));
				article.setPass(rs.getString("pass"));
				article.setReadcount(rs.getInt("readcount"));
				article.setRef(rs.getInt("ref"));
				article.setStep(rs.getInt("step"));
				article.setDepth(rs.getInt("depth"));
				article.setRegdate(rs.getTimestamp("regdate"));
				article.setContent(rs.getString("content"));
				article.setIp(rs.getString("ip"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null)try {rs.close();}catch(SQLException ss) {}
			if(pstmt != null)try {pstmt.close();}catch(SQLException ss) {}
			if(con != null)try {con.close();}catch(SQLException ss) {}
		}
		return article;
	}
	// 후기 작성하기
	
	public MyStudyVO getArticle(int num) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MyStudyVO article = null;
		
		try {
			con=ConnUtil.getConnection();
			pstmt = con.prepareStatement("update board set readcount = readcount+1 where num=?");
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			
			pstmt = con.prepareStatement("select * from S_RESIST where num=?"); // 스터디 코드로 바꿔야함
			pstmt.setInt(1,num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				article = new MyStudyVO();
				article.setS_JOINCODE(rs.getString("S_JOINCODE"));
				article.setM_MEMCODE(rs.getString("M_MEMCODE"));
				article.setSJ_TITLE(rs.getString("SJ_TITLE"));
				article.setSJ_CONTENT(rs.getString("SJ_CONTENT"));
				article.setSJ_SUBMITYN(rs.getString("SJ_SUBMITYN"));
				article.setS_STUDYCODE(rs.getString("S_STUDYCODE"));
				article.setM_NAME(rs.getString("M_NAME"));
				article.setS_TITLE(rs.getString("S_TITLE"));
				article.setS_CONTENT(rs.getString("S_CONTENT"));
				article.setS_AREA(rs.getString("S_AREA"));
				article.setS_LANNAME(rs.getString("S_LANNAME"));
				article.setS_PARTTIME(rs.getString("S_PARTTIME"));
				article.setS_CHATLINK(rs.getString("S_CHATLINK"));
				article.setS_CHATLINK(rs.getString("S_CHATLINK"));
				article.setS_DELETEYN(rs.getString("S_DELETEYN"));
				article.setS_STARTDAY(rs.getString("S_STARTDAY"));
				article.setS_ENDDAY(rs.getString("S_ENDDAY"));
				article.setS_WRITEDAY(rs.getTimestamp("S_WRITEDAY"));
				article.setSJ_DATE(rs.getTimestamp("SJ_DATE"));
				article.setS_UPDATEDAY(rs.getTimestamp("S_UPDATEDAY"));
				article.setS_COUNT(rs.getInt("S_COUNT"));
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(rs !=null)try {rs.close();}catch(SQLException ss) {}
			if(con !=null)try {con.close();}catch(SQLException ss) {}
			if(pstmt !=null)try {pstmt.close();}catch(SQLException ss) {}
		}
		return article;
	}//end getArticle
	// 글 보기 
	public MyStudyVO updateGetArticle(int num) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MyStudyVO article = null;
		
		try {
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement("select * from S_RESIST where num=?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				article = new MyStudyVO();
				article.setS_JOINCODE(rs.getString("S_JOINCODE"));
				article.setM_MEMCODE(rs.getString("M_MEMCODE"));
				article.setSJ_TITLE(rs.getString("SJ_TITLE"));
				article.setSJ_CONTENT(rs.getString("SJ_CONTENT"));
				article.setSJ_SUBMITYN(rs.getString("SJ_SUBMITYN"));
				article.setS_STUDYCODE(rs.getString("S_STUDYCODE"));
				article.setM_NAME(rs.getString("M_NAME"));
				article.setS_TITLE(rs.getString("S_TITLE"));
				article.setS_CONTENT(rs.getString("S_CONTENT"));
				article.setS_AREA(rs.getString("S_AREA"));
				article.setS_LANNAME(rs.getString("S_LANNAME"));
				article.setS_PARTTIME(rs.getString("S_PARTTIME"));
				article.setS_CHATLINK(rs.getString("S_CHATLINK"));
				article.setS_CHATLINK(rs.getString("S_CHATLINK"));
				article.setS_DELETEYN(rs.getString("S_DELETEYN"));
				article.setS_STARTDAY(rs.getString("S_STARTDAY"));
				article.setS_ENDDAY(rs.getString("S_ENDDAY"));
				article.setS_WRITEDAY(rs.getTimestamp("S_WRITEDAY"));
				article.setSJ_DATE(rs.getTimestamp("SJ_DATE"));
				article.setS_UPDATEDAY(rs.getTimestamp("S_UPDATEDAY"));
				article.setS_COUNT(rs.getInt("S_COUNT"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null)try {rs.close();}catch(SQLException ss) {}
			if(pstmt != null)try {pstmt.close();}catch(SQLException ss) {}
			if(con != null)try {con.close();}catch(SQLException ss) {}
		}
		return article;
	}
	// 글 수정하기 
	public int deleteArticle(int num, String pass) {
		Connection con = null;
		PreparedStatement pstmt =null;
		ResultSet rs=null;
		String dbpasswd ="";
		int result = -1;
		try {
			con=ConnUtil.getConnection();
			pstmt=con.prepareStatement("select pass from S_RESIST where num=?");
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				dbpasswd=rs.getString("pass");
				if(dbpasswd.equals(pass)) {
					pstmt= con.prepareStatement("delete from S_RESIST where num=?");
					pstmt.setInt(1, num);
					pstmt.executeUpdate();
					result=1;
				}else {
					result=0;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null)try {rs.close();}catch(SQLException ss) {}
			if(pstmt != null)try {pstmt.close();}catch(SQLException ss) {}
			if(con != null)try {con.close();}catch(SQLException ss) {}
		}
		return result;
	}
	// 글 삭제하기 
	
}
