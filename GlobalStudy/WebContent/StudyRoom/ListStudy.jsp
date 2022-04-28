<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="StudyRoom.StudyRoomDAO" %>
    <%@ page import="StudyRoom.StudyRoomVO" %>
    <%@ page import="StudyRoom.ConnUtil" %>
    <%@ page import="java.util.*" %>
    <script src="https://kit.fontawesome.com/ea243819fd.js" crossorigin="anonymous"></script>
	<link type="text/css" rel="stylesheet" href="../StudyRoom/css/main.css"> 
    <link type="text/css" rel="stylesheet" href="../StudyRoom/css/검색등록.css">
    <link type="text/css" rel="stylesheet" href="../StudyRoom/css/목록.css">
    <%
    request.setCharacterEncoding("utf-8");
    
    String LanName = request.getParameter("LanName");
    String Area = request.getParameter("Area");
    String Level = request.getParameter("Level");
    String Week = request.getParameter("Week");
    ArrayList<StudyRoomVO> StudyList = null;
    StudyRoomDAO stDao = StudyRoomDAO.getInstance();
    int count = 0;
    count = stDao.getCount();
    if(count==0){	 
    }else{
     if(LanName==null&&Area==null&&Level==null&&Week==null){
    	StudyList = stDao.getList();
    } 
   else{
    	StudyList = stDao.getList(LanName, Area, Level, Week);
    	String Lan = LanName;
    	}
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 메인화면에서 스터디 찾기 클릭시 보일 화면 -->
<title>스터디 찾기</title>
</head>
<body>
    <nav class="navbar">
        <div class="navbar_logo">
            <i class="fa-solid fa-award"></i>   
            <a href="#">LOGO</a>
        </div>
        <ul class="navbar_menu">
            <li><a href="ListStudy.jsp">스터디찾기</a></li>
            <li><a href="InsertStudy.jsp">스터디등록</a></li>
            <li><a href="#">레벨테스트</a></li>
            <li><a href="#">내스터디</a></li>
            <li><a href="#">후기작성</a></li>
        </ul>
        <ul class="navbar_icons">
            <li><a href="#"><ion-icon name="log-in-outline"></ion-icon></a></li>
            <li><a href="#"><i class="fa-solid fa-user"></i></a></li>
        </ul>
    </nav>
    <div class="soun">
    <div class="container">
        <div class="title">스터디 검색</div>
         <form method="post">
            <div class="user-details">
                <div class="input-box">
                <span class="details">언어명</span>
                <select id="row1" name="LanName" class="form-control">
                    <option value="">선택하세요.</option>
                    <option value="영어">영어</option>
                    <option value="일본어">일본어</option>
                    <option value="중국어">중국어</option>
                    <option value="아랍어">아랍어</option>
                    <option value="스페인어">스페인어</option>
                    <option value="독일어">독일어</option>
                </select>
                </div>
                <div class="input-box">
                <span class="details">지역</span>
                <select id="row1" name="Area" class="form-control">
                   <option value="">선택하세요.</option> 
                    <option value="강남">강남</option>
                    <option value="신촌">신촌</option>
                    <option value="홍대">홍대</option>
                    <option value="인천">인천-부평</option>
                    <option value="건대">건대</option>
                    <option value="판교">판교/분당</option>
                    <option value="수원">수원</option>
                </select>
                </div>
                <div class="input-box">
                    <span class="details">레벨</span>
                    <select id="row1" name="Level" class="form-control">
                      <option value="">선택하세요.</option>
                        <option value="초급">초급</option>
                        <option value="중급">중급</option>
                        <option value="고급">고급</option>
                    </select>
                </div>
                <div class="input-box">
                    <span class="details">요일</span>
                <select id="row1" name="Week" class="form-control">
                   <option value="">선택하세요.</option> 
                    <option value="평일">평일</option>
                    <option value="주말">주말</option>
                </select>
                </div>
            </div>
           
            <div class="button">
                <input type="submit" value="검색" >
                <input type="reset" value="초기화" onclick="document.location.href='ListStudy.jsp'"> 
            </div>
        </form>
        
    </div>
</div>
<div class="enu">
    <div class="board_list_wrap">
        <table class="board_list" >
            <caption><b>게시판 목록</caption>
                <tr>
                    <td>제목</td><td>언어명</td><td>레벨</td><td>지역</td><td>요일</td><td>시간</td><td>조회수</td><td>작성날짜</td>
                </tr> 
               	<%
               	if(count==0){
               		%>
               		<tr>
					<td colspan="8" align="center">
					<b>현재 게시판이 비어있습니다.
					</td>
					</tr>
               		<% 
               	}else{
               	
               	%>
				<%
				if(StudyList.size()>0){
				for(int i=0;i<StudyList.size();i++){
				StudyRoomVO Study = (StudyRoomVO)StudyList.get(i);
				%>
				<tr>
				<td><a href="ContentStudy.jsp?studyCode=<%=Study.getStudyCode() %>"><%=Study.getTitle()%></a></td>
				<td><%=Study.getLanName()%></td>
				<td><%=Study.getLevel()%></td>
				<td><%=Study.getArea()%></td>
				<td><%=Study.getWeek()%></td>
				<td><%=Study.getPartTime() %>
				<td><%=Study.getCount()%></td>
				<td><%=Study.getWriteDay()%></td>
				</tr>	
				<%} 
				}else{%>
				<tr>
				<td colspan="8" align="center">
				<b>검색한 결과가 없습니다.
				</td>
				</tr>
				<%} 
				}%>
				</table>
				<div class="paging">
            <a href="#" class="bt">이전 페이지</a>
            <a href="#" class="num">1</a>
            <a href="#" class="num">2</a>
            <a href="#" class="num">3</a>
            <a href="#" class="num">4</a>
            <a href="#" class="bt">다음 페이지</a>
      		  </div>
      		  </div>                        
      		  </div>            
</body>
</html>