<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ page import="StudyRoom.*" %>
    <%@ page import="MyStudy.MyStudyDAO" %>
    <%@ page import="MyStudy.MyStudyVO" %>
    <%@ page import="java.util.List" %>
    <%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>신청양식</title>
    <link rel="stylesheet" href="../css/신청서.css">
</head>
<%
	int StudyCode = Integer.parseInt(request.getParameter("StudyCode"));
String loginID=(String)session.getAttribute("loginID");
String code=(String)session.getAttribute("M_MemCode");
String M_Name=(String)session.getAttribute("M_Name"); 	


 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH :mm");
 
 try{
	 
 %>
<body>
<div class="soun">
    <div class="container">
        <div class="title">스터디 신청</div>
        <form action="../스터디신청/신청작성Proc.jsp" method="get">
        <input type="hidden" name="StudyCode" value="<%=StudyCode %>">
          <input type="hidden" name="memCode" value="<%=code%>">
            <div class="user-details">
              <div class="input-box">
                    <span class="details">신청자</span>
                    <input type="text" name="name" value="<%=M_Name %>"  readonly>
                </div>
            <div class="input-box">
                <span class="details">신청 제목</span>
                <input type="text" name="title" >
            </div>
                <span>신청내용</span>
                <div class="gender-details">
                    <textarea placeholder="내용 입력" name="content"  ></textarea>
                </div>
            </div>
            <div class="button">
                <input type="submit" value="보내기" >
                <input type="button" name="turn" value="목록으로"  style="float: right;" onClick="location.href='../4.스터디찾기/스터디목록.jsp'">
                                 
            </div>
           
        </form>
    </div>
   </div>
         <%}catch(Exception e){
	e.printStackTrace();
}
 %>
</body>
</html>