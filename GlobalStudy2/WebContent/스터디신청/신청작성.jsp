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
    <link rel="stylesheet" href="../css/신청서.css">
</head>
<%

 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH :mm");
 
 try{
	 MyStudyDAO dbPro = MyStudyDAO.getInstance();
 %>
<body>
    <div class="container">
        <div class="title">스터디 신청</div>
        <form action="신청작성Proc.jsp" method="get">
            <div class="user-details">
            <div class="input-box">
                <span class="details">신청 제목</span>
                <input type="text" name="title" >
            </div>
                <div class="input-box">
                    <span class="details">신청자</span>
                    <input type="text" name="name" value="<%=article.getM_NAME() %>">
                </div>
                <div class="input-box">
                    <span class="details">신청날짜</span>
                    <input type="text" name="date"  >
                </div>
                <span>신청내용</span>
                <div class="gender-details">
                    <textarea placeholder="내용 입력" name="content"  ></textarea>
                </div>
            </div>
            <div class="button">
                <input type="submit" value="보내기" >
                <input type="button" name="turn" value="뒤로"  style="float: right;" onClick="location.href=''">
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