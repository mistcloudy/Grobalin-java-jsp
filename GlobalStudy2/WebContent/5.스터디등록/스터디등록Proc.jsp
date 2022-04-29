<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="StudyRoom.*" %>
    <%@ page import="java.sql.*" %>
    <%request.setCharacterEncoding("utf-8"); %>
    <jsp:useBean id="vo" class="StudyRoom.StudyRoomVO" scope="request"></jsp:useBean>
    <jsp:setProperty property="*" name="vo"/>
    
    <%
    if(vo.getTitle()==null||vo.getLanName()==null||vo.getLevel()==null||vo.getArea()==null||
    	vo.getWeek()==null||vo.getPartTime()==null||vo.getChatLink()==null||vo.getChatLink()==null){
    %>
    <!-- 스터디 제목 미입력 -->
<%if(vo.getTitle()==null){
	%>
<script type="text/javascript">
alert("스터디 제목을 입력하지 않았습니다.");
history.go(-1);/*history.back() 이전 페이지로 가기*/
</script>
<!-- 언어명 미입력 -->
<%} else if(vo.getLanName()==null){
	%>
<script type="text/javascript">
alert("언어명을 입력하지 않았습니다.");
history.go(-1);/*history.back() 이전 페이지로 가기*/
</script>	
<!-- 언어레벨 미입력 -->
<%} else if(vo.getLevel()==null){
	%>
	<script type="text/javascript">
alert("언어 레벨을 입력하지 않았습니다.");
history.go(-1);/*history.back() 이전 페이지로 가기*/
</script>
<!-- 지역 미입력 -->
<%}else if(vo.getArea()==null){
	%>
<script type="text/javascript">
alert("지역을 입력하지 않았습니다.");
history.go(-1);/*history.back() 이전 페이지로 가기*/
</script>
<!-- 스터디 요일 미입력 -->
<%} else if(vo.getWeek()==null){
	%>
<script type="text/javascript">
alert("스터디 요일을 입력하지 않았습니다.");
history.go(-1);/*history.back() 이전 페이지로 가기*/
</script>
<!-- 스터디 시간 미입력 -->
<%} else if(vo.getPartTime()==null){
	%>
	<script type="text/javascript">
alert("스터디 시간을 입력하지 않았습니다.");
history.go(-1);/*history.back() 이전 페이지로 가기*/
</script>
<!-- 오픈채팅 링크 미입력 -->
<%} else if(vo.getChatLink()==null){
	%>
	<script type="text/javascript">
alert("오픈 채팅 링크를 입력하지 않았습니다.");
history.go(-1);/*history.back() 이전 페이지로 가기*/
</script>
<!-- 스터디 내용 미입력 -->
<%} else if(vo.getContent()==null){
	%>
	<script type="text/javascript">
alert("스터디 내용을 입력하지 않았습니다.");
history.go(-1);/*history.back() 이전 페이지로 가기*/
</script>
	<%}
    }else{
	%>
	<%
	StudyRoomDAO dao = StudyRoomDAO.getInstance();
	dao.insertStudy(vo);
    }
	%>
<html>
<head>
<meta charset="UTF-8" http-equiv="Refresh" content="0;url=../4.스터디찾기/스터디목록.jsp">
<title>Insert title here</title>
</head>
<body>
</body>
</html>