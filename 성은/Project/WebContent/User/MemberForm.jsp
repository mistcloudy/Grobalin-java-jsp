<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String M_MemCode = (String)session.getAttribute("M_MemCode");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log in</title>
</head>
<link type="text/css" rel="stylesheet" href="../User/css/user.css">
<body>
<form method="post" action="MemberPro.jsp">
  <section class="login-form">
        <h1><ion-icon name="desktop-outline"></ion-icon></h1>
        	<h1>회원가입을 해주세요</h1>
         	<div class="int-area">
                <input type="text" name="M_NAME" id="id" autocomplete="off" required>
                <label for="id">NAME</label>
            </div>
            <div class="int-area">
                <input type="text" name="M_ID" id="id" autocomplete="off" required>
                <label for="id">USER ID</label>
            </div>
            <div class="int-area">
                <input type="password" name="M_PW" id="pw" autocomplete="off" required>
                <label for="pw">PASSWORD</label>
            </div>
              <div class="int-area">
                <input type="text" name="M_PHONE" id="pw" autocomplete="off" required>
                <label for="pw">TLE</label>
            </div>
              <div class="int-area">
                <input type="text" name="M_EMAIL" id="pw" autocomplete="off" required>
                <label for="pw">EAMIL</label>
            </div>
            <div class="btn-area">
               <button id="btn" type="sumbit" >회원가입</button>
            </div>
   			</form>
        <div class="caption">
        </div>
    </div>
   </section>
</body>
</html>