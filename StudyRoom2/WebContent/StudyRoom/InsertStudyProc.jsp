<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="StudyRoom.*" %>
    <%@ page import="java.sql.*" %>
    <%request.setCharacterEncoding("utf-8"); %>
    
	<%
	String M_MemCode = request.getParameter("M_MemCode");
	String M_Name = request.getParameter("M_Name");
	String Title = request.getParameter("Title");
	String Content = request.getParameter("Content");
	String Area = request.getParameter("Area");
	String LanName = request.getParameter("LanName");
	String Level = request.getParameter("Level");
	String Week = request.getParameter("Week");
	String PartTime = request.getParameter("PartTime");
	String ChatLink = request.getParameter("ChatLink");
	
	StudyRoomVO Stvo = new StudyRoomVO();
	
	Stvo.setM_MemCode(M_MemCode);
	Stvo.setM_Name(M_Name);
	Stvo.setTitle(Title);
	Stvo.setContent(Content);
	Stvo.setArea(Area);
	Stvo.setLanName(LanName);
	Stvo.setLevel(Level);
	Stvo.setWeek(Week);
	Stvo.setPartTime(PartTime);
	Stvo.setChatLink(ChatLink);
	StudyRoomDAO Stdao = StudyRoomDAO.getInstance();
	Stdao.insertStudy(Stvo);
	
	response.sendRedirect("ListStudy.jsp");

	%>