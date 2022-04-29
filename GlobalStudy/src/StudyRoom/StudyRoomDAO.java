package StudyRoom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;



public class StudyRoomDAO {
	// �떛湲��넠
	private static StudyRoomDAO instance = null;

	private StudyRoomDAO() {
	}

	public static StudyRoomDAO getInstance() {
		if (instance == null) {
			synchronized (StudyRoomDAO.class) {
				instance = new StudyRoomDAO();
			}
		}
		return instance;
	}
	
	//寃뚯떆�뙋 湲��쓽 媛��닔 
	public int getCount() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x =0;
		
		try {
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement("select count(*) from S_RESIST");
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
		return x; //x==湲��쓽 �쟾泥� 媛��닔
	}
	
	public int getCount(String LanName, String Area, String Level, String Week) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x =0;
		
		try {
			con = ConnUtil.getConnection();
			if(LanName==""&&Area==""&&Level==""&&Week=="") { 
				  pstmt = con.prepareStatement("select  count(*) from (select S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) " ); }
			
			//�뼵�뼱留� 寃��깋�븳寃쎌슦
			 if(LanName!=""&&Area==""&&Level==""&&Week=="") {
				pstmt = con.prepareStatement("select count(*)  from (select S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_LANNAME = ? ");
			    pstmt.setString(1, LanName);
			}
			//�뼵�뼱 +吏��뿭
			 if(LanName!=""&&Area!=""&&Level==""&&Week=="") {
				pstmt = con.prepareStatement("select count(*)  from (select S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_LANNAME = ? AND S_AREA =? ");
				pstmt.setString(1, LanName);
				pstmt.setString(2, Area);
			}
			//�뼵�뼱+�젅踰�
			 if(LanName!=""&&Area==""&&Level!=""&&Week=="") {
				pstmt = con.prepareStatement("select count(*)  from (select S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_LANNAME = ? and S_LEVEL = ? ");
				pstmt.setString(1, LanName);
				pstmt.setString(2, Level);
			}
			//�뼵�뼱+�슂�씪
			 if(LanName!=""&&Area==""&&Level==""&&Week!="") {
				pstmt = con.prepareStatement("select count(*)  from (select S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_LANNAME = ? and S_WEEK = ? ");
				pstmt.setString(1, LanName);
				pstmt.setString(2, Week);
			}
			//�뼵�뼱+吏��뿭+�젅踰�
			if(LanName!=""&&Area!=""&&Level!=""&&Week=="") {
				pstmt = con.prepareStatement("select count(*)  from (select S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_LANNAME = ? and S_AREA=? and S_LEVEL = ? ");
				pstmt.setString(1, LanName);
				pstmt.setString(2, Area);
				pstmt.setString(3, Level);
			}
			//�뼵�뼱+吏��뿭+�슂�씪
			 if(LanName!=""&&Area!=""&&Level==""&&Week!="") {
				pstmt = con.prepareStatement("select count(*)  from (select S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_LANNAME = ? and S_AREA=? and S_WEEK = ? ");
				pstmt.setString(1, LanName);
				pstmt.setString(2, Area);
				pstmt.setString(3, Week);
			}
			//�뼵�뼱+�젅踰�+�슂�씪
			 if(LanName!=""&&Area==""&&Level!=""&&Week!="") {
				pstmt = con.prepareStatement("select count(*)  from (select S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_LANNAME = ? and S_LEVEL = ? and S_WEEK=? ");
				pstmt.setString(1, LanName);
				pstmt.setString(2, Level);
				pstmt.setString(3, Week);
			}
			//吏��뿭留� 寃��깋�븳 寃쎌슦
			 if(LanName==""&&Area!=""&&Level==""&&Week=="") {
				pstmt = con.prepareStatement("select count(*)  from (select S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_AREA = ? ");
				pstmt.setString(1, Area);
			}
			//吏��뿭+�젅踰�
			 if(LanName==""&&Area!=""&&Level!=""&&Week=="") {
				pstmt = con.prepareStatement("select count(*)  from (select S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_AREA = ? and S_LEVEL=? ");
				pstmt.setString(1, Area);
				pstmt.setString(2, Level);
			}
			//吏��뿭+�슂�씪
			 if(LanName==""&&Area!=""&&Level==""&&Week!="") {
				pstmt = con.prepareStatement("select count(*)  from (select S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_AREA = ? and S_WEEK=? ");
				pstmt.setString(1, Area);
				pstmt.setString(2, Week);
			}
			//吏��뿭+�젅踰�+�슂�씪
			 if(LanName==""&&Area!=""&&Level!=""&&Week!="") {
				pstmt = con.prepareStatement("select count(*)  from (select S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_AREA = ? and S_LEVEL=? and S_WEEK=? ");
				pstmt.setString(1, Area);
				pstmt.setString(2, Level);
				pstmt.setString(3, Week);
			}
			//�젅踰⑤쭔 寃��깋�븳 寃쎌슦
			 if(LanName==""&&Area==""&&Level!=""&&Week=="") {
				pstmt = con.prepareStatement("select count(*)  from (select S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_LEVEL = ? ");
				pstmt.setString(1, Level);
			}
			//�젅踰�+�슂�씪
			 if(LanName==""&&Area==""&&Level!=""&&Week!="") {
				pstmt = con.prepareStatement("select count(*)  from (select S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_LEVEL = ? and S_WEEK=? ");
				pstmt.setString(1, Level);
				pstmt.setString(2, Week);
			}
			//�슂�씪留� 寃��깋�븳 寃쎌슦
			 if(LanName==""&&Area==""&&Level==""&&Week!="") {
				pstmt = con.prepareStatement("select count(*)  from (select S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_WEEK = ? ");
				pstmt.setString(1, Week);
			}
			//�뼵�뼱+吏��뿭+�젅踰�+�슂�씪
			 if(LanName!=""&&Area!=""&&Level!=""&&Week!="") {
				pstmt = con.prepareStatement("select count(*)  from (select S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_LANNAME=? and S_AREA=? and S_LEVEL = ? and S_WEEK=? ");
				pstmt.setString(1, LanName);
				pstmt.setString(2, Area);
				pstmt.setString(3, Level);
				pstmt.setString(4, Week);
			}
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
		return x; //x==湲��쓽 �쟾泥� 媛��닔
	}
	
