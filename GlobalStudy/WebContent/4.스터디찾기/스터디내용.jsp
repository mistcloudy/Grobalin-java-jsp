<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="StudyRoom.*" %>
    <%@ page import="java.util.*" %>
       <script src="https://kit.fontawesome.com/ea243819fd.js" crossorigin="anonymous"></script>
    <link type="text/css" rel="stylesheet" href="../css/main.css">
    <link type="text/css" rel="stylesheet" href="../css/검색등록.css">
    <%
    int StudyCode = Integer.parseInt(request.getParameter("studyCode"));   
    StudyRoomDAO Stdao = StudyRoomDAO.getInstance();
    StudyRoomVO Stvo = Stdao.getContent(StudyCode);
    %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>스터디 상세내용 보기</title>
</head>
<body>
     <nav class="navbar">
            <div class="navbar_logo">
                <i class="fa-solid fa-award"></i>   
                <a href="../1.메인사이트/main.jsp">LOGO</a>
            </div>
            <ul class="navbar_menu">
                <li><a href="../4.스터디찾기/스터디목록.jsp">스터디찾기</a></li>
                <li><a href="../5.스터디등록/스터디등록.jsp">스터디등록</a></li>
                <li><a href="#">레벨테스트</a></li>
                <li><a href="../7.내스터디/개인정보.jsp">내스터디</a></li>
                <li><a href="#">후기작성</a></li>
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
    <form action="../스터디정보/스터디수정.jsp">
        <div class="title">스터디 상세내용 보기</div>
            <div class="user-details">
                <div class="input-box">
                    <span class="details">스터디 제목</span>
                    <input type="text" value="<%=Stvo.getTitle() %>" readonly>
                </div>
                <div class="input-box">
                    <span class="details">언어명</span>
                    <input type="text" value="<%=Stvo.getLanName() %>" readonly>
                </div>
                <div class="input-box">
                    <span class="details">모집 언어 레벨</span>
                    <input type="text" value="<%=Stvo.getLevel() %>" readonly>
                </div>
                <div class="input-box">
                    <span class="details">지역</span>
                    <input type="text" value="<%=Stvo.getArea() %>" readonly>
                </div>
                <div class="input-box">
                    <span class="details">스터디 요일</span>
                    <input type="text" value="<%=Stvo.getWeek() %>" readonly>                </div>
                <div class="input-box">
                    <span class="details">스터디 시간</span>
                    <input type="text" value="<%=Stvo.getPartTime() %>" readonly>                </div>
                <div class="input-box">
                    <span class="details">연락 수단</span>
                    <input type="text" value=" <%=Stvo.getChatLink() %>" readonly>
                </div>
                <div class="input-box">
                    <span class="details">최근 수정 일자</span>
                    <input type="text" value="<%=Stvo.getWriteDay() %>" readonly>
                </div>
                <div class="input-box">
                    <span class="details">조회수</span>
                    <input type="text" value="<%=Stvo.getCount() %>" readonly>
                </div>
                
            </div>
            <span class="details">스터디 내용</span>
            <div class="gender-details" style="margin-top : 10px">
            <textarea rows="20" cols="260" placeholder="<%=Stvo.getContent() %>" name="content" readonly></textarea>
            </div>
            <div class="button">
			
			<input type="submit" value="수정하기">
			<input type="button" value="목록보기" onclick="document.location.href='../4.스터디찾기/스터디목록.jsp'"> 

			<!-- 수정페이지 분리 시 지울것 -->	
			<input type="hidden" name="StudyCode" value="<%=StudyCode%>">
			 
			</form>
           </div>
       
    </div>
</div>
       
</body>
</html>