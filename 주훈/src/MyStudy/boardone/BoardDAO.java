package MyStudy;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.RETURN;
public class BoardDAO {

	private static BoardDAO instance = null;
	private BoardDAO() {
		
	}
	public static BoardDAO getInstance() {
		if(instance==null) {
			synchronized(BoardDAO.class) {
				instance = new BoardDAO();
			}
		}
		return instance;
	}
	//여기서 부터 게시판 작업의 기능 메소드를 추가해서 작성
	
	//실제 데이터베이스에 작성된 글을 추가하는 insert 메소드 구현
	public void insertArticle(BoardVO vo) {
		
		Connection con = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		
		int num = vo.getNum();
		int ref = vo.getRef();
		int step = vo.getStep();
		int depth = vo.getDepth();
		
		int number = 0;
		
		String sql = "";
		try {
			con=ConnUtil.getConnection();
			pstmt=con.prepareStatement("select max(num) from board");
			rs= pstmt.executeQuery();
			if(rs.next()){
				number =rs.getInt(1)+1;//새 글일때
			}else {
				number=1;//새글이 아닌경우
			}
			if(num !=0) {//답변글
				sql="update board set step=step+1 where ref=? and step > ?";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, ref);
				pstmt.setInt(2, step);
				
				pstmt.executeUpdate();
				step = step +1;
				depth = depth+1;
			}else {//새글인 경우
				ref=number;
				step = 0;
				depth = 0;
			}
			//새글을 추가하는 쿼리문을 작성  writer,email,subject,pass,regdate,ref,step,depth,content,ip
			sql="insert into board (num,writer,email,subject,pass,regdate,ref,step,depth,content,ip)"
					+ " values(board_seq.nextval, ?,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getSubject());
			pstmt.setString(4, vo.getPass());
			pstmt.setTimestamp(5, vo.getRegdate());
			pstmt.setInt(6, ref);
			pstmt.setInt(7, step);
			pstmt.setInt(8, depth);
			pstmt.setString(9, vo.getContent());
			pstmt.setString(10, vo.getIp());
			
			pstmt.executeUpdate();
			
			
			
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
		
	}//end insertArticle
	/*
	 * 글을 작성하고 수행하면 list.jsp페이지로 리다이렉트함
	 * 따라서 수행 결과를 보려고하면 list.jsp 페이지를 작성해야함
	 * 1. 전체 글의 개수를 가져오는 메소드가 필요함(글 목록을 작성해야하므로 총 글이 몇개 있는지를 먼저 알아야함)
	 * getArticleCount();
	 * 
	 * 데이터를 가져오는 메소드를 구현해야함
	 * List로 목록 가져오는 메소드 구현
	 * 
	 */
	public int getArticleCount() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x =0;
		
		try {
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement("select count(*) from board");
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
	/*
	 * 한 화면에 보여질 게시글을 정하고 일정 블럭으로 묶는 작업
	 * ex)총30개의 게시글이 있는경우-> 1페이지는 1~5번 게시글이 보이고 2페이지는6~11페이지가 보이는 식..
	 */
	public List<BoardVO> getArticles(int start, int end){
		
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
	
	/*
	 * lilst.jsp페이지에서 글 제목을 클릭했을 경우 글 내용을 볼수 있도록 구현
	 * 글의 번호를 매개변수로해서 하나의 글에대한 세부 정보를 데이터베이스에서 가져와야함
	 */
	public BoardVO getArticle(int num) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO article = null;
		
		try {
			con=ConnUtil.getConnection();
			pstmt = con.prepareStatement("update board set readcount = readcount+1 where num=?");
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			
			pstmt = con.prepareStatement("select * from board where num=?");
			pstmt.setInt(1,num);
			rs=pstmt.executeQuery();
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
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(rs !=null)try {rs.close();}catch(SQLException ss) {}
			if(con !=null)try {con.close();}catch(SQLException ss) {}
			if(pstmt !=null)try {pstmt.close();}catch(SQLException ss) {}
		}
		return article;
	}//end getArticle
	/*
	 * 글 내용보는 화면에서 수정 버튼을 클릭한 경우 updateForm.jsp로 이동하도록 링크
	 * 따라서 수정 화면을 만들어야함
	 * 
	 * 글 수정시에는 글 목록 보기와 다르게 조회수를 증가실 필요가 없다.
	 * 즉 조회수를 증가시키는 부분을 제외하고 단순한 num에 해당하는 글을 가져오는 메소드를 구현함(어떤 글을 선택했는지를 num으로 구분)
	 */
	public BoardVO updateGetArticle(int num) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO article = null;
		
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
	}//end updateGetArticle
	
	//글의 수정 성공시 1를 반환, 수정이 실패시 0을 반환
	public int updateArticle(BoardVO article) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//DB에서 작성한 글의 비밀번호를 가져와서 비교해야하므로 그것을 받을 변수선언
		String dbpasswd="";
		String sql="";
		//result ==0 비밀번호 틀림, 1 비밀번호 맞음, -1==비밀번호 미입력
		int result= -1;
		
		try {
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement("select pass from board where num=?");
			pstmt.setInt(1, article.getNum());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dbpasswd=rs.getString("pass");
				if(dbpasswd.equals(article.getPass())){
					sql = "update board set writer=?,email=?,subject=?,content=? where num=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, article.getWriter());
					pstmt.setString(2, article.getEmail());
					pstmt.setString(3, article.getSubject());
					pstmt.setString(4, article.getContent());
					pstmt.setInt(5, article.getNum());
					pstmt.executeUpdate();
					result =1;
				}else {
					result =0;
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
		
	}//end updateArticle
	/*
	 * 글삭제 처리
	 * 글 삭제화면에서 비밀번호를 입력하고 글삭제 버튼을 클릭하면 삭제를 처리함
	 * 만약 비밀번호 일치하지 않으면 삭제 실패
	 */
	public int deleteArticle(int num, String pass) {
		Connection con = null;
		PreparedStatement pstmt =null;
		ResultSet rs=null;
		String dbpasswd ="";
		int result = -1;
		try {
			con=ConnUtil.getConnection();
			pstmt=con.prepareStatement("select pass from board where num=?");
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				dbpasswd=rs.getString("pass");
				if(dbpasswd.equals(pass)) {
					pstmt= con.prepareStatement("delete from board where num=?");
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
	}// end deleteArticle
	
	//검색한 내용이 몇개인지 반환하는 메소드 구현(매개변수 : 검색조건, 검색내용)
	public int getArticleCount(String what, String content) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x =0;
		
		try {
			con = ConnUtil.getConnection();
//			pstmt = con.prepareStatement("select count(*) from board");
			pstmt = con.prepareStatement("select count(*) from board where "+what+" like '%"+content+"%'");
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
	}
	//검색한 내용을 리스트로 받아옴(whar:검색조건, content : 검색내용, start: 시작번호, end 끝번호)
public List<BoardVO> getArticles(String what, String content, int start, int end){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVO> articleList=null;
		
		try {
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement("select * from (select rownum rnum, num, writer, email, subject, pass, regdate, readcount, ref, step, depth, content, ip from "
				+ "(select * from board where "+what+" like '%"+content+"%' order by ref desc, step asc)) where rnum >=? and rnum <=?");
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
	
	
}