	public ArrayList<StudyRoomVO> getArticles(){
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<StudyRoomVO> articleList = null; 
		
		try {
			con=ConnUtil.getConnection();
			//�대┝李⑥�� ���щ� 媛��� 理�洹� ���ν�� 湲��� 泥����쇰� �ㅺ���
			pstmt=con.prepareStatement("select * from (select S_STUDYCODE, S_COUNT, S_TITLE from S_RESIST order by S_COUNT desc) where rownum <= 5");
			rs=pstmt.executeQuery();
			
			//�곗�댄�곕��댁�ㅼ���� 媛��몄�� 媛��� studylist�� ����
			if(rs.next()) {
			articleList = new ArrayList<StudyRoomVO>();
			do {
				StudyRoomVO article = new StudyRoomVO();
				article.setTitle(rs.getString("S_TITLE"));
				article.setStudyCode(rs.getInt("S_STUDYCODE"));
				articleList.add(article);
			}while(rs.next());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con != null)try {con.close();} catch (SQLException ss) {}
			if(pstmt != null)try {pstmt.close();} catch (SQLException ss) {}
			if(rs != null)try {rs.close();} catch (SQLException ss) {}
		}
		return articleList;
	}
	
	
	
	// �뒪�꽣�뵒 insert 硫붿냼�뱶
	
	
	public void insertStudy(StudyRoomVO vo) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			StudyRoomVO studyRoom =null;
			int studycode;
			String sql="";
		//�벑濡앺럹�씠吏��뿉�꽌 �엯�젰諛쏅뒗 媛� �젣紐�,�궡�슜,吏��뿭,�뼵�뼱紐�,�뼵�뼱 �젅踰�, �슂�씪, �떆媛� , 梨꾪똿留곹겕
		//�뒪�꽣�뵒 踰덊샇, �옉�꽦�씪�옄 , 硫ㅻ쾭肄붾뱶, 硫ㅻ쾭 �씠由꾩� �옄�룞�쑝濡� 異붽�
		try {
			con = ConnUtil.getConnection();		
			sql="insert into S_RESIST(S_STUDYCODE,M_MEMCODE,M_NAME,S_TITLE,S_CONTENT,S_AREA,S_LANNAME, "
					+ "S_LEVEL,S_WEEK,S_PARTTIME,S_CHATLINK) "
					+ "values(S_RESIST_seq.nextval,?,?,?,?,?,?,?,?,?,?) ";//10媛�
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getMemCode());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getTitle());
			pstmt.setString(4, vo.getContent());
			pstmt.setString(5, vo.getArea());
			pstmt.setString(6, vo.getLanName());
			pstmt.setString(7, vo.getLevel());
			pstmt.setString(8, vo.getWeek());
			pstmt.setString(9, vo.getPartTime());
			pstmt.setString(10, vo.getChatLink());
			/* pstmt.setDate(11, vo.getWriteDay()); */
			pstmt.executeUpdate();
			
			sql="select max(S_STUDYCODE) from S_RESIST";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				studycode= rs.getInt(1);
		
			sql="insert into S_JOIN(S_JOINCODE, S_STUDYCODE, M_MEMCODE, SJ_SUBMITYN)VALUES(S_JOIN_seq.nextval, ?, ?, 'Y')";
			pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, studycode);
			pstmt.setString(2, vo.getMemCode());
			pstmt.executeUpdate();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con != null)try {con.close();} catch (SQLException ss) {}
			if(pstmt != null)try {pstmt.close();} catch (SQLException ss) {}
			
		}
	}// insert 硫붿냼�뱶
	
	public ArrayList<StudyRoomVO> getList(){
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<StudyRoomVO> StudyList=null; 
		
		try {
			con=ConnUtil.getConnection();
			//�궡由쇱감�닚 �젙�젹濡� 媛��옣 理쒓렐 �엯�젰�븳 湲��씠 泥섏쓬�쑝濡� �삤寃뚰븿
			pstmt=con.prepareStatement("select * from S_RESIST order by S_WRITEDAY desc");
			rs=pstmt.executeQuery();
			//�뜲�씠�꽣踰좎씠�뒪�뿉�꽌 媛��졇�삩 媛믪쓣 studylist�뿉 ���옣
			if(rs.next()) {
			StudyList = new ArrayList<StudyRoomVO>();
			do {
				StudyRoomVO vo = new StudyRoomVO();
				vo.setStudyCode(rs.getInt("S_STUDYCODE"));
				vo.setTitle(rs.getString("S_TITLE"));
				vo.setContent(rs.getString("S_CONTENT"));
				vo.setCount(rs.getInt("S_COUNT"));
				vo.setArea(rs.getString("S_AREA"));
				vo.setLanName(rs.getString("S_LANNAME"));
				vo.setLevel(rs.getString("S_LEVEL"));
				vo.setWeek(rs.getString("S_WEEK"));
				vo.setPartTime(rs.getString("S_PARTTIME"));
				vo.setChatLink(rs.getString("S_CHATLINK"));
				vo.setDeletYN(rs.getString("S_DELETEYN"));
				vo.setWriteDay(rs.getDate("S_WRITEDAY"));
				vo.setStartDay(rs.getString("S_STARTDAY"));
				vo.setEndDay(rs.getString("S_ENDDAY"));
				//由ъ뒪�듃�뿉 異붽�
				StudyList.add(vo);
			}while(rs.next());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con != null)try {con.close();} catch (SQLException ss) {}
			if(pstmt != null)try {pstmt.close();} catch (SQLException ss) {}
			if(rs != null)try {rs.close();} catch (SQLException ss) {}
		}
		return StudyList;
	}//List �걹
	
	public ArrayList<StudyRoomVO> getList(String LanName, String Area, String Level, String Week){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StudyRoomVO StudyRoom =null;
		ArrayList<StudyRoomVO> StudyList= null;
		
		try {
			con = ConnUtil.getConnection();
			  //議곌굔 �뾾�씠 寃��깋�븳寃쎌슦
			if(LanName==""&&Area==""&&Level==""&&Week=="") { 
				  pstmt = con.prepareStatement("select * from (select S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) " ); }
			
			//�뼵�뼱留� 寃��깋�븳寃쎌슦
			 if(LanName!=""&&Area==""&&Level==""&&Week=="") {
				pstmt = con.prepareStatement("select * from (select S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_LANNAME = ? ");
			    pstmt.setString(1, LanName);
			}
			//�뼵�뼱 +吏��뿭
			 if(LanName!=""&&Area!=""&&Level==""&&Week=="") {
				pstmt = con.prepareStatement("select * from (select S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_LANNAME = ? AND S_AREA =? ");
				pstmt.setString(1, LanName);
				pstmt.setString(2, Area);
			}
			//�뼵�뼱+�젅踰�
			 if(LanName!=""&&Area==""&&Level!=""&&Week=="") {
				pstmt = con.prepareStatement("select * from (select S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_LANNAME = ? and S_LEVEL = ? ");
				pstmt.setString(1, LanName);
				pstmt.setString(2, Level);
			}
			//�뼵�뼱+�슂�씪
			 if(LanName!=""&&Area==""&&Level==""&&Week!="") {
				pstmt = con.prepareStatement("select * from (select S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_LANNAME = ? and S_WEEK = ? ");
				pstmt.setString(1, LanName);
				pstmt.setString(2, Week);
			}
			//�뼵�뼱+吏��뿭+�젅踰�
			if(LanName!=""&&Area!=""&&Level!=""&&Week=="") {
				pstmt = con.prepareStatement("select * from (select S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_LANNAME = ? and S_AREA=? and S_LEVEL = ? ");
				pstmt.setString(1, LanName);
				pstmt.setString(2, Area);
				pstmt.setString(3, Level);
			}
			//�뼵�뼱+吏��뿭+�슂�씪
			 if(LanName!=""&&Area!=""&&Level==""&&Week!="") {
				pstmt = con.prepareStatement("select * from (select S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_LANNAME = ? and S_AREA=? and S_WEEK = ? ");
				pstmt.setString(1, LanName);
				pstmt.setString(2, Area);
				pstmt.setString(3, Week);
			}
			//�뼵�뼱+�젅踰�+�슂�씪
			 if(LanName!=""&&Area==""&&Level!=""&&Week!="") {
				pstmt = con.prepareStatement("select * from (select S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_LANNAME = ? and S_LEVEL = ? and S_WEEK=? ");
				pstmt.setString(1, LanName);
				pstmt.setString(2, Level);
				pstmt.setString(3, Week);
			}
			//吏��뿭留� 寃��깋�븳 寃쎌슦
			 if(LanName==""&&Area!=""&&Level==""&&Week=="") {
				pstmt = con.prepareStatement("select * from (select S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_AREA = ? ");
				pstmt.setString(1, Area);
			}
			//吏��뿭+�젅踰�
			 if(LanName==""&&Area!=""&&Level!=""&&Week=="") {
				pstmt = con.prepareStatement("select * from (select S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_AREA = ? and S_LEVEL=? ");
				pstmt.setString(1, Area);
				pstmt.setString(2, Level);
			}
			//吏��뿭+�슂�씪
			 if(LanName==""&&Area!=""&&Level==""&&Week!="") {
				pstmt = con.prepareStatement("select * from (select S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_AREA = ? and S_WEEK=? ");
				pstmt.setString(1, Area);
				pstmt.setString(2, Week);
			}
			//吏��뿭+�젅踰�+�슂�씪
			 if(LanName==""&&Area!=""&&Level!=""&&Week!="") {
				pstmt = con.prepareStatement("select * from (select S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_AREA = ? and S_LEVEL=? and S_WEEK=? ");
				pstmt.setString(1, Area);
				pstmt.setString(2, Level);
				pstmt.setString(3, Week);
			}
			//�젅踰⑤쭔 寃��깋�븳 寃쎌슦
			 if(LanName==""&&Area==""&&Level!=""&&Week=="") {
				pstmt = con.prepareStatement("select * from (select S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_LEVEL = ? ");
				pstmt.setString(1, Level);
			}
			//�젅踰�+�슂�씪
			 if(LanName==""&&Area==""&&Level!=""&&Week!="") {
				pstmt = con.prepareStatement("select * from (select S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_LEVEL = ? and S_WEEK=? ");
				pstmt.setString(1, Level);
				pstmt.setString(2, Week);
			}
			//�슂�씪留� 寃��깋�븳 寃쎌슦
			 if(LanName==""&&Area==""&&Level==""&&Week!="") {
				pstmt = con.prepareStatement("select * from (select S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_WEEK = ? ");
				pstmt.setString(1, Week);
			}
			//�뼵�뼱+吏��뿭+�젅踰�+�슂�씪
			 if(LanName!=""&&Area!=""&&Level!=""&&Week!="") {
				pstmt = con.prepareStatement("select * from (select S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_LANNAME=? and S_AREA=? and S_LEVEL = ? and S_WEEK=? ");
				pstmt.setString(1, LanName);
				pstmt.setString(2, Area);
				pstmt.setString(3, Level);
				pstmt.setString(4, Week);
			}
			//議곌굔�뿉 �뵲瑜� 荑쇰━臾� �떎�뻾
			rs=pstmt.executeQuery();
			if(rs.next()) {
				StudyList = new ArrayList<StudyRoomVO>();
				
			do {
				StudyRoom = new StudyRoomVO();
				StudyRoom.setStudyCode(rs.getInt("S_STUDYCODE"));
				StudyRoom.setTitle(rs.getString("S_TITLE"));
					/* StudyRoom.setContent(rs.getString("S_CONTENT")); */
				StudyRoom.setCount(rs.getInt("S_COUNT"));
				StudyRoom.setArea(rs.getString("S_AREA"));
				StudyRoom.setLanName(rs.getString("S_LANNAME"));
				StudyRoom.setLevel(rs.getString("S_LEVEL"));
				StudyRoom.setWeek(rs.getString("S_WEEK"));
				StudyRoom.setPartTime(rs.getString("S_PARTTIME"));
					/* StudyRoom.setChatLink(rs.getString("S_CHATLINK")); */
					/* StudyRoom.setDeletYN(rs.getString("S_DEKETEYN")); */
				StudyRoom.setWriteDay(rs.getDate("S_WRITEDAY"));
					/*
					 * StudyRoom.setStartDay(rs.getString("S_STARTDAY"));
					 * StudyRoom.setEndDay(rs.getString("S_ENDDAY"));
					 */
				//由ъ뒪�듃�뿉 異붽�
				StudyList.add(StudyRoom);
			}while(rs.next());
			}else {
				StudyList = new ArrayList<StudyRoomVO>();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con != null)try {con.close();} catch (SQLException ss) {}
			if(pstmt != null)try {pstmt.close();} catch (SQLException ss) {}
			if(rs != null)try {rs.close();} catch (SQLException ss) {}
		}
		return StudyList;
	}
	
	//���옣�릺�엳�뒗 �뒪�꽣�뵒 由ъ뒪�듃 紐⑸줉
	public ArrayList<StudyRoomVO> getList(int start, int end){
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<StudyRoomVO> StudyList=null; 
		
		try {
			con=ConnUtil.getConnection();
			//�궡由쇱감�닚 �젙�젹濡� 媛��옣 理쒓렐 �엯�젰�븳 湲��씠 泥섏쓬�쑝濡� �삤寃뚰븿
			pstmt=con.prepareStatement("select * from (select rownum rnum, S_STUDYCODE, S_TITLE, S_CONTENT, S_COUNT, S_AREA, S_LANNAME, S_LEVEL, S_WEEK, S_PARTTIME, S_CHATLINK, S_DELETEYN, S_WRITEDAY, S_STARTDAY, S_ENDDAY from S_RESIST) where rnum >=? and rnum <=?");
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs=pstmt.executeQuery();
			//�뜲�씠�꽣踰좎씠�뒪�뿉�꽌 媛��졇�삩 媛믪쓣 studylist�뿉 ���옣
			if(rs.next()) {
			StudyList = new ArrayList<StudyRoomVO>();
			do {
				StudyRoomVO vo = new StudyRoomVO();
				vo.setStudyCode(rs.getInt("S_STUDYCODE"));
				vo.setTitle(rs.getString("S_TITLE"));
				vo.setContent(rs.getString("S_CONTENT"));
				vo.setCount(rs.getInt("S_COUNT"));
				vo.setArea(rs.getString("S_AREA"));
				vo.setLanName(rs.getString("S_LANNAME"));
				vo.setLevel(rs.getString("S_LEVEL"));
				vo.setWeek(rs.getString("S_WEEK"));
				vo.setPartTime(rs.getString("S_PARTTIME"));
				vo.setChatLink(rs.getString("S_CHATLINK"));
				vo.setDeletYN(rs.getString("S_DELETEYN"));
				vo.setWriteDay(rs.getDate("S_WRITEDAY"));
				vo.setStartDay(rs.getString("S_STARTDAY"));
				vo.setEndDay(rs.getString("S_ENDDAY"));
				//由ъ뒪�듃�뿉 異붽�
				StudyList.add(vo);
			}while(rs.next());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con != null)try {con.close();} catch (SQLException ss) {}
			if(pstmt != null)try {pstmt.close();} catch (SQLException ss) {}
			if(rs != null)try {rs.close();} catch (SQLException ss) {}
		}
		return StudyList;
	}//List �걹
	
	//�긽�꽭�럹�씠吏� 蹂닿린, 蹂닿린 �겢由��떆 議고쉶�닔 利앷�
	public StudyRoomVO getContent(int StudyCode) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StudyRoomVO studyRoom = null;
		
		try {
			//議고쉶�닔 利앷�
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement("update S_RESIST set S_COUNT = S_COUNT+1 where S_STUDYCODE=?");
			pstmt.setInt(1, StudyCode);
			pstmt.executeUpdate();
			//�긽�꽭�럹�씠吏� 蹂닿린 湲곕낯 �옉�꽦�씪�옄
			//�럹�씠吏�瑜� �닔�젙�븳 寃쎌슦
				pstmt = con.prepareStatement("select S_TITLE, S_CONTENT, S_COUNT, S_AREA, S_LANNAME, S_LEVEL,"
						+ "S_WEEK, S_PARTTIME, S_WRITEDAY, S_CHATLINK from S_RESIST where S_STUDYCODE=?");
				pstmt.setInt(1, StudyCode);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					studyRoom = new StudyRoomVO();
					studyRoom.setTitle(rs.getString("S_TITLE"));
					studyRoom.setContent(rs.getString("S_CONTENT"));
					studyRoom.setCount(rs.getInt("S_COUNT"));
					studyRoom.setArea(rs.getString("S_AREA"));
					studyRoom.setLanName(rs.getString("S_LANNAME"));
					studyRoom.setLevel(rs.getString("S_LEVEL"));
					studyRoom.setWeek(rs.getString("S_WEEK"));
					studyRoom.setPartTime(rs.getString("S_PARTTIME"));
					studyRoom.setWriteDay(rs.getDate("S_WRITEDAY"));
					studyRoom.setChatLink(rs.getString("S_CHATLINK"));
					}
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		if(con != null)try {con.close();} catch (SQLException ss) {}
		if(pstmt != null)try {pstmt.close();} catch (SQLException ss) {}
		if(rs != null)try {rs.close();} catch (SQLException ss) {}
	}
		return studyRoom;
		}//�긽�꽭蹂닿린 end
	
	//�뒪�꽣�뵒 �닔�젙 硫붿냼�뱶, 
	public void updateStudy(StudyRoomVO StudyCode){
		Connection con =null;
		PreparedStatement pstmt = null;
		
		try {
			con = ConnUtil.getConnection();
			pstmt=con.prepareStatement("update S_RESIST set S_TITLE=?, S_CONTENT=?, S_AREA=?, S_LANNAME=?, "
					+ "S_LEVEL=?, S_WEEK=?, S_PARTTIME=?, S_CHATLINK=? ,S_WRITEDAY = sysdate where S_STUDYCODE=?");
			pstmt.setString(1, StudyCode.getTitle());
			pstmt.setString(2, StudyCode.getContent());
			pstmt.setString(3, StudyCode.getArea());
			pstmt.setString(4, StudyCode.getLanName());
			pstmt.setString(5, StudyCode.getLevel());
			pstmt.setString(6, StudyCode.getWeek());
			pstmt.setString(7, StudyCode.getPartTime());
			pstmt.setString(8, StudyCode.getChatLink());
			pstmt.setInt(9, StudyCode.getStudyCode());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con != null)try {con.close();} catch (SQLException ss) {}
			if(pstmt != null)try {pstmt.close();} catch (SQLException ss) {}
		}
	}//update 硫붿냼�뱶 �걹
	
	//寃��깋 硫붿냼�뱶
	public ArrayList<StudyRoomVO> getList(String LanName, String Area, String Level, String Week, int start, int end){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StudyRoomVO StudyRoom =null;
		ArrayList<StudyRoomVO> StudyList= null;
		
		try {
			con = ConnUtil.getConnection();
			  //議곌굔 �뾾�씠 寃��깋�븳寃쎌슦
			if(LanName==""&&Area==""&&Level==""&&Week=="") { 
				  pstmt = con.prepareStatement("select * from (select rownum rnum, S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where rnum >=? and rnum <=? " );
				  pstmt.setInt(1, start);
					pstmt.setInt(2, end);}
			
			//�뼵�뼱留� 寃��깋�븳寃쎌슦
			 if(LanName!=""&&Area==""&&Level==""&&Week=="") {
				pstmt = con.prepareStatement("select * from (select rownum rnum, S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_LANNAME = ?  and rnum >=? and rnum <=?");
			    pstmt.setString(1, LanName);
			    pstmt.setInt(2, start);
				pstmt.setInt(3, end);
			}
			//�뼵�뼱 +吏��뿭
			 if(LanName!=""&&Area!=""&&Level==""&&Week=="") {
				pstmt = con.prepareStatement("select * from (select rownum rnum, S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_LANNAME = ? AND S_AREA =? and rnum >=? and rnum <=?");
				pstmt.setString(1, LanName);
				pstmt.setString(2, Area);
				pstmt.setInt(3, start);
				pstmt.setInt(4, end);
			}
			//�뼵�뼱+�젅踰�
			 if(LanName!=""&&Area==""&&Level!=""&&Week=="") {
				pstmt = con.prepareStatement("select * from (select rownum rnum, S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_LANNAME = ? and S_LEVEL = ? and rnum >=? and rnum <=?");
				pstmt.setString(1, LanName);
				pstmt.setString(2, Level);
				pstmt.setInt(3, start);
				pstmt.setInt(4, end);
			}
			//�뼵�뼱+�슂�씪
			 if(LanName!=""&&Area==""&&Level==""&&Week!="") {
				pstmt = con.prepareStatement("select * from (select rownum rnum, S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_LANNAME = ? and S_WEEK = ? and rnum >=? and rnum <=?");
				pstmt.setString(1, LanName);
				pstmt.setString(2, Week);
				pstmt.setInt(3, start);
				pstmt.setInt(4, end);
			}
			//�뼵�뼱+吏��뿭+�젅踰�
			if(LanName!=""&&Area!=""&&Level!=""&&Week=="") {
				pstmt = con.prepareStatement("select * from (select rownum rnum, S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_LANNAME = ? and S_AREA=? and S_LEVEL = ? and rnum >=? and rnum <=?");
				pstmt.setString(1, LanName);
				pstmt.setString(2, Area);
				pstmt.setString(3, Level);
				pstmt.setInt(4, start);
				pstmt.setInt(5, end);
			}
			//�뼵�뼱+吏��뿭+�슂�씪
			 if(LanName!=""&&Area!=""&&Level==""&&Week!="") {
				pstmt = con.prepareStatement("select * from (select rownum rnum, S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_LANNAME = ? and S_AREA=? and S_WEEK = ? and rnum >=? and rnum <=?");
				pstmt.setString(1, LanName);
				pstmt.setString(2, Area);
				pstmt.setString(3, Week);
				pstmt.setInt(4, start);
				pstmt.setInt(5, end);
			}
			//�뼵�뼱+�젅踰�+�슂�씪
			 if(LanName!=""&&Area==""&&Level!=""&&Week!="") {
				pstmt = con.prepareStatement("select * from (select rownum rnum, S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_LANNAME = ? and S_LEVEL = ? and S_WEEK=? and rnum >=? and rnum <=?");
				pstmt.setString(1, LanName);
				pstmt.setString(2, Level);
				pstmt.setString(3, Week);
				pstmt.setInt(4, start);
				pstmt.setInt(5, end);
			}
			//吏��뿭留� 寃��깋�븳 寃쎌슦
			 if(LanName==""&&Area!=""&&Level==""&&Week=="") {
				pstmt = con.prepareStatement("select * from (select rownum rnum, S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_AREA = ? and rnum >=? and rnum <=?");
				pstmt.setString(1, Area);
				pstmt.setInt(2, start);
				pstmt.setInt(3, end);
			}
			//吏��뿭+�젅踰�
			 if(LanName==""&&Area!=""&&Level!=""&&Week=="") {
				pstmt = con.prepareStatement("select * from (select rownum rnum, S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_AREA = ? and S_LEVEL=? and rnum >=? and rnum <=?");
				pstmt.setString(1, Area);
				pstmt.setString(2, Level);
				pstmt.setInt(3, start);
				pstmt.setInt(4, end);
			}
			//吏��뿭+�슂�씪
			 if(LanName==""&&Area!=""&&Level==""&&Week!="") {
				pstmt = con.prepareStatement("select * from (select rownum rnum, S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_AREA = ? and S_WEEK=? and rnum >=? and rnum <=?");
				pstmt.setString(1, Area);
				pstmt.setString(2, Week);
				pstmt.setInt(3, start);
				pstmt.setInt(4, end);
			}
			//吏��뿭+�젅踰�+�슂�씪
			 if(LanName==""&&Area!=""&&Level!=""&&Week!="") {
				pstmt = con.prepareStatement("select * from (select rownum rnum, S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_AREA = ? and S_LEVEL=? and S_WEEK=? and rnum >=? and rnum <=? ");
				pstmt.setString(1, Area);
				pstmt.setString(2, Level);
				pstmt.setString(3, Week);
				pstmt.setInt(4, start);
				pstmt.setInt(5, end);
			}
			//�젅踰⑤쭔 寃��깋�븳 寃쎌슦
			 if(LanName==""&&Area==""&&Level!=""&&Week=="") {
				pstmt = con.prepareStatement("select * from (select rownum rnum, S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_LEVEL = ? and rnum >=? and rnum <=?");
				pstmt.setString(1, Level);
				pstmt.setInt(2, start);
				pstmt.setInt(3, end);
			}
			//�젅踰�+�슂�씪
			 if(LanName==""&&Area==""&&Level!=""&&Week!="") {
				pstmt = con.prepareStatement("select * from (select rownum rnum, S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_LEVEL = ? and S_WEEK=? and rnum >=? and rnum <=?");
				pstmt.setString(1, Level);
				pstmt.setString(2, Week);
				pstmt.setInt(3, start);
				pstmt.setInt(4, end);
			}
			//�슂�씪留� 寃��깋�븳 寃쎌슦
			 if(LanName==""&&Area==""&&Level==""&&Week!="") {
				pstmt = con.prepareStatement("select * from (select rownum rnum, S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_WEEK = ? and rnum >=? and rnum <=?");
				pstmt.setString(1, Week);
				pstmt.setInt(2, start);
				pstmt.setInt(3, end);
			}
			//�뼵�뼱+吏��뿭+�젅踰�+�슂�씪
			 if(LanName!=""&&Area!=""&&Level!=""&&Week!="") {
				pstmt = con.prepareStatement("select * from (select rownum rnum, S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_LANNAME=? and S_AREA=? and S_LEVEL = ? and S_WEEK=? and rnum >=? and rnum <=?");
				pstmt.setString(1, LanName);
				pstmt.setString(2, Area);
				pstmt.setString(3, Level);
				pstmt.setString(4, Week);
				pstmt.setInt(5, start);
				pstmt.setInt(6, end);
			}
			//議곌굔�뿉 �뵲瑜� 荑쇰━臾� �떎�뻾
			rs=pstmt.executeQuery();
			if(rs.next()) {
				StudyList = new ArrayList<StudyRoomVO>();
				
			do {
				StudyRoom = new StudyRoomVO();
				StudyRoom.setStudyCode(rs.getInt("S_STUDYCODE"));
				StudyRoom.setTitle(rs.getString("S_TITLE"));
					/* StudyRoom.setContent(rs.getString("S_CONTENT")); */
				StudyRoom.setCount(rs.getInt("S_COUNT"));
				StudyRoom.setArea(rs.getString("S_AREA"));
				StudyRoom.setLanName(rs.getString("S_LANNAME"));
				StudyRoom.setLevel(rs.getString("S_LEVEL"));
				StudyRoom.setWeek(rs.getString("S_WEEK"));
				StudyRoom.setPartTime(rs.getString("S_PARTTIME"));
					/* StudyRoom.setChatLink(rs.getString("S_CHATLINK")); */
					/* StudyRoom.setDeletYN(rs.getString("S_DEKETEYN")); */
				StudyRoom.setWriteDay(rs.getDate("S_WRITEDAY"));
					/*
					 * StudyRoom.setStartDay(rs.getString("S_STARTDAY"));
					 * StudyRoom.setEndDay(rs.getString("S_ENDDAY"));
					 */
				//由ъ뒪�듃�뿉 異붽�
				StudyList.add(StudyRoom);
			}while(rs.next());
			}else {
				StudyList = new ArrayList<StudyRoomVO>();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con != null)try {con.close();} catch (SQLException ss) {}
			if(pstmt != null)try {pstmt.close();} catch (SQLException ss) {}
			if(rs != null)try {rs.close();} catch (SQLException ss) {}
		}
		return StudyList;
	}
	//DB濡쒕��꽣 吏��젙�븳 �쉶�썝肄붾뱶�쓽 �쉶�썝�젙蹂대�� 媛��졇�삤�뒗 硫붿냼�뱶
	public StudyRoomVO getmember(String M_MemCode) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StudyRoomVO vo= null;
		try {
			con = ConnUtil.getConnection();
			pstmt=con.prepareStatement("select * from S_MEMBER where M_MEMCODE=?");
			pstmt.setString(1, M_MemCode);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				vo = new StudyRoomVO();
				vo.setMemCode(rs.getString("M_MEMCODE"));
				vo.setName(rs.getString("M_NAME"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con != null)try {con.close();} catch (SQLException ss) {}
			if(pstmt != null)try {pstmt.close();} catch (SQLException ss) {}
			if(rs != null)try {rs.close();} catch (SQLException ss) {}
		}
		return vo;
	}	
	
	
}