<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String loginID=(String)session.getAttribute("loginID");
	%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link type="text/css" rel="stylesheet" href="../2.로그인/css/Login.css">
    <script src="/2.로그인/libs/jquery-3.6.0.min.js"></script>
    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
<script type="text/javascript">
function begin() {
	document.myForm.pw.focus();
}
function checkIt(){
	if(!document.myForm.pw.value){
		alert("비밀번호를 입력하지 않았습니다.");
		documenet.myForm.pass.focus();
		return false;
	}
}
</script>
</head>
<body>
<form action="회원탈퇴pro.jsp">
<section class="login-form">
        	<h1><ion-icon name="desktop-outline"></ion-icon></h1>
            <div class="int-area">
                <input type="text" name="id" id="id" autocomplete="off" readonly>
                <label for="id"><%=loginID %>님 탈퇴 하시겠습니까?</label>
            </div>
            <div class="int-area">
                <input type="password" name="pw" id="pw" autocomplete="off">
                <label for="pw">패스워드를 입력해주세요</label>
            </div>
            <div class="btn-area">
            	<input id="btn" type="submit" value="회원탈퇴">&nbsp;&nbsp;
               	<input id="btn" type="button" value="취소" onClick="location.href='../1.메인사이트/main.jsp'">
            </div>
        </form>
    </div>
</body>
</html>