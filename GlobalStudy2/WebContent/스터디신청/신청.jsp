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
      <link href="../css/main.css" rel="stylesheet"/>
        <link href="../css/사이드바.css" rel="stylesheet"/>
        <link href="../css/목록.css" rel="stylesheet">
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
     <nav class="navbar">
            <div class="navbar_logo">
                <i class="fa-solid fa-award"></i>   
                <a href="../1.메인사이트/main.jsp">Global Study</a>
            </div>
            <ul class="navbar_menu">
                <li><a href="../4.스터디찾기/스터디목록.jsp">스터디찾기</a></li>
                <li><a href="../5.스터디등록/스터디등록.jsp">스터디등록</a></li>
                <li><a href="../스터디정보/정보메인.jsp">내스터디</a></li>
                <li><a href="#">후기작성</a></li>
            </ul>
            <ul class="navbar_icons">              
                <li><a href="../2.로그인/로그인.jsp"><i class="fa-solid fa-user"></i></a></li>
            </ul>
    
            <a href="../4.스터디찾기/스터디목록.jsp" class="navbar_toogleBtn">
                <i class="fa-solid fa-bars"></i>
            </a>
        </nav>
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top" id="sideNav">
            <a class="navbar-brand js-scroll-trigger" href="#page-top">
                <span class="d-block d-lg-none">언어스터디</span>
                
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav">           
                    <li class="nav-item"><a class="nav-link js-scroll-trigger" href="../스터디정보/정보메인.jsp">스터디정보</a></li>
                    <li class="nav-item"><a class="nav-link js-scroll-trigger" href="../스터디신청/신청메인.jsp">스터디신청</a></li>
                    <li class="nav-item"><a class="nav-link js-scroll-trigger" href="../스터디관리/관리메인.jsp">스터디관리</a></li>
                    <li class="nav-item"><a class="nav-link js-scroll-trigger" href="../스터디후기/후기메인.jsp">후기작성</a></li>
                </ul>
            </div>
        </nav>    
    <div class="container">
        <div class="title">스터디 신청</div>
        <div class="user-details">
            <div class="input-box">
                <span class="details">신청 제목</span>
                <input type="text" name="title" value="<%=article.getSj_TITLE()%>" readonly>
            </div>
        <form action=""   method="post">
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
              <input type="submit" value="수락" onclick="this.form.action='../스터디신청/신청수락.jsp'" >                                 
                                    <input type="submit" value="거절" onclick="this.form.action='../스터디신청/신청거절.jsp'" >
                                     <input type="hidden" name="s_JOINCODE" value="<%=article.getS_JOINCODE()%>">   
                                        
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