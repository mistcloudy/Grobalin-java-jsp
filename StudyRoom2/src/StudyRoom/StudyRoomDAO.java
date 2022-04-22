package StudyRoom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;


public class StudyRoomDAO {
	// 싱글톤
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
	//게시판 글의 갯수 
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
		return x; //x==글의 전체 갯수
	}
	// 스터디 insert 메소드
	public void insertStudy(StudyRoomVO vo) {
			Connection con = null;
			PreparedStatement pstmt = null;
			String sql="";
		//등록페이지에서 입력받는 값 제목,내용,지역,언어명,언어 레벨, 요일, 시간 , 채팅링크
		//스터디 번호, 작성일자 , 멤버코드, 멤버 이름은 자동으로 추가
		try {
			con = ConnUtil.getConnection();		
			sql="insert into S_RESIST(S_STUDYCODE,M_MEMCODE,M_NAME,S_TITLE,S_CONTENT,S_AREA,S_LANNAME, "
					+ "S_LEVEL,S_WEEK,S_PARTTIME,S_CHATLINK) "
					+ "values(S_RESIST_seq.nextval,?,?,?,?,?,?,?,?,?,?) ";//10개
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getM_MemCode());
			pstmt.setString(2, vo.getM_Name());
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
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con != null)try {con.close();} catch (SQLException ss) {}
			if(pstmt != null)try {pstmt.close();} catch (SQLException ss) {}
		}
	}// insert 메소드
	
	//저장되있는 스터디 리스트 목록
	public ArrayList<StudyRoomVO> getList(){
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<StudyRoomVO> StudyList=null; 
		
		try {
			con=ConnUtil.getConnection();
			//내림차순 정렬로 가장 최근 입력한 글이 처음으로 오게함
			pstmt=con.prepareStatement("select * from S_RESIST order by S_WRITEDAY desc");
			rs=pstmt.executeQuery();
			//데이터베이스에서 가져온 값을 studylist에 저장
			if(rs.next()) {
			StudyList = new ArrayList<StudyRoomVO>();
			do {
				StudyRoomVO vo = new StudyRoomVO();
				vo.setStudyCode(rs.getString("S_STUDYCODE"));
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
				//리스트에 추가
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
	}//List 끝
	
	//상세페이지 보기, 보기 클릭시 조회수 증가
	public StudyRoomVO getContent(String StudyCode) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StudyRoomVO studyRoom = null;
		
		try {
			//조회수 증가
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement("update S_RESIST set S_COUNT = S_COUNT+1 where S_STUDYCODE=?");
			pstmt.setString(1, StudyCode);
			pstmt.executeUpdate();
			//상세페이지 보기 기본 작성일자
			//페이지를 수정한 경우
				pstmt = con.prepareStatement("select S_TITLE, S_CONTENT, S_COUNT, S_AREA, S_LANNAME, S_LEVEL,"
						+ "S_WEEK, S_PARTTIME, S_WRITEDAY, S_CHATLINK from S_RESIST where S_STUDYCODE=?");
				pstmt.setString(1, StudyCode);
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
		}//상세보기 end
	//스터디 수정 메소드, 
	public void updateStudy(StudyRoomVO StudyCode){
		Connection con =null;
		PreparedStatement pstmt = null;
		
		try {
			con = ConnUtil.getConnection();
			pstmt=con.prepareStatement("update S_RESIST set S_TITLE=?, S_CONTENT=?, S_AREA=?, S_LANNAME=?, "
					+ "S_LEVEL=?, S_WEEK=?, S_PARTTIME=?, S_CHATLINK=? where S_STUDYCODE=?");
			pstmt.setString(1, StudyCode.getTitle());
			pstmt.setString(2, StudyCode.getContent());
			pstmt.setString(3, StudyCode.getArea());
			pstmt.setString(4, StudyCode.getLanName());
			pstmt.setString(5, StudyCode.getLevel());
			pstmt.setString(6, StudyCode.getWeek());
			pstmt.setString(7, StudyCode.getPartTime());
			pstmt.setString(8, StudyCode.getChatLink());
			/* pstmt.setDate(9, StudyCode.getWriteDay()); */
			pstmt.setString(9, StudyCode.getStudyCode());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con != null)try {con.close();} catch (SQLException ss) {}
			if(pstmt != null)try {pstmt.close();} catch (SQLException ss) {}
		}
	}//update 메소드 끝
	
	//검색 메소드
	public ArrayList<StudyRoomVO> getList(String LanName, String Area, String Level, String Week){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StudyRoomVO StudyRoom =null;
		ArrayList<StudyRoomVO> StudyList= null;
		
		try {
			con = ConnUtil.getConnection();
			  //조건 없이 검색한경우
			if(LanName==""&&Area==""&&Level==""&&Week=="") { 
				  pstmt = con.prepareStatement("select * from (select S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) " ); }
			
			//언어만 검색한경우
			 if(LanName!=""&&Area==""&&Level==""&&Week=="") {
				pstmt = con.prepareStatement("select * from (select S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_LANNAME = ? ");
			    pstmt.setString(1, LanName);
			}
			//언어 +지역
			 if(LanName!=""&&Area!=""&&Level==""&&Week=="") {
				pstmt = con.prepareStatement("select * from (select S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_LANNAME = ? AND S_AREA =? ");
				pstmt.setString(1, LanName);
				pstmt.setString(2, Area);
			}
			//언어+레벨
			 if(LanName!=""&&Area==""&&Level!=""&&Week=="") {
				pstmt = con.prepareStatement("select * from (select S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_LANNAME = ? and S_LEVEL = ? ");
				pstmt.setString(1, LanName);
				pstmt.setString(2, Level);
			}
			//언어+요일
			 if(LanName!=""&&Area==""&&Level==""&&Week!="") {
				pstmt = con.prepareStatement("select * from (select S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_LANNAME = ? and S_WEEK = ? ");
				pstmt.setString(1, LanName);
				pstmt.setString(2, Week);
			}
			//언어+지역+레벨
			if(LanName!=""&&Area!=""&&Level!=""&&Week=="") {
				pstmt = con.prepareStatement("select * from (select S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_LANNAME = ? and S_AREA=? and S_LEVEL = ? ");
				pstmt.setString(1, LanName);
				pstmt.setString(2, Area);
				pstmt.setString(3, Level);
			}
			//언어+지역+요일
			 if(LanName!=""&&Area!=""&&Level==""&&Week!="") {
				pstmt = con.prepareStatement("select * from (select S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_LANNAME = ? and S_AREA=? and S_WEEK = ? ");
				pstmt.setString(1, LanName);
				pstmt.setString(2, Area);
				pstmt.setString(3, Week);
			}
			//언어+레벨+요일
			 if(LanName!=""&&Area==""&&Level!=""&&Week!="") {
				pstmt = con.prepareStatement("select * from (select S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_LANNAME = ? and S_LEVEL = ? and S_WEEK=? ");
				pstmt.setString(1, LanName);
				pstmt.setString(2, Level);
				pstmt.setString(3, Week);
			}
			//지역만 검색한 경우
			 if(LanName==""&&Area!=""&&Level==""&&Week=="") {
				pstmt = con.prepareStatement("select * from (select S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_AREA = ? ");
				pstmt.setString(1, Area);
			}
			//지역+레벨
			 if(LanName==""&&Area!=""&&Level!=""&&Week=="") {
				pstmt = con.prepareStatement("select * from (select S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_AREA = ? and S_LEVEL=? ");
				pstmt.setString(1, Area);
				pstmt.setString(2, Level);
			}
			//지역+요일
			 if(LanName==""&&Area!=""&&Level==""&&Week!="") {
				pstmt = con.prepareStatement("select * from (select S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_AREA = ? and S_WEEK=? ");
				pstmt.setString(1, Area);
				pstmt.setString(2, Week);
			}
			//지역+레벨+요일
			 if(LanName==""&&Area!=""&&Level!=""&&Week!="") {
				pstmt = con.prepareStatement("select * from (select S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_AREA = ? and S_LEVEL=? and S_WEEK=? ");
				pstmt.setString(1, Area);
				pstmt.setString(2, Level);
				pstmt.setString(3, Week);
			}
			//레벨만 검색한 경우
			 if(LanName==""&&Area==""&&Level!=""&&Week=="") {
				pstmt = con.prepareStatement("select * from (select S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_LEVEL = ? ");
				pstmt.setString(1, Level);
			}
			//레벨+요일
			 if(LanName==""&&Area==""&&Level!=""&&Week!="") {
				pstmt = con.prepareStatement("select * from (select S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_LEVEL = ? and S_WEEK=? ");
				pstmt.setString(1, Level);
				pstmt.setString(2, Week);
			}
			//요일만 검색한 경우
			 if(LanName==""&&Area==""&&Level==""&&Week!="") {
				pstmt = con.prepareStatement("select * from (select S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_WEEK = ? ");
				pstmt.setString(1, Week);
			}
			//언어+지역+레벨+요일
			 if(LanName!=""&&Area!=""&&Level!=""&&Week!="") {
				pstmt = con.prepareStatement("select * from (select S_STUDYCODE, S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_LANNAME=? and S_AREA=? and S_LEVEL = ? and S_WEEK=? ");
				pstmt.setString(1, LanName);
				pstmt.setString(2, Area);
				pstmt.setString(3, Level);
				pstmt.setString(4, Week);
			}
			//조건에 따른 쿼리문 실행
			rs=pstmt.executeQuery();
			if(rs.next()) {
				StudyList = new ArrayList<StudyRoomVO>();
				
			do {
				StudyRoom = new StudyRoomVO();
				StudyRoom.setStudyCode(rs.getString("S_STUDYCODE"));
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
				//리스트에 추가
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
	//DB로부터 지정한 회원코드의 회원정보를 가져오는 메소드
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
				vo.setM_MemCode(rs.getString("M_MEMCODE"));
				vo.setM_Name(rs.getString("M_NAME"));
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