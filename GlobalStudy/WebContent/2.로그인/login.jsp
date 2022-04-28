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
<link type="text/css" rel="stylesheet" href="style.css">
</head>
<body>
<form action="loginProc.jsp" method="post">
<table width="500" border="1">
	<tr>
	<td width="300" colspan="2" align="center">회원 로그인</td>
	</tr>
	<tr>
	<td width="100" align="right">이름 : </td>
	<td>&nbsp;&nbsp;<input type="text" name="M_Name"  size="20"></td>
	</tr>
	<tr>
	<td width="100" align="right">회원코드 : </td>
	<td>&nbsp;&nbsp;<input type="text" name="M_MemCode"  size="20"></td>
	</tr>
	<tr>
	<td colspan="2" align="center">
	<input type="submit" value="로그인">&nbsp;&nbsp;
	</td>
	</tr>
	</table>
	</form>
</body>
</html>