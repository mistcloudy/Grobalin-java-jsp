<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="StudyRoom.*" %>
    <%@ page import="java.util.*" %>
       <script src="https://kit.fontawesome.com/ea243819fd.js" crossorigin="anonymous"></script>
    <link type="text/css" rel="stylesheet" href="../StudyRoom/css/main.css">
    <link type="text/css" rel="stylesheet" href="../StudyRoom/css/검색등록.css">
   
  
    <%
    String M_MemCode=(String)session.getAttribute("M_MemCode");
    String M_Name=(String)session.getAttribute("M_Name"); 
    %>
 	
<!DOCTYPE html>
<html>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>검색창</title>
    <script src="https://kit.fontawesome.com/ea243819fd.js" crossorigin="anonymous"></script>
    <link type="text/css" rel="preconnect" href="https://fonts.googleapis.com">
	<link type="text/css" rel="stylesheet" href="/StudyRoom/css/idex1.css">
    <link type="text/css" rel="stylesheet" href="/StudyRoom/css/main.css">
    <link type="text/css" rel="stylesheet" href="/StudyRoom/css/footer.css">
    <link type="text/css" rel="stylesheet" href="/StudyRoom/css/목록.css">
</head>
<body>
    <nav class="navbar">
        <div class="navbar_logo">
            <i class="fa-solid fa-award"></i>   
            <a href="">LOGO</a>
        </div>
        <ul class="navbar_menu">
            <li><a href="ListStudy.jsp">스터디찾기</a></li>
            <li><a href="InsertStudy.jsp">스터디등록</a></li>
            <li><a href="#">레벨테스트</a></li>
            <li><a href="#">내스터디</a></li>
            <li><a href="#">후기작성</a></li>
        </ul>
        <ul class="navbar_icons">
            <li><a href="#"><ion-icon name="log-in-outline"></ion-icon></a></li>
            <li><a href="#"><i class="fa-solid fa-user"></i></a></li>
        </ul>

        <a href="ListStudy.jsp" class="navbar_toogleBtn">
            <i class="fa-solid fa-bars"></i>
        </a>
    </nav>
    <div class="soun">
    <div class="container">
        <div class="title">스터디 등록</div>
        <form action="InsertStudyProc.jsp" method="get">
            <div class="user-details">
                <div class="input-box">
                    <span class="details">스터디 제목</span>
                    <input type="text" name="Title">
                    <input type="hidden" name="M_Name" value="<%=M_Name %>">
                    <input type="hidden" name="M_MemCode" value="<%=M_MemCode %>">
                </div>
                 <div class="input-box">
                    <span class="details">언어명</span>
                    <select id="row1" name="LanName" class="form-control">
                    <option value="">선택하세요.</option>
                    <option value="영어">영어</option>
                    <option value="일본어">일본어</option>
                    <option value="중국어">중국어</option>
                    <option value="아랍어">아랍어</option>
                    <option value="스페인어">스페인어</option>
                    <option value="독일어">독일어</option>
                    </select>
                </div>
 				<div class="input-box">
                    <span class="details">레벨</span>
                    <select id="row1" name="Level" class="form-control">
                        <option value="">선택하세요.</option>
                        <option value="초급">초급</option>
                        <option value="중급">중급</option>
                        <option value="고급">고급</option>
                    </select>
                </div>
             <div class="input-box">
                    <span class="details">지역</span>
                    <select id="row1" name="Area" class="form-control">
                    <option value="">선택하세요.</option>
                    <option value="강남">강남</option>
                    <option value="신촌">신촌</option>
                    <option value="홍대">홍대</option>
                    <option value="인천">인천-부평</option>
                    <option value="건대">건대</option>
                    <option value="판교">판교/분당</option>
                    <option value="수원">수원</option>
                    </select>
            </div>
            <div class="input-box">
                    <span class="details">요일</span>
                <select id="row1" name="Week" class="form-control">
                    <option value="">선택하세요.</option>
                    <option value="평일">평일</option>
                    <option value="주말">주말</option>
                </select>
            </div>
            <div class="input-box">
                    <span class="details">모임시간</span>
                    <input type="text" name="PartTime">
            </div>
            <div class="input-box">
                <span class="details">오픈 채팅 링크</span>
                <input type="text" name ="ChatLink" >
            </div>             
        </div>
        <span class="details">스터디 내용</span>
            <div class="gender-details">
                <textarea placeholder="스터디 내용 입력" name="Content" class="enu" ></textarea>
            </div>
            <div class="button">
                <input type="submit" value="등록">
                <input type="reset" value="다시 작성">
                <input type="button" value="목록보기" onclick="window.location='ListStudy.jsp'">
            </div>
        </form>
    </div>
</div>      
</body>
</html>