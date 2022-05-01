<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <link rel="stylesheet" href="/css/신청서.css">
</head>
<%
 int joincode = Integer.parseInt(request.getParameter("s_JOINCODE"));
 String pageNum = request.getParameter("pageNum");
 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH :mm");
 
 try{
	 MyStudyDAO dbPro = MyStudyDAO.getInstance();
	 MyStudyVO article = dbPro.getArticle2(joincode);
	 
 %>
<body>
    <div class="container">
        <div class="title">스터디 신청</div>
        <div class="user-details">
            <div class="input-box">
                <span class="details">신청 제목</span>
                <input type="text" name="title" value="<%=article.getSj_TITLE()%>" readonly>
            </div>
        <form action="#">
            <div class="user-details">
                <div class="input-box">
                    <span class="details">신청자</span>
                    <input type="text" name="name" value="<%=article.getSj_NAME() %>" readonly>
                </div>
                <div class="input-box">
                    <span class="details">신청날짜</span>
                    <input type="text" name="password" value="<%=article.getSj_DATE() %>" readonly>
                </div>
                <span>신청내용</span>
                <div class="gender-details">
                    <textarea placeholder="<%=article.getSj_CONTENT() %>" name="content"  readonly></textarea>
                </div>
            </div>
            <div class="button">
                <input type="button" name="get" value="수락" onClick="location.href='/스터디신청/신청메인.jsp'">
                <input type="button" name="turn" value="거절"  style="float: right;" onClick="location.href='/스터디신청/신청메인.jsp'">
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