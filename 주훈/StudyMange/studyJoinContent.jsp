<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="StudyMange.StudyMangeDAO" %>
    <%@ page import="StudyMange.StudyMangeVO" %>
    <%@ page import="java.text.SimpleDateFormat"%>
    <%@ include file="view/color.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스터디 신청</title>
<link href="style.css" type="text/css rel="stylesheet">
</head>
<%
 int num = Integer.parseInt(request.getParameter("num"));
 String pageNum = request.getParameter("pageNum");
 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH :mm");
 try{
	 StudyMangeDAO dbPro = StudyMangeDAO.getInstance();
	 StudyMangeVO article = dbPro.getArticle(num);
	 
 %>
<body>
<div align="center">
<b>스터디 신청</b><br><br>
<form>
<table width="500" border="1" cellpadding="0" cellspacing="0" align="center" bgcolor="<%=bodyback_c%>">
<tr height="30">
<td align="center" width="125" bgcolor="<%=value_c%>">스터디 번호</td>
<td align="center" width="125"><%=article.getS_STUDYCODE() %></td>

<td align="center" width="125" bgcolor="<%=value_c%>">보낸 사람</td>
<td align="center" width="125"><%=article.getM_MEMCODE()%></td>
</tr>
<tr height="30">
<td align="center" width="125" bgcolor="<%=value_c%>">보낸 날짜</td>
<td align="center" width="125"><%=article.getSC_JOINDAY() %></td>
</tr>
<tr height="30">
<td align="center" width="125" bgcolor="<%=value_c%>">제목</td>
<td align="center" width="375" colspan="3"><%=article.getSJ_TITLE()%></td>
</tr>
<tr height="30">
<td align="center" width="125" bgcolor="<%=value_c%>">내용</td>
<!-- <pre> 입력된 그대로, 엔터키로 문장을 끊은 그대로, !다른태그의 경우 그대로 내용들이 모두 이어져서 나옴 -->
<td align="center" width="375" colspan="3"><pre><%=article.getSJ_CONTENT()%></pre></td>
</tr>

</table>
<%}catch(Exception e){
	e.printStackTrace();
}
 %>
</form>
</div>
</body>
</html>