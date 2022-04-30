<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<% request.setCharacterEncoding("utf-8");%>
<% 
   String M_NAME = request.getParameter("M_NAME");
   String M_ID= request.getParameter("M_ID");
   String M_PW = request.getParameter("M_PW");
   String M_PHONE = request.getParameter("M_PHONE");
   String M_EMAIL = request.getParameter("M_EMAIL");

   Connection conn=null;
   PreparedStatement pstmt=null;
   String str="";
   
   try{
 	 String jdbcUrl="jdbc:oracle:thin:@localhost:1521:xe";
     String dbId="test";
     String dbPass="1234";
 	 
 	 Class.forName("oracle.jdbc.driver.OracleDriver");
 	 conn=DriverManager.getConnection(jdbcUrl,dbId ,dbPass);
 	
 	 String sql = "INSERT INTO Member_2 values(?,?,?,?,?)";
 	 pstmt=conn.prepareStatement(sql);
 	 pstmt.setString(1,M_NAME);
     pstmt.setString(2,M_ID);
 	 pstmt.setString(3,M_PW);
 	 pstmt.setString(4,M_PHONE);
 	 pstmt.setString(5,M_EMAIL);
 	
 	 pstmt.executeUpdate(); 
 	 out.println("회원가입을 축하드립니다.");

 	}catch(Exception e){ 
 		e.printStackTrace();
 		out.println("서버에 장애가 발생 하였습니다");
 	}finally{
 		if(pstmt != null) 
 			try{pstmt.close();}catch(SQLException sqle){}
 		if(conn != null) 
 			try{conn.close();}catch(SQLException sqle){}
 	}
 %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="../User/css/user.css">
</head>
<body>
</body>
</html>