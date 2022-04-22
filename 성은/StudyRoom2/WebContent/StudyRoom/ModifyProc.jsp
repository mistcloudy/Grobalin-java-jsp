<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="StudyRoom.*" %>
    <%@ page import="java.util.*" %>
    <%@ page import="java.text.SimpleDateFormat" %>
    
    <% request.setCharacterEncoding("utf-8"); %>
    <%
    //수정한 오늘 날짜를 적용(미완)
    /* Date now = new Date();
    SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
    String WriteDay = sf.format(now);
    System.out.println(WriteDay); */
    String StudyCode = request.getParameter("StudyCode");
   
    
    String M_MemCode = (String)session.getAttribute("M_MemCode");
	String Title = request.getParameter("Title");
	String Content = request.getParameter("Content");
	String Area = request.getParameter("Area");
	String LanName = request.getParameter("LanName");
	String Level = request.getParameter("Level");
	String Week = request.getParameter("Week");
	String PartTime = request.getParameter("PartTime");
	String ChatLink = request.getParameter("ChatLink");
	
	
	StudyRoomVO Stvo = new StudyRoomVO();
	Stvo.setTitle(Title);
	Stvo.setContent(Content);
	Stvo.setArea(Area);
	Stvo.setLanName(LanName);
	Stvo.setLevel(Level);
	Stvo.setWeek(Week);
	Stvo.setPartTime(PartTime);
	Stvo.setChatLink(ChatLink);
	Stvo.setStudyCode(StudyCode);
	StudyRoomDAO Stdao = StudyRoomDAO.getInstance();

	Stdao.updateStudy(Stvo);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" http-equiv="Refresh" content="3;url=ListStudy.jsp">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<b>회원 정보가 수정되었습니다. 3초 후 메인화면으로 돌아갑니다.</b>
</div>
</body>
</html>