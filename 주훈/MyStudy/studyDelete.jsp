<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="view/color.jsp"%>
    <%
    int num = Integer.parseInt(request.getParameter("num"));
    String pageNum = request.getParameter("pagetNum");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 스터디</title>
<link href="style.css" type="text/css" rel="stylesheet">
<script type ="text/javascript">
function deleteSave(){
	if(document.delForm.pass.value==""){
		alert("비밀번호를 입력해 주세요.");
		document.delForm.pass.focus();
		return false;
	}
}
</script>
</head>
<body bgcolor="<%=bodyback_c %>">
<div align="center">
<b>스터디 삭제</b><br><br>
<form action="deleteProc.jsp?pageNum=<%=pageNum%>" method="post" name="delFomr" onsubmit="return deleteSave()">
<table width="360" border="1" cellspacing="0" cellpadding="0" align="center">
<tr heigth="30">
<td align="center" bgcolor=<%=value_c %>">
<b>비밀번호를 입력해 주세요.</b>
</td>
</tr>
<tr height="30">
<td align="center">비밀번호:
<input type="password" name="pass" size="8" maxlength="12">
<input type="hidden" name="num" value="<%=num %>"></td>
</tr>
<tr height="30">
<td align="center" bgcolor="<%=value_c %>">
<input type="submit" value="삭제">
<input type="button" value="취소">
</td>
</tr>
</table>
</form>
</div>
</body>
</html>