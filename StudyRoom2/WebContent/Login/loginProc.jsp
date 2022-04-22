<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="StudyRoom.*" %>
    <jsp:useBean id="vo" class="StudyRoom.StudyRoomVO"></jsp:useBean>
    
<%
	request.setCharacterEncoding("utf-8");
	String M_Name=request.getParameter("M_Name");
	session.setAttribute("M_Name", M_Name);
	String M_MemCode=request.getParameter("M_MemCode");
	session.setAttribute("M_MemCode", M_MemCode);
	session.setMaxInactiveInterval(60*60);
	
	%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form>
			<table border="1">
				<tr>
					<td colspan="6">
					<%=M_Name %>님 환영합니다.
					</td>
				</tr>
				<tr>
					<td>
						<a href="logout.jsp">로그아웃</a> 
					</td>
					<td>
						<a href="/GlobalStudy/StudyRoom/InsertStudy.jsp">게시판 작성</a>
					</td>
					<td>
						<a href="/GlobalStudy/StudyRoom/ListStudy.jsp">게시판 목록</a>
					</td>
				</tr>
			</table>
		</form>
</body>
</html>