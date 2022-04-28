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
<title>연습용메인</title>
<link rel="stylesheet" href="css/main.css">
<script src="https://kit.fontawesome.com/ea243819fd.js"
	crossorigin="anonymous"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="stylesheet" href="css/slide.css">
<link rel="stylesheet" href="css/container.css">
<link rel="stylesheet" href="css/container1.css">
<link rel="stylesheet" href="css/footer.css">
<%
request.setCharacterEncoding("utf-8");
String LanName = request.getParameter("LanName");
String Area = request.getParameter("Area");
String Level = request.getParameter("Level");
String Week = request.getParameter("Week");
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
                <a href="../1.메인사이트/main.jsp">LOGO</a>
            </div>
            <ul class="navbar_menu">
                <li><a href="../4.스터디찾기/스터디목록.jsp">스터디찾기</a></li>
                <li><a href="../5.스터디등록/스터디등록.jsp">스터디등록</a></li>
                <li><a href="#">레벨테스트</a></li>
                <li><a href="../7.내스터디/개인정보.jsp">내스터디</a></li>
                <li><a href="#">후기작성</a></li>
            </ul>
            <ul class="navbar_icons">
                <li><a href="/2.로그인/Login.jsp"><ion-icon name="log-in-outline"></ion-icon></a></li>
                <li><a href="/3.회원가입/회원가입.jsp"><i class="fa-solid fa-user"></i></a></li>
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
			<li></li>
			<li></li>
			<li></li>
			<li></li>
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
		<div class="img" style="background-image: url('/연습용/img/공명1.png');">
			현재 게시판이 비어있습니다.</div>
		<div class="img" style="background-image: url('/연습용/img/공명2.png');">
			현재 게시판이 비어있습니다.</div>
		<div class="img" style="background-image: url('/연습용/img/공명3.png');">
			현재 게시판이 비어있습니다.</div>
		<div class="img" style="background-image: url('/연습용/img/공명4.png');">
			현재 게시판이 비어있습니다.</div>
		<div class="img" style="background-image: url('/연습용/img/공명5.png');">
			현재 게시판이 비어있습니다.</div>
		<%
		} else {
		if (ArticleList.size() > 0) {
			for(int i=0; i<ArticleList.size(); i++){
				StudyRoomVO Article = (StudyRoomVO)ArticleList.get(i);
				
		%>
	
		<div class="img" style="background-image: url('img/다운로드.png');" onclick="location.href='../4.스터디찾기/스터디내용.jsp?studyCode=<%=Article.getStudyCode()%>';">
		<span><%=Article.getTitle()%>
				</span>
				
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
						<img src="img/공부명언1.png">
					</div>
					<div class="details">
						<div class="content">
							<h2>What is Lorem Ipsum?</h2>
							<p>Lorem Ipsum is simply dummy text of the printing and
								typesetting indusrty Lorem Ipsum has been the industry's
								standard dummt text ever since the 1500s</p>
						</div>
					</div>
				</div>
				<div class="box">
					<div class="imgBox">
						<img src="img/공부명언1.png">
					</div>
					<div class="details">
						<div class="content">
							<h2>What is Lorem Ipsum?</h2>
							<p>Lorem Ipsum is simply dummy text of the printing and
								typesetting indusrty Lorem Ipsum has been the industry's
								standard dummt text ever since the 1500s</p>
						</div>
					</div>
				</div>
				<div class="box">
					<div class="imgBox">
						<img src="img/소크라테스.png">
					</div>
					<div class="details">
						<div class="content">
							<h2>What is Lorem Ipsum?</h2>
							<p>Lorem Ipsum is simply dummy text of the printing and
								typesetting indusrty Lorem Ipsum has been the industry's
								standard dummt text ever since the 1500s</p>
						</div>
					</div>
				</div>
				<div class="box">
					<div class="imgBox">
						<img src="img/소크라테스.png">
					</div>
					<div class="details">
						<div class="content">
							<h2>What is Lorem Ipsum?</h2>
							<p>Lorem Ipsum is simply dummy text of the printing and
								typesetting indusrty Lorem Ipsum has been the industry's
								standard dummt text ever since the 1500s</p>
						</div>
					</div>
				</div>
				<div class="box">
					<div class="imgBox">
						<img src="img/소크라테스.png">
					</div>
					<div class="details">
						<div class="content">
							<h2>What is Lorem Ipsum?</h2>
							<p>Lorem Ipsum is simply dummy text of the printing and
								typesetting indusrty Lorem Ipsum has been the industry's
								standard dummt text ever since the 1500s</p>
						</div>
					</div>
				</div>
				<div class="box">
					<div class="imgBox">
						<img src="img/소크라테스.png">
					</div>
					<div class="details">
						<div class="content">
							<h2>What is Lorem Ipsum?</h2>
							<p>Lorem Ipsum is simply dummy text of the printing and
								typesetting indusrty Lorem Ipsum has been the industry's
								standard dummt text ever since the 1500s</p>
						</div>
					</div>
				</div>
				<div class="box">
					<div class="imgBox">
						<img src="img/소크라테스.png">
					</div>
					<div class="details">
						<div class="content">
							<h2>What is Lorem Ipsum?</h2>
							<p>Lorem Ipsum is simply dummy text of the printing and
								typesetting indusrty Lorem Ipsum has been the industry's
								standard dummt text ever since the 1500s</p>
						</div>
					</div>
				</div>
				<div class="box">
					<div class="imgBox">
						<img src="img/소크라테스.png">
					</div>
					<div class="details">
						<div class="content">
							<h2>What is Lorem Ipsum?</h2>
							<p>Lorem Ipsum is simply dummy text of the printing and
								typesetting indusrty Lorem Ipsum has been the industry's
								standard dummt text ever since the 1500s</p>
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
				<a href="../boardone/list.jsp">자유게시판</a>
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