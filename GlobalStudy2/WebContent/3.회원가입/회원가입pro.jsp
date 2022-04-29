<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("utf-8");%>
    <jsp:useBean id="vo" class="Login.LoginVO" />
    <jsp:useBean id="dao" class="Login.LoginDAO" />
    <jsp:setProperty property="*" name="vo"/>
    <%
    boolean flag = dao.memberInsert(vo);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" http-equiv="Refresh" content="0;url=../1.메인사이트/main.jsp">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
alert("회원가입이 완료되었습니다. 로그인 해주시기 바랍니다.");
</script>
</body>
</html>