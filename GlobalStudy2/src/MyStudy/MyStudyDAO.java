package MyStudy;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import MyStudy.MyStudyVO;
import StudyRoom.StudyRoomVO;
import MyStudy.ConnUtil;



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
	
	
	public int getArticleCount(String code) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x =0;
		
		try {
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement(" select count(*) from S_RESIST r inner join S_JOIN j on r.S_STUDYCODE =j.S_STUDYCODE and j.SJ_SUBMITYN='Y' and j.M_MEMCODE=?"); //  신청번호에서 수락여부 0 인 스터디 번호의 카운트
			pstmt.setString(1, code); 
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
	// 스터디 정보 목록 카운트 
	
	
	public int getArticleCount2(String code) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x =0;
		
		try {
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement(" select count(*) from S_RESIST where M_MEMCODE=?"); //  신청번호에서 수락여부 0 인 스터디 번호의 카운트
			pstmt.setString(1, code); 
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
	// 스터디 관리 목록 카운트 
	
	public int getArticleCount3(String code) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x =0;
		
		try {
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement(" select count(*) from S_RESIST r inner join S_JOIN j on r.S_STUDYCODE =j.S_STUDYCODE and j.SJ_SUBMITYN='N' and j.M_MEMCODE=?"); //  신청번호에서 수락여부 0 인 스터디 번호의 카운트
			pstmt.setString(1, code); 
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
	// 스터디 신청 목록 카운트 
	
	public int getArticleCount4(String code) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x =0;
		
		try {
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement(" select count(S_JOIN.S_JOINCODE) from  S_RESIST inner join S_JOIN on S_RESIST.S_STUDYCODE =S_JOIN.S_STUDYCODE and S_JOIN.SJ_SUBMITYN='Y' and S_RESIST.S_STUDYCODE=?"); //  신청번호에서 수락여부 0 인 스터디 번호의 카운트
			pstmt.setString(1, code); 
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
	// 스터디 관리 멤버 카운트 
	
	
	public List<MyStudyVO> getArticles(int start, int end, String code){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MyStudyVO> articleList=null;
		
		try {
			con = ConnUtil.getConnection();
			//가장 최근에 입력한 글이 가장 처음으로 오게 내림차순 정렬하는 구문
//			pstmt = con.prepareStatement("select * from board order by num desc");
			pstmt = con.prepareStatement("select * from (select rownum rnum, r.S_STUDYCODE, r.M_NAME, r.S_TITLE, r.S_AREA, r.S_LANNAME, r.S_PARTTIME, r.S_WRITEDAY,j.M_MEMCODE, j.SJ_SUBMITYN from S_RESIST r inner join S_JOIN j on r.S_STUDYCODE =j.S_STUDYCODE  and j.M_MEMCODE=? and j.SJ_SUBMITYN='Y') where rnum >=? and rnum <=?");
							// 스터디 글 가져오는구문 
			pstmt.setString(1, code);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				articleList = new ArrayList<MyStudyVO>(end-start+1); //end-start+1 -> 한 화면(페이지)에 나오는 게시글의 갯수
				do {
					MyStudyVO article = new MyStudyVO();
					//데이터베이스 값에서 가져옴
					article.setS_STUDYCODE(rs.getInt("s_STUDYCODE"));
					article.setM_NAME(rs.getString("m_NAME"));
					article.setS_TITLE(rs.getString("s_TITLE"));
					article.setS_AREA(rs.getString("s_AREA"));
					article.setS_LANNAME(rs.getString("s_LANNAME"));
					article.setS_PARTTIME(rs.getString("s_PARTTIME"));	
					article.setS_WRITEDAY(rs.getTimestamp("s_WRITEDAY"));
					
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
	// 스터디 정보 목록 가져오기 
	
	public List<MyStudyVO> getArticles2(int start, int end, String code){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MyStudyVO> articleList=null;
		
		try {
			con = ConnUtil.getConnection();
			//가장 최근에 입력한 글이 가장 처음으로 오게 내림차순 정렬하는 구문
//			pstmt = con.prepareStatement("select * from board order by num desc");
			pstmt = con.prepareStatement("select * from (select rownum rnum, r.S_STUDYCODE, r.M_NAME, r.S_TITLE, r.S_AREA, r.S_LANNAME, r.S_PARTTIME, r.S_WRITEDAY,r.M_MEMCODE from S_RESIST r where r.M_MEMCODE=?) where rnum >=? and rnum <=?");
							// 스터디 글 가져오는구문 
			pstmt.setString(1, code);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				articleList = new ArrayList<MyStudyVO>(end-start+1); //end-start+1 -> 한 화면(페이지)에 나오는 게시글의 갯수
				do {
					MyStudyVO article = new MyStudyVO();
					//데이터베이스 값에서 가져옴
					article.setS_STUDYCODE(rs.getInt("s_STUDYCODE"));
					article.setM_NAME(rs.getString("m_NAME"));
					article.setS_TITLE(rs.getString("s_TITLE"));
					article.setS_AREA(rs.getString("s_AREA"));
					article.setS_LANNAME(rs.getString("s_LANNAME"));
					article.setS_PARTTIME(rs.getString("s_PARTTIME"));	
					article.setS_WRITEDAY(rs.getTimestamp("s_WRITEDAY"));
					
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

	public List<MyStudyVO> getArticles3(int start, int end, String code){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MyStudyVO> articleList=null;
		
		try {
			con = ConnUtil.getConnection();
			//가장 최근에 입력한 글이 가장 처음으로 오게 내림차순 정렬하는 구문
//			pstmt = con.prepareStatement("select * from board order by num desc");
			pstmt = con.prepareStatement("select * from (select rownum rnum, j.S_JOINCODE, j.SJ_NAME, j.SJ_TITLE,  r.S_LANNAME, j.SJ_DATE, j.M_MEMCODE, j.SJ_SUBMITYN from S_RESIST r inner join S_JOIN j on r.S_STUDYCODE =j.S_STUDYCODE  and j.M_MEMCODE=? and j.SJ_SUBMITYN='N') where rnum >=? and rnum <=?");
			pstmt.setString(1, code);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				articleList = new ArrayList<MyStudyVO>(end-start+1); //end-start+1 -> 한 화면(페이지)에 나오는 게시글의 갯수
				do {
					MyStudyVO article = new MyStudyVO();
					//데이터베이스 값에서 가져옴
					article.setS_JOINCODE(rs.getInt("s_JOINCODE"));
					article.setSj_NAME(rs.getString("sj_NAME"));
					article.setSj_TITLE(rs.getString("sj_TITLE"));
					article.setS_LANNAME(rs.getString("s_LANNAME"));
					article.setSj_DATE(rs.getTimestamp("sj_DATE"));	
					article.setSj_SUBMITYN(rs.getString("sj_SUBMITYN"));
					
				
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
	// 스터디 신청 목록 가져오기 
	
	
	public List<MyStudyVO> getArticles4(int start, int end, String code){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MyStudyVO> articleList=null;
		
		try {
			con = ConnUtil.getConnection();
			//가장 최근에 입력한 글이 가장 처음으로 오게 내림차순 정렬하는 구문
//			pstmt = con.prepareStatement("select * from board order by num desc");
			pstmt = con.prepareStatement("select * from (select rownum rnum, j.S_JOINCODE, j.SJ_NAME, j.SJ_TITLE,  r.S_LANNAME, j.SJ_DATE, j.M_MEMCODE, j.SJ_SUBMITYN from S_RESIST r inner join S_JOIN j on r.S_STUDYCODE =j.S_STUDYCODE  and r.S_STUDYCODE=? and j.SJ_SUBMITYN='Y') where rnum >=? and rnum <=?");
			pstmt.setString(1, code);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				articleList = new ArrayList<MyStudyVO>(end-start+1); //end-start+1 -> 한 화면(페이지)에 나오는 게시글의 갯수
				do {
					MyStudyVO article = new MyStudyVO();
					//데이터베이스 값에서 가져옴
					article.setS_JOINCODE(rs.getInt("s_JOINCODE"));
					article.setSj_NAME(rs.getString("sj_NAME"));
					article.setSj_TITLE(rs.getString("sj_TITLE"));
					article.setS_LANNAME(rs.getString("s_LANNAME"));
					article.setSj_DATE(rs.getTimestamp("sj_DATE"));	
					article.setSj_SUBMITYN(rs.getString("sj_SUBMITYN"));
					
				
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
	// 스터디 신청 목록 가져오기 
	
public List<MyStudyVO> getArticles5(int start, int end, String code){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MyStudyVO> articleList=null;
		
		try {
			con = ConnUtil.getConnection();
			//가장 최근에 입력한 글이 가장 처음으로 오게 내림차순 정렬하는 구문
//			pstmt = con.prepareStatement("select * from board order by num desc");
			pstmt = con.prepareStatement("select * from (select rownum rnum, r.S_STUDYCODE, j.SJ_NAME, r.S_AREA, r.S_LANNAME, j.SJ_JOINDAY, j.S_JOINCODE from S_RESIST r  inner join S_JOIN j on r.S_STUDYCODE =j.S_STUDYCODE and j.S_STUDYCODE=?  and j.SJ_SUBMITYN='Y') where rnum >=? and rnum <=?");
			pstmt.setString(1, code);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				articleList = new ArrayList<MyStudyVO>(end-start+1); //end-start+1 -> 한 화면(페이지)에 나오는 게시글의 갯수
				do {
					MyStudyVO article = new MyStudyVO();
					//데이터베이스 값에서 가져옴
					article.setS_LANNAME(rs.getString("s_LANNAME"));
					article.setS_AREA(rs.getString("s_AREA"));
					article.setSj_NAME(rs.getString("sj_NAME"));
					article.setSj_JOINDAY(rs.getTimestamp("sj_JOINDAY"));
					article.setS_JOINCODE(rs.getInt("s_JOINCODE"));
				
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
	// 스터디 멤버 목록 가져오기 
	
	public MyStudyVO getArticle(int code) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MyStudyVO article = null;
		
		try {
			con=ConnUtil.getConnection();

			//pstmt.close();
			
			pstmt = con.prepareStatement("select * from S_RESIST where s_STUDYCODE=?"); // 스터디 코드로 바꿔야함
			pstmt.setInt(1, code); 
			rs=pstmt.executeQuery();
			if(rs.next()) {
				article = new MyStudyVO();
				article.setM_MEMCODE(rs.getString("m_MEMCODE"));
				article.setS_STUDYCODE(rs.getInt("s_STUDYCODE"));
				article.setM_NAME(rs.getString("m_NAME"));
				article.setS_TITLE(rs.getString("s_TITLE"));
				article.setS_CONTENT(rs.getString("s_CONTENT"));
				article.setS_AREA(rs.getString("s_AREA"));
				article.setS_LANNAME(rs.getString("s_LANNAME"));
				article.setS_PARTTIME(rs.getString("s_PARTTIME"));
				article.setS_CHATLINK(rs.getString("s_CHATLINK"));
				article.setS_WEEK(rs.getString("s_WEEK"));
				article.setS_DELETEYN(rs.getString("s_DELETEYN"));
				article.setS_STARTDAY(rs.getString("s_STARTDAY"));
				article.setS_ENDDAY(rs.getString("s_ENDDAY"));
				article.setS_WRITEDAY(rs.getTimestamp("s_WRITEDAY"));
				article.setS_COUNT(rs.getInt("s_COUNT"));
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
	// 스터디 정보 보기 
	
	public MyStudyVO getArticle2(int num) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MyStudyVO article = null;
		
		try {
			con=ConnUtil.getConnection();
			//pstmt.close();
			
			pstmt = con.prepareStatement("select * from S_JOIN where S_JOINCODE=?"); // 스터디 코드로 바꿔야함
			pstmt.setInt(1, num); 
			rs=pstmt.executeQuery();
			if(rs.next()) {
				article = new MyStudyVO();
				article.setSj_TITLE(rs.getString("sj_TITLE"));
				article.setSj_NAME(rs.getString("sj_NAME"));
				article.setSj_DATE(rs.getTimestamp("sj_DATE"));	
				article.setSj_CONTENT(rs.getString("sj_CONTENT"));
				article.setSj_SUBMITYN(rs.getString("sj_SUBMITYN"));
				
				
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
	// 스터디 신청 정보 보기 
	
	public void insertArticle( MyStudyVO vo) {
		
		Connection con = null;
		PreparedStatement pstmt =null;
		
		String sql = "";
		try {
			con=ConnUtil.getConnection();
		
			sql="insert into S_JOIN (S_JOINCODE, S_STUDYCODE,  M_MEMCODE, SJ_NAME, SJ_DATE, SJ_TITLE, SJ_CONTENT, SJ_SUBMITYN)"
					+ " values(S_JOIN_seq.NEXTVAL,?,?,?,sysdate,?,?,'N')";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, vo.getS_STUDYCODE());
			pstmt.setString(2, vo.getM_MEMCODE());
			pstmt.setString(3, vo.getSj_NAME());
			pstmt.setString(4, vo.getSj_TITLE());
			pstmt.setString(5, vo.getSj_CONTENT());
			pstmt.executeUpdate();
			
			
			
		}catch(Exception ee) {
			ee.printStackTrace();
		}finally {
			if(con != null)try {con.close();} catch (SQLException ss) {}
			if(pstmt != null)try {pstmt.close();} catch (SQLException ss) {}
				}
		
		
	}//end insertArticle
	/* 스터디 신청 작성 
	 * 글을 작성하고 수행하면 list.jsp페이지로 리다이렉트함
	 * 따라서 수행 결과를 보려고하면 list.jsp 페이지를 작성해야함
	 * 1. 전체 글의 개수를 가져오는 메소드가 필요함(글 목록을 작성해야하므로 총 글이 몇개 있는지를 먼저 알아야함)
	 * getArticleCount();
	 * 
	 * 데이터를 가져오는 메소드를 구현해야함
	 * List로 목록 가져오는 메소드 구현
	 * 
	 */
	
	public void updateArticle(MyStudyVO article) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnUtil.getConnection();
			pstmt=con.prepareStatement("update S_RESIST set m_NAME=?, s_TITLE=?, s_AREA=?, s_LANNAME=?, S_WEEK=?,  S_PARTTIME=?, S_STARTDAY=?, S_ENDDAY=?, S_WRITEDAY=?, S_CONTENT=? where s_STUDYCODE=?");
					pstmt.setString(1, article.getM_NAME());
					pstmt.setString(2, article.getS_TITLE());
					pstmt.setString(3, article.getS_AREA());
					pstmt.setString(4, article.getS_LANNAME());
					pstmt.setString(5, article.getS_WEEK());
					pstmt.setString(6, article.getS_PARTTIME());
					pstmt.setString(7, article.getS_STARTDAY());
					pstmt.setString(8, article.getS_ENDDAY());
					pstmt.setTimestamp(9, article.getS_WRITEDAY());
					pstmt.setString(10, article.getS_CONTENT());
					pstmt.executeUpdate();
				
	 }catch(Exception e) {
		 e.printStackTrace();
	 }finally {
		 if(con!=null)try{con.close();}catch(SQLException e) {}
		 if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {}	
	 }
	}
	// 스터디 정보 수정하기 
	
	public void deleteArticle(int code) {
		Connection con = null;
		PreparedStatement pstmt =null;
	
		try {
			con=ConnUtil.getConnection();
			pstmt= con.prepareStatement("delete from R_RESIST where S_STUDYCODE=?");
			pstmt.setInt(1, code);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null)try {pstmt.close();}catch(SQLException ss) {}
			if(con != null)try {con.close();}catch(SQLException ss) {}
		}
	}
	// 스터디
	// 스터디 정보 삭제하기 
	
	public void deleteArticle2(int code) {
		Connection con = null;
		PreparedStatement pstmt =null;
	
		try {
			con=ConnUtil.getConnection();
			pstmt= con.prepareStatement("delete from S_JOIN where S_JOINCODE=?");
			pstmt.setInt(1, code);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null)try {pstmt.close();}catch(SQLException ss) {}
			if(con != null)try {con.close();}catch(SQLException ss) {}
		}
	}
	// 스터디 신청 정보 삭제하기 
	
	public void deleteArticle3(int code) {
		Connection con = null;
		PreparedStatement pstmt =null;
	
		try {
			con=ConnUtil.getConnection();
			pstmt= con.prepareStatement("delete from S_JOIN where S_JOINCODE=?");
			pstmt.setInt(1, code);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null)try {pstmt.close();}catch(SQLException ss) {}
			if(con != null)try {con.close();}catch(SQLException ss) {}
		}
	}
	// 스터디 관리 정보 삭제하기
	
	public void updateStudy(int code){
		Connection con =null;
		PreparedStatement pstmt = null;
		MyStudyVO article = null;
		
		try {
			article = new MyStudyVO();
			con = ConnUtil.getConnection();
			pstmt=con.prepareStatement("update S_JOIN set Sj_SUBMITYN=?, SJ_JOINDAY=sysdate where S_JOINCODE=?");
			pstmt.setString(1, "Y");
			pstmt.setInt(2, code);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con != null)try {con.close();} catch (SQLException ss) {}
			if(pstmt != null)try {pstmt.close();} catch (SQLException ss) {}
		}
	}//update 신청 수락
	
	/*public MyStudyVO updateGetArticle2(String code) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MyStudyVO article = null;
		
		try {
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement("select * from S_RESIST where num=?");
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				article = new MyStudyVO();
				article.setS_JOINCODE(rs.getString("S_JOINCODE"));
				article.setM_MEMCODE(rs.getString("M_MEMCODE"));
				article.setSj_TITLE(rs.getString("SJ_TITLE"));
				article.setSj_CONTENT(rs.getString("SJ_CONTENT"));
				article.setSj_SUBMITYN(rs.getString("SJ_SUBMITYN"));
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
				article.setSj_DATE(rs.getTimestamp("SJ_DATE"));
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
	}*/
	// 후기 작성하기
}
