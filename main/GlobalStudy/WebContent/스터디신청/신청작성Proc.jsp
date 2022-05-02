<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="StudyRoom.*" %>
    <%@ page import="java.sql.*" %>
    <%request.setCharacterEncoding("utf-8");%>
<jsp:useBean id="vo" class="StudyRoom.StudyRoomVO" scope="request"></jsp:useBean>
<jsp:setProperty property="*" name="vo" />


<%
StudyRoomDAO dbPro =StudyRoomDAO.getInstance();
dbPro.insertJoin(vo);
    
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" http-equiv="Refresh" content="0;url=../4.스터디찾기/스터디목록.jsp">
<title>Insert title here</title>
</head>
<body>

</body>
</html>

