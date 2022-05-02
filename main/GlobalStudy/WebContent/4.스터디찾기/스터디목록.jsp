<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="StudyRoom.StudyRoomDAO" %>
    <%@ page import="StudyRoom.StudyRoomVO" %>
    <%@ page import="StudyRoom.ConnUtil" %>
    <%@ page import="java.util.*" %>
    <script src="https://kit.fontawesome.com/ea243819fd.js" crossorigin="anonymous"></script>
	<link type="text/css" rel="stylesheet" href="../css/main.css"> 
    <link type="text/css" rel="stylesheet" href="../css/검색등록.css">
    <link type="text/css" rel="stylesheet" href="../css/목록.css">
    <%
    request.setCharacterEncoding("utf-8");
    int pageSize = 5;
    
    String pageNum = request.getParameter("pageNum");
    String LanName = request.getParameter("LanName");
    String Area = request.getParameter("Area");
    String Level = request.getParameter("Level");
    String Week = request.getParameter("Week");
    ArrayList<StudyRoomVO> StudyList = null;
    StudyRoomDAO stDao = StudyRoomDAO.getInstance();
    
    if(pageNum==null){
    	pageNum="1";
    }
    
    int currentPage = Integer.parseInt(pageNum);
    int start=(currentPage-1)*pageSize+1;
    int end=currentPage*pageSize;
    
    int number = 0;
    int count = 0;
    if(LanName==null&&Area==null&&Level==null&&Week==null){
    	count=stDao.getCount();//전체 글수
    
    //count>0 == 글이 1개이상 존재한다.
    if(count>0){
    	//글을 가져와서 articleList에 저장
    	StudyList = stDao.getList(start,end);
    }
}else{
  count = stDao.getCount(LanName, Area, Level, Week);
  
  if(count>0){
  	//글을 가져와서 articleList에 저장
  	StudyList = stDao.getList(LanName, Area, Level, Week, start, end);
  }
    }
    number = count-(currentPage-1)*pageSize;
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
                <a href="../1.메인사이트/main.jsp">Global Study</a>
            </div>
            <ul class="navbar_menu">
                <li><a href="../4.스터디찾기/스터디목록.jsp">스터디찾기</a></li>
                <li><a href="../5.스터디등록/스터디등록.jsp">스터디등록</a></li>
                <li><a href="../스터디정보/정보메인.jsp">내스터디</a></li>
            </ul>
            <ul class="navbar_icons">
            <li><a href="../2.로그인/로그인.jsp"><i class="fa-solid fa-user"></i></a></li>
            </ul>
    
            <a href="../4.스터디찾기/스터디목록.jsp" class="navbar_toogleBtn">
                <i class="fa-solid fa-bars"></i>
            </a>
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
                <input type="reset" value="초기화" onclick="document.location.href=../4.스터디찾기/스터디목록.jsp'"> 
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
				<td><a href="../4.스터디찾기/스터디내용.jsp?studyCode=<%=Study.getStudyCode() %>"><%=Study.getTitle()%></a></td>
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
           <%
if(count>0){
	 
	int pageBlock=5;
	int imsi = count%pageSize==0?0:1;
	int pageCount = count/pageSize + imsi;
	int startPage = (int)((currentPage-1)/pageBlock)*pageBlock+1;
	int endPage = startPage+pageBlock -1;
	if(endPage>pageCount) endPage=pageCount;
	
	//이전 블럭, 다음블럭
	if(startPage>pageBlock){
		//검색일 경우와 아닐경우 페이지 처리
		if(LanName==null&&Area==null&&Level==null&&Week==null){
		%>
		<a href="스터디목록.jsp?pageNum=<%=startPage-pageBlock%>">[이전]</a>
		<%}else{%>
		<a href="스터디목록.jsp?pageNum=<%=startPage-pageBlock%>&LanName=<%=LanName%>&Area=<%=Area%>&Level=<%=Level%>&Week=<%=Week%>">[이전]</a>
	<%}
		}
	 
	for(int i = startPage;i<=endPage;i++){
		if(LanName==null&&Area==null&&Level==null&&Week==null){
	%>
	<a href="스터디목록.jsp?pageNum=<%=i%>">[<%=i%>]</a>
	<%}else{ %>
	<a href="스터디목록.jsp?pageNum=<%=i%>&LanName=<%=LanName%>&Area=<%=Area%>&Level=<%=Level%>&Week=<%=Week%>">[<%=i%>]</a>
<% }
}
	if(endPage<pageCount){
		if(LanName==null&&Area==null&&Level==null&&Week==null){
	 %>
		<a href="스터디목록.jsp?pageNum=<%=startPage+pageBlock%>">[다음]</a>	
	<%}else{%>
	<a href="스터디목록.jsp?pageNum=<%=startPage+pageBlock%>&LanName=<%=LanName%>&Area=<%=Area%>&Level=<%=Level%>&Week=<%=Week%>">[다음]</a>
	<% }
	 }
}
%>
      		  </div>
      		  </div>                        
      		  </div>            
</body>
</html>