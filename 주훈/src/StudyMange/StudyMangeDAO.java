package StudyMange;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import MyStudy.ConnUtil;
import MyStudy.MyStudyVO;



public class StudyMangeDAO {

	private static StudyMangeDAO instance = null;
	private StudyMangeDAO() {
		
	}
	public static StudyMangeDAO  getInstance() {
		if(instance==null) {
			synchronized(StudyMangeDAO.class) {
				instance = new StudyMangeDAO();
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
			pstmt = con.prepareStatement("select count(*) from board"); // 해당 스터디번호에서 수락여부가 있는 회원수 
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
	// 관리 카운트 
	public int getArticleCount2() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x =0;
		
		try {
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement("select count(*) from board"); // 해당 스터디번호에서 신청코드에서 수락여부가 없는 회원 
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
	// 신청 카운트 
	public List<StudyMangeVO> getArticles(int start, int end){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<StudyMangeVO> articleList=null;
		
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
				articleList = new ArrayList<StudyMangeVO>(end-start+1); //end-start+1 -> 한 화면(페이지)에 나오는 게시글의 갯수
				do {
					StudyMangeVO article = new StudyMangeVO();
					//데이터베이스 값에서 가져옴
					article.setS_JOINCODE(rs.getString("S_JOINCODE"));
					article.setS_STUDYCODE(rs.getString("S_STUDYCODE"));
					article.setM_MEMCODE(rs.getString("M_MEMCODE"));
					article.setSJ_SUBMITYN(rs.getString("SJ_SUBMITYN"));
					article.setSJ_TITLE(rs.getString("SJ_TITLE"));
					article.setS_TITLE(rs.getString("S_TITLE"));
					article.setSJ_CONTENT(rs.getString("SJ_CONTENT"));
					article.setSC_JOINDAY(rs.getString("SC_JOINDAY"));
					article.setSC_RESIGNDAY(rs.getString("SC_RESIGNDAY"));
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
	// 스터디 관리 목록 가져오기 
	public StudyMangeVO getArticle(int num) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StudyMangeVO article = null;
		
		try {
			con=ConnUtil.getConnection();
			pstmt = con.prepareStatement("update board set readcount = readcount+1 where num=?");
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			
			pstmt = con.prepareStatement("select * from S_RESIST where num=?"); // 스터디 코드로 바꿔야함
			pstmt.setInt(1,num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				article = new StudyMangeVO();
				article.setS_JOINCODE(rs.getString("S_JOINCODE"));
				article.setS_STUDYCODE(rs.getString("S_STUDYCODE"));
				article.setM_MEMCODE(rs.getString("M_MEMCODE"));
				article.setSJ_SUBMITYN(rs.getString("SJ_SUBMITYN"));
				article.setSJ_TITLE(rs.getString("SJ_TITLE"));
				article.setS_TITLE(rs.getString("S_TITLE"));
				article.setSJ_CONTENT(rs.getString("SJ_CONTENT"));
				article.setSC_JOINDAY(rs.getString("SC_JOINDAY"));
				article.setSC_RESIGNDAY(rs.getString("SC_RESIGNDAY"));
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
	
	public List<StudyJoinVO> getArticles2(int start, int end){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVO> articleList=null;
		
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
				articleList = new ArrayList<BoardVO>(end-start+1); //end-start+1 -> 한 화면(페이지)에 나오는 게시글의 갯수
				do {
					BoardVO article = new BoardVO();
					//데이터베이스 값에서 가져옴
					article.setNum(rs.getInt("num"));
					article.setWriter(rs.getString("writer"));
					article.setEmail(rs.getString("email"));
					article.setSubject(rs.getString("subject"));
					article.setPass(rs.getString("pass"));
					article.setRegdate(rs.getTimestamp("regdate"));
					article.setReadcount(rs.getInt("readcount"));
					article.setRef(rs.getInt("ref"));
					article.setStep(rs.getInt("step"));
					article.setDepth(rs.getInt("depth"));
					article.setContent(rs.getString("content"));
					article.setIp(rs.getString("ip"));
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
	// 스터디 신청 가져오기 
	
}
