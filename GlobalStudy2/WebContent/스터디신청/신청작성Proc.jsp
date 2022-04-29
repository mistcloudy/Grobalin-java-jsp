<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="MyStudy.*, java.sql.*"%>
    <%request.setCharacterEncoding("utf-8");%>
<jsp:useBean id="article" class="MyStudy.MyStudyVO" scope="page">
<jsp:setProperty property="*" name="article" />
</jsp:useBean>

  <%
    if(article.getSj_TITLE()==null||article.getSj_NAME()==null||article.getSj_DATE()==null||article.getSj_CONTENT()==null){
    %>
<%if(article.getSj_TITLE()==null){
	%>
<script type="text/javascript">
alert("신청 제목을 입력하지 않았습니다.");
history.go(-1);
</script>
<%} else if(article.getSj_NAME()==null){
	%>
<script type="text/javascript">
alert("신청자를 입력하지 않았습니다.");
history.go(-1);
</script>
<%} else if(article.getSj_DATE()==null){
	%>
<script type="text/javascript">
alert("신청날짜 입력하지 않았습니다.");
history.go(-1);
</script>
<%} else if(article.getSj_CONTENT()==null){
	%>
	<script type="text/javascript">
alert("신청 내용을 입력하지 않았습니다.");
history.go(-1);
</script>
<%}
    }else{
	%>
<%
MyStudyDAO dbPro = MyStudyDAO.getInstance();
dbPro.insertArticle(article);
    }
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" http-equiv="Refresh" content="0;url=/스터디신청/신청메인.jsp">
<title>Insert title here</title>
</head>
<body>

</body>
</html>

