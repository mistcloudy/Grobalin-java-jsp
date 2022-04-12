<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="MyStudy.MyStudyVO" %>
    <%@ page import="MyStudy.MyStudyDAO" %>
    <%@ page import="java.util.List" %>
    <%@ page import="java.text.SimpleDateFormat" %>
    <%@ include file="view/color.jsp" %>
    
    <%!
    //한페이지에 보여줄 게시글 수를 지정함
    int pageSize = 3;
    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    %>
    <%
    String pageNum = request.getParameter("pageNum");
   
    if(pageNum==null){
    	pageNum="1";
    }
    //현재 페이지
    int currentPage = Integer.parseInt(pageNum);
    int startRow=(currentPage-1)*pageSize+1;
    int endRow=currentPage*pageSize;
    
    
    int count = 0;
    int number = 0;
    
    List<MyStudyVO>articleList = null;
    MyStudyDAO dbPro = MyStudyDAO.getInstance();
    //데이터 베이스로부터 전체 글의 갯수를 가져와서 count 변수에 저장    
    count = dbPro.getArticleCount();
    //검색이 아니면 전체 리스트를 보여주고, 검색이면 검색한 내용만 보여주기
    
    //count>0 == 글이 1개이상 존재한다.
    if(count>0){
    	//글을 가져와서 articleList에 저장
    	articleList = dbPro.getArticles(startRow,endRow);
    }
    number = count-(currentPage-1)*pageSize;
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 스터디</title>
<link href="style.css" type ="text/css" rel="stylesheet">
</head>
<body bgcolor="<%=bodyback_c%>">
<div align="center">
<b>스터디 목록(스터디 수:<%=count %>)</b>

<%if(count==0){//글이 1개도 없는 경우 
%>
<table width="700" border="1" cellpadding="0" cellspacing="0">
<tr>
<td align="center">
스터디가 없습니다.
</td>
</tr>
</table>
<%}else{//글이 있는경우 %>
<table width="700" border="1" cellpadding="0" cellspacing="0" aling="center">
<tr height="30" bgcolor="<%=value_c%>">
<td align="center" width="50">번호</td>
<td align="center" width="250">스터디 이름</td>
<td align="center" width="100">지역</td>
<td align="center" width="100">언어</td>
<td align="center" width="100">시작일자</td>
<td align="center" width="100">종료일자</td>
</tr>

<%for(int i=0;i<articleList.size();i++){
	MyStudyVO article = (MyStudyVO)articleList.get(i);
	%>
<tr height="30">
<td align="center" width="50"><%=number-- %></td>
<td align="center" width="250">

<%
	int wid=0;
if(article.getDepth() >  0){
	wid= 3 * (article.getDepth());
%>
<%} %>
<a href="content.jsp?num=<%=article.getS_STUDYCODE()%>&pageNum=<%=currentPage%>">
<%=article.getS_TITLE() %></a>
<!-- 조회수가 많아지면 별도의 이미지로 표기(20회 이상) -->
<%if(article.getReadcount()>=20){ %>
<img src="images/hot.gif" border="0" height="16">
<%} %>
</td>
<td align="center" width="100">>
<%=article.getS_AREA() %></td>
<td align="center" width="100">
<%=article.getS_LANNAME() %></td>
<td align="center" width="100">
<%=article.getS_STARTDAY() %></td>
<td align="center" width="100">
<%=article.getS_ENDDAY() %></td>
</tr>
<tr height="30">
<td align="center" width="100" bgcolor="<%=value_c%>">
<a href="Form.jsp">스터디 보기</a>
</td><td align="center" width="100" bgcolor="<%=value_c%>">
<a href="Form.jsp">스터디 수정</a>
</td><td align="center" width="100" bgcolor="<%=value_c%>">
<a href="studyDelete.jsp">스터디 삭제</a>
</td><td align="center" width="100" bgcolor="<%=value_c%>">
<a href="StudyJoinList.jsp">스터디 관리</a>
</td><td align="center" width="100" bgcolor="<%=value_c%>">
<a href="StudyManageList.jsp">스터디 신청</a>
</td><td align="center" width="100" bgcolor="<%=value_c%>">
<a href="Form.jsp">후기 작성</a>
</td>
</tr>
	<%} %>
</table>
<%} %>
<%--페이징 처리 --%>
<%
if(count>0){
	 
	int pageBlock=3;
	int imsi = count%pageSize==0?0:1;
	int pageCount = count/pageSize + imsi;
	int startPage = (int)((currentPage-1)/pageBlock)*pageBlock+1;
	int endPage = startPage+pageBlock -1;
	if(endPage>pageCount) endPage=pageCount;
	
	//이전 블럭, 다음블럭
	if(startPage>pageBlock){
		//검색일 경우와 아닐경우 페이지 처리
	
		%>
		<a href="list.jsp?pageNum=<%=startPage-pageBlock%>">[이전]</a>
		<% 
	for(int i = startPage;i<=endPage;i++){
	%>
	<a href="list.jsp?pageNum=<%=i%>">[<%=i%>]</a>
<% }
	if(endPage<pageCount){
	 %>
		<a href="list.jsp?pageNum=<%=startPage+pageBlock%>">[다음]</a>
		<% 		
}
	}
%>
<form action="studyList.jsp">
<select name="searchWhat">
<option value="writer">작성자</option>
<option value="subject">제목</option>
<option value="content">내용</option>
</select>
<input type="text" name="searchText">
<input type="submit" value="검색">
</form>
</div>
</body>
</html>