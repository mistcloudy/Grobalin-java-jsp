<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ page import="Login.LoginDAO" %>
    <jsp:useBean id="dao" class="Login.LoginDAO" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" http-equiv="Refresh" content="0;url=../1.메인사이트/main.jsp">
<title>Insert title here</title>
<%
	String id=(String)session.getAttribute("loginID");
	String pw = request.getParameter("pw");
	
	int check = dao.deleteMember(id,pw);
	if(check==1){
		session.invalidate();
%>
</head>
<body>
<script type="text/javascript">
alert("탈퇴가 완료되었습니다. 다음에 필요할때 다시 가입해 주시기 바랍니다.");
</script>
<%} else{ %>
<script type="text/javascript">
alert("비밀번호가 일치하지 않습니다.");
history.go(-1);
</script>
<%} %>
</body>
</html>