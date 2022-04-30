<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<% request.setCharacterEncoding("UTF-8"); %>

<%
	String M_NAME = request.getParameter("M_NAME");
	String M_ID = request.getParameter("M_ID");
	String M_PW = request.getParameter("M_PW");
	String M_PWC = request.getParameter("M_PWC");
	String M_PHONE = request.getParameter("M_PHONE");
	String M_EMAIL = request.getParameter("M_EMAIL");
	Connection conn = null;
	PreparedStatement pstmt = null;
	String str="";
	try{
	 	 String jdbcUrl="jdbc:mysql://localhost:3306/Usera";
	     String dbId="test";
	     String dbPass="1234";
	 	 
	 	 Class.forName("com.mysql.jdbc.Driver");
	 	 conn=DriverManager.getConnection(jdbcUrl,dbId ,dbPass );
	
	 	String sql= "insert into member values (?,?,?,?,?,?)";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1,M_NAME);
		pstmt.setString(2,M_ID);
		pstmt.setString(3,M_PW);
		pstmt.setString(4,M_PWC);
		pstmt.setString(5,M_PHONE);
		pstmt.setString(6,M_EMAIL);
		pstmt.executeUpdate();
		
		out.println("member 테이블에 새로운 정보를 추가했습니다");
		
		}catch(Exception e){
			e.printStackTrace();
			out.println("member 테이블에 새로운 정보를 추가하지 못했습니다");
		}finally{
			if(pstmt !=null)
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
</head>
<body>
		<h2>회원가입을 축하합니다</h2>
		<a href="login.jsp">로그인하기</a>
</body>
</html>