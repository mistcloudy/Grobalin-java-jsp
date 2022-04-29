<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String loginID=(String)session.getAttribute("loginID");
	%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link type="text/css" rel="stylesheet" href="../2.로그인/css/Login.css">
    <script src="/2.로그인/libs/jquery-3.6.0.min.js"></script>
    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</head>
<body>
<!-- 로그인 성공시 -->
<%if(loginID !=null){ %>
			<section class="login-form">
        	<h1><ion-icon name="desktop-outline"></ion-icon></h1>
            <div class="int-area">
                <input type="text" name="id" id="id" autocomplete="off" readonly>
                <label for="id"><%=loginID %>님 패스워드를 입력해주세요</label>
            </div>
            <div class="btn-area">
            	<input id="btn" type="submit" value="회원정보수정" onClick="location.href='회원정보수정.jsp'">&nbsp;&nbsp;
               	<input id="btn" type="button" value="로그아웃" onClick="location.href='로그아웃.jsp'">&nbsp;&nbsp;
               	<br><br>
               	<input id="btn" type="button" value="회원탈퇴" onClick="location.href='회원탈퇴.jsp'">&nbsp;&nbsp;
               	<input id="btn" type="button" value="메인페이지" onClick="location.href='../1.메인사이트/main.jsp'">
            </div>              
            <%}else {%>
			
			<section class="login-form">
        	<h1><ion-icon name="desktop-outline"></ion-icon></h1>
        	<form action="../2.로그인/로그인pro.jsp" method="post">
            <div class="int-area">
                <input type="text" name="id" id="id" autocomplete="off" required>
                <label for="id">USER NAME</label>
            </div>
            <div class="int-area">
                <input type="password" name="pw" id="pw" autocomplete="off" required>
                <label for="pw">PASSWORD</label>
            </div>
            <div class="btn-area">
               <input id="btn" type="submit" value="로그인">&nbsp;&nbsp;
               <input id="btn" type="button" value="회원가입" onClick="location.href='../3.회원가입/회원가입.jsp'">
            </div>     
            </form>       
        	</section>
            <%}%>
</body>
</html>