	<%@ page language="java" contentType="text/html; charset=UTF-8"
    	pageEncoding="UTF-8"%>
    	<%@ page import="MyStudy.*, java.sql.*"%>
	<%request.setCharacterEncoding("utf-8");%>
<jsp:useBean id="article" class="MyStudy.MyStudyVO" scope="page">
<jsp:setProperty property="*" name="article" />
</jsp:useBean>
    <%
    int code= Integer.parseInt(request.getParameter("membercode"));
    MyStudyDAO dbPro = MyStudyDAO.getInstance();
    dbPro.deleteArticle3(code);
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" http-equiv="Refresh" content="0;url=../스터디관리/관리메인.jsp">
<title>Insert title here</title>
</head>
<body>

</body>
</html>