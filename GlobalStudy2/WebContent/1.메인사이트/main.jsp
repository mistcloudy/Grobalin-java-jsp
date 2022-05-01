<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="StudyRoom.StudyRoomDAO"%>
<%@page import="StudyRoom.StudyRoomVO"%>
<%@ page import="StudyRoom.ConnUtil"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>글로벌 스터디</title>
<link rel="stylesheet" href="css/main.css">
<script src="https://kit.fontawesome.com/ea243819fd.js"
	crossorigin="anonymous"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
 <link rel="stylesheet" href="../css/slide.css">
    <link rel="stylesheet" href="../css/메인사이트1.css">
    <link rel="stylesheet" href="../css/메인사이트2.css">
    <link rel="stylesheet" href="../css/footer.css">
<%
request.setCharacterEncoding("utf-8");
String LanName = request.getParameter("LanName");
String Area = request.getParameter("Area");
String Level = request.getParameter("Level");
String Week = request.getParameter("Week");
String loginID=(String)session.getAttribute("loginID");
ArrayList<StudyRoomVO> StudyList = null;
StudyRoomDAO stDao = StudyRoomDAO.getInstance();
ArrayList<StudyRoomVO> ArticleList = stDao.getArticles();

int count = 0;
count = stDao.getCount();
if (count == 0) {
	
	
} else {
	if (LanName == null && Area == null && Level == null && Week == null) {
		StudyList = stDao.getList();
	} else {
		StudyList = stDao.getList(LanName, Area, Level, Week);
		String Lan = LanName;
	}
}
%>


</head>
<body>
	<!-- 메뉴바 3구분 -->
	 <nav class="navbar">
            <div class="navbar_logo">
                <i class="fa-solid fa-award"></i>   
                <a href="../1.메인사이트/main.jsp">Global Study</a>
            </div>
            <ul class="navbar_menu">
                <li><a href="../4.스터디찾기/스터디목록.jsp">스터디찾기</a></li>
                <li><a href="../5.스터디등록/스터디등록.jsp">스터디등록</a></li>               
                <li><a a href="../스터디정보/정보메인.jsp" >내스터디</a></li>                  
                <li><a href="#">후기작성</a></li>
            </ul>
                 <ul class="navbar_icons">
            <li><a href="../2.로그인/로그인.jsp"><i class="fa-solid fa-user"></i></a></li>
        </ul>
    
            <a href="../4.스터디찾기/스터디목록.jsp" class="navbar_toogleBtn">
                <i class="fa-solid fa-bars"></i>
            </a>
        </nav>

	<!-- 슬라이드 div -->
	<div id="slide">
		<input type="radio" name="pos" id="pos1" checked> <input
			type="radio" name="pos" id="pos2"> <input type="radio"
			name="pos" id="pos3"> <input type="radio" name="pos"
			id="pos4">
		<ul>
		    <li><img src="../img/슬라이드.png"></li>
      <li><img src="../img/슬라이드2.png"></li>
      <li><img src="../img/슬라이드3.png"></li>
      <li><img src="../img/슬라이드4.png"></li>
		</ul>
		<p class="pos">
			<label for="pos1"></label> <label for="pos2"></label> <label
				for="pos3"></label> <label for="pos4"></label>
		</p>
	</div>
	<!-- 추천 스터디 -->
	
	<div class="container">
	
		<%
		if (count == 0) {
		%>
		<div class="img" style="background-image: url('/1.메인사이트/img/공명1.png');">
			현재 게시판이 비어있습니다.</div>
		<div class="img" style="background-image: url('/1.메인사이트/img/공명1.png');">
			현재 게시판이 비어있습니다.</div>
		<div class="img" style="background-image: url('/1.메인사이트/img/공명1.png');">
			현재 게시판이 비어있습니다.</div>
		<div class="img" style="background-image: url('/1.메인사이트/img/공명1.png');">
			현재 게시판이 비어있습니다.</div>
		<div class="img" style="background-image: url('/1.메인사이트/img/공명1.png');">
			현재 게시판이 비어있습니다.</div>
		<%
		} else {
		if (ArticleList.size() > 0) {
			for(int i=0; i<ArticleList.size(); i++){
				StudyRoomVO Article = (StudyRoomVO)ArticleList.get(i);
				
		%>
	
		<div class="img" text="<%=Article.getTitle()%>" style="background-image: url('../img/명언4.png');" onclick="location.href='../4.스터디찾기/스터디내용.jsp?studyCode=<%=Article.getStudyCode()%>';">
		<p><%=Article.getTitle()%></p>
				
		</div>
	
			<%
			
			}
			
			} else {
			%>
			<b>검색한 결과가 없습니다. 
	

		<%
		}
		}
		%>  
			
			</div>
		





		<!-- 명언 -->
