<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="MyStudy.MyStudyDAO" %>
    <%@ page import="MyStudy.MyStudyVO" %>
     <%@ page import="StudyRoom.*" %>
    <%@ page import="java.util.List" %>
    <%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>스터디 등록</title>
    <script src="https://kit.fontawesome.com/ea243819fd.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link type="text/css" rel="stylesheet" href="../css/main.css">
    <link rel="stylesheet" href="../css/검색등록.css">
      <link href="../css/사이드바.css" rel="stylesheet"/>
        <link href="../css/main.css" rel="stylesheet">
        <link href="../css/목록.css" rel="stylesheet">
</head>
<%
int StudyCode = Integer.parseInt(request.getParameter("s_STUDYCODE"));
 String pageNum = request.getParameter("pageNum");
 String name = request.getParameter("memname");
 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH :mm");
 String loginID=(String)session.getAttribute("loginID");
 String code=(String)session.getAttribute("M_MemCode");
 String M_Name=(String)session.getAttribute("M_Name"); 
 
 try{
	    StudyRoomDAO Stdao = StudyRoomDAO.getInstance();
	    StudyRoomVO Stvo = Stdao.getContent(StudyCode);
	
 %>
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
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top" id="sideNav">
            <a class="navbar-brand js-scroll-trigger" href="#page-top">
 
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav">
                    <li class="nav-item"><a class="nav-link js-scroll-trigger" href="../스터디정보/정보메인.jsp">스터디정보</a></li>
                    <li class="nav-item"><a class="nav-link js-scroll-trigger" href="../스터디신청/신청메인.jsp">스터디신청</a></li>
                    <li class="nav-item"><a class="nav-link js-scroll-trigger" href="../스터디관리/관리메인.jsp">스터디관리</a></li>
                </ul>
            </div>
        </nav>       
    <div class="container">
    <form action="#">
        <div class="title">스터디 등록</div>
            <div class="user-details">
                <div class="input-box">
                   <span class="details">스터디 제목</span>
                    <input type="text" name="title" value="<%=Stvo.getTitle() %>" readonly >
                </div>
                <div class="input-box">
                    <span class="details">언어명</span>
                    <input type="text" name="title" value="<%=Stvo.getLanName() %>" readonly>
                </div>
                <div class="input-box">
                    <span class="details">언어 레벨</span>
                     <input type="text" name="area" value="<%=Stvo.getLevel() %>" readonly>
                </div>
                <div class="input-box">
                    <span class="details">지역</span>
                     <input type="text" name="language" value="<%=Stvo.getArea() %>" readonly>
                </div>
                <div class="input-box">
                    <span class="details">스터디 요일</span>
                    <input type="text" name="week" value="<%=Stvo.getWeek() %>" readonly>
                </div>
                <div class="input-box">
                     <span class="details">스터디 시간</span>
                    <input type="text" name="partTime" value="<%=Stvo.getPartTime() %>" readonly>
                </div>
                <div class="input-box">
                     <span class="details">오픈 채팅 링크</span>
					<input type="text" name="chatLink" value="<%=Stvo.getChatLink() %>"  readonly>                   
                </div>
                <div class="input-box">
                    <span class="details">조회수</span>
                    <input type="text" name="count" value="<%=Stvo.getCount() %>" readonly>
                </div>
                <div>
                <span class="details">스터디 내용</span>
            </div>
                <textarea name="content" readonly><%=Stvo.getContent() %>   </textarea>
            </div>
            <div class="button">
            <% if (M_Name.equals(name)) {
            	%>
                <input type="button" value="수정" onClick="location.href='../스터디정보/스터디수정.jsp?s_STUDYCODE=<%=StudyCode%>&pageNum=<%=pageNum%>'">
                <input type="button" value="삭제" onClick="location.href='../스터디정보/스터디삭제proc.jsp?s_STUDYCODE=<%=StudyCode%>&pageNum=<%=pageNum%>'">
                <% 
                }
            	%>
                <input type="button" value="뒤로" onClick="location.href='../스터디정보/정보메인.jsp'">
            </div>
        </form>
        </div>
     
   
   
            <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
            <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>          
                <%}catch(Exception e){
	e.printStackTrace();
}
 %>
</body>
</html>