<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="Login.LoginVO" %>
    <jsp:useBean id="dao" class="Login.LoginDAO"/>
    <%
    String id = request.getParameter("id");
    String pw = request.getParameter("pw");
    int check = dao.loginCheck(id, pw);
    if(check==1){
        LoginVO vo = dao.getinstance(id);
        String memCode= vo.getMemCode();
        String name= vo.getName();    	
    	session.setAttribute("loginID", id);
    	session.setAttribute("M_MemCode",memCode );
    	session.setAttribute("M_Name", name);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" http-equiv="Refresh" content="0;url=../1.메인사이트/main.jsp">
<title>Insert title here</title>
</head>
<body>
<%}else if(check==0){%>
<script type="text/javascript">
alert("비밀번호가 틀립니다.");
history.go(-1);
</script>
<%} else{ %>
<script type="text/javascript">
alert("아이디가 존재하지 않습니다.");
history.go(-1);
</script>
<%} %>
</body>
</html>