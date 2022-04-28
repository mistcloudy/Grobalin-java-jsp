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
    <title>스터디 등록</title>
    <script src="https://kit.fontawesome.com/ea243819fd.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="stylesheet" href="../css/검색등록.css">
</head>
<%
 int num = Integer.parseInt(request.getParameter("s_STUDYCODE"));
 String pageNum = request.getParameter("pageNum");
 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH :mm");
 
 try{
	 MyStudyDAO dbPro = MyStudyDAO.getInstance();
	 MyStudyVO article = dbPro.getArticle(num);
	
 %>
<body>
    <div class="container">
        <div class="title">스터디등록된거</div>
        <form action="#">
            <div class="user-details">
                <div class="input-box">
                    <span class="details">작성자 이름</span>
                    <input type="text" name="name" value="<%= article.getM_NAME()%>" readonly>
                </div>
                <div class="input-box">
                    <span class="details">스터디 제목</span>
                    <input type="text" name="title" value="<%=article.getS_TITLE()%>" readonly>
                </div>
                <div class="input-box">
                    <span class="details">지역</span>
                     <input type="text" name="area" value="<%=article.getS_AREA()%>" readonly>
                </div>
                <div class="input-box">
                    <span class="details">언어명</span>
                     <input type="text" name="language" value="<%=article.getS_LANNAME()%>" readonly>
                </div>
                <div class="input-box">
                    <span class="details">모임날짜</span>
                    <input type="text" name="week" value="<%=article.getS_WEEK()%>" readonly>
                </div>
                <div class="input-box">
                    <span class="details">모임시간</span>
                    <input type="text" name="parttime" value="<%=article.getS_PARTTIME()%>"  readonly>
                </div>
                <div class="input-box">
                    <span class="details">스터디 기간</span>
                    <input type="text" name="startday" value="<%=article.getS_STARTDAY()%>"  readonly>
                    <span></span>
                    <input type="text" name="endday" value="<%=article.getS_ENDDAY()%>" readonly>
                </div>
                <div class="input-box">
                    <span class="details">작성 날짜</span>
                    <input type="text"" name="writeday" value="<%=article.getS_WRITEDAY()%>" readonly>
                </div>
                <span class="details">스터디 내용</span>
            </div>
            <div class="gender-details">
                <textarea placeholder="<%=article.getS_CONTENT()%>" name="content" readonly></textarea>
            </div>
            <div class="button">
                <input type="button" value="수정" onClick="location.href='../스터디정보/스터디수정.jsp?s_STUDYCODE=<%=num%>&pageNum=<%=pageNum%>'">
                <input type="button" value="뒤로" onClick="location.href='../스터디정보/정보메인.jsp'">
            </div>
        </form>
     
    </div>
   
            <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
            <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>          
                <%}catch(Exception e){
	e.printStackTrace();
}
 %>
</body>
</html>