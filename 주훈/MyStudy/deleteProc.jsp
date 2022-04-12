<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="boardone.*, java.sql.*" %>
    <%
    request.setCharacterEncoding("utf-8");
    int num= Integer.parseInt(request.getParameter("num"));
    String pageNum =request.getParameter("pageNum");
    String pass =request.getParameter("pass");
    
    BoardDAO dbPro = BoardDAO.getInstance();
    
    int check= dbPro.deleteArticle(num, pass);
    if(check==1){
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" http-equiv="Refresh" content="0;url=list.jsp?pageNum=<%=pageNum%>">
<title>Insert title here</title>
</head>
<body>
<%} else{ %>
<script type="text/javascript">
alert("비밀번호가 틀렸습니다.");
</script>
<%} %>
</body>
</html>