<div class="body2">
   <div class="container1">
       <div class="box">
           <div class="imgBox">
               <img src="../img/명언1.png">
           </div>
           <div class="details">
               <div class="content">
               <h2>캐럴 버넷</h2>
               <p>나만이 내 인생을 바꿀 수 있다
                   아무도 날 대신해 해줄 수 없다
               </p>
            </div>
           </div>
       </div>
       <div class="box">
        <div class="imgBox">
            <img src="../img/명언2.png">
        </div>
        <div class="details">
            <div class="content">
            <h2>애비게일 애덤스</h2>
            <p>배움은 우연히 얻어지는 것이 아니라
                열성을 다해 갈구하고 부지런히 집중해야 
                얻을 수 있는 것이다
            </p>
         </div>
        </div>
       </div>
       <div class="box">
        <div class="imgBox">
            <img src="../img/명언3.png">
        </div>
        <div class="details">
            <div class="content">
            <h2>빌 게이츠</h2>
            <p>텔레비전은 현실이 아니다
                현실에서는 커피를 마셨으면
                일을 시작해야한다
            </p>
         </div>
        </div>
       </div>
       <div class="box">
        <div class="imgBox">
            <img src="../img/명언4.png">
        </div>
        <div class="details">
            <div class="content">
            <h2>헤리크</h2>
            <p>노력이 적으면 얻는 것도 적다
                인간의 재산은 그의 노고에 달렸다
            </p>
         </div>
        </div>
       </div>
       <div class="box">
        <div class="imgBox">
            <img src="../img/명언5.png">
        </div>
        <div class="details">
            <div class="content">
            <h2>오노레드 발자크</h2>
            <p>아무것도 변하지 않을지라도 내가 변하면 
                모든 것이 변한다
            </p>
         </div>
        </div>
       </div>
       <div class="box">
        <div class="imgBox">
            <img src="../img/명언6.png">
        </div>
        <div class="details">
            <div class="content">
            <h2>찰스 다윈</h2>
            <p>꺼리김없이 한 시간을 낭비하는 사람은
                아직 삶의 가치를 발견하지 못한 사람이다
            </p>
         </div>
        </div>
       </div>
       <div class="box">
        <div class="imgBox">
            <img src="../img/명언7.png">
        </div>
        <div class="details">
            <div class="content">
            <h2>바뤼희 스피노자</h2>
            <p>현재가 과거와 다르길 바란다면
                과거를 공부하라
            </p>
         </div>
        </div>
       </div>
       <div class="box">
        <div class="imgBox">
            <img src="../img/명언8.png">
        </div>
        <div class="details">
            <div class="content">
            <h2>공자</h2>
            <p>남이 나를 알아 주지 않는다고 불평하지말아라
                내가 남을 알지 못함을 걱정하라
            </p>
         </div>
        </div>
    </div>
   </div>
</div>
		<!-- footter바 -->
		<div class="body3">
			<footer>
				<div class="waves">
					<div class="wave" id="wave1"></div>
					<div class="wave" id="wave2"></div>
					<div class="wave" id="wave3"></div>
					<div class="wave" id="wave4"></div>
				</div>
				<ul class="social_icon">
					<li><a href="#"><ion-icon name="logo-facebook"></ion-icon></a></li>
					<li><a href="#"><ion-icon name="logo-twitter"></ion-icon></a></li>
					<li><a href="#"><ion-icon name="logo-linkedin"></ion-icon></a></li>
					<li><a href="#"><ion-icon name="logo-instagram"></ion-icon></a></li>
				</ul>
				<ul class="menu">
					<li><a href="#">유주훈</a></li>
					<li><a href="#">이준호</a></li>
					<li><a href="#">위성은</a></li>
					<li><a href="#">지윤근</a></li>
					<li><a href="#">안성기</a></li>
				</ul>
				<p>ⓒ2022 일본4기IT연수 글로벌인 2021년10월~2022년05월</p>
			</footer>
			<script type="module"
				src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
			<script nomodule
				src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
		</div>
</body>
</html>