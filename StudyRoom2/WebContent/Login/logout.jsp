<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    session.invalidate();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" http-equiv="Refresh" content="3;url=login.jsp">
<title>Logout</title>
</head>
<body>
<font size="5">
성공적으로 로그아웃 되었습니다.<br><br>
아래 로그인 페이지로 이동을 클릭하거나 3초후 로그인페이지로 이동합니다.
<a href="http://localhost:8000/GlobalStudy/Login/login.jsp">로그인 페이지로 이동</a>
</font>
</body>
</html>