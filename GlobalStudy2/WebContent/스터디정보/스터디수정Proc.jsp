<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="StudyRoom.*" %>
    <%@ page import="java.sql.*" %>
    <%request.setCharacterEncoding("utf-8"); %>
    <jsp:useBean id="vo" class="StudyRoom.StudyRoomVO" scope="request"></jsp:useBean>
    <jsp:setProperty property="*" name="vo"/>
    
	<%
	StudyRoomDAO dao = StudyRoomDAO.getInstance();
	dao.updateStudy(vo);
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" http-equiv="Refresh" content="0; url=../스터디정보/정보메인.jsp">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<b>회원 정보가 수정되었습니다.메인화면으로 돌아갑니다.</b>
</div>
</body>
</html>