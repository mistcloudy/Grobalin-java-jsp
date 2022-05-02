<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="StudyRoom.*" %>
    <%@ page import="java.util.*" %>
       <script src="https://kit.fontawesome.com/ea243819fd.js" crossorigin="anonymous"></script>
    <link type="text/css" rel="stylesheet" href="../css/main.css">
    <link type="text/css" rel="stylesheet" href="../css/검색등록.css">
    
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
</head>
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
            </ul>
            <ul class="navbar_icons">
            <li><a href="../2.로그인/로그인.jsp"><i class="fa-solid fa-user"></i></a></li>
            </ul>
    
            <a href="../4.스터디찾기/스터디목록.jsp" class="navbar_toogleBtn">
                <i class="fa-solid fa-bars"></i>
            </a>
        </nav>
    <div class="soun">
    <div class="container">
    <form action="스터디등록Proc.jsp" method="get">
        <div class="title">스터디 등록</div>
        
        
            <div class="user-details">
                <div class="input-box">
                    <span class="details">스터디 제목</span>
                    <input type="text" name="title">
                </div>
                 <div class="input-box">
                    <span class="details">언어명</span>
                    <select id="row1" name="lanName" class="form-control">
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
                    <span class="details">언어 레벨</span>
                    <select id="row1" name="level" class="form-control">
                        <option value="">선택하세요.</option>
                        <option value="초급">초급</option>
                        <option value="중급">중급</option>
                        <option value="고급">고급</option>
                    </select>
                </div>
                <div class="input-box">
                    <span class="details">지역</span>
                    <select id="row1" name="area" class="form-control">
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
                    <span class="details">스터디 요일</span>
                <select id="row1" name="week" class="form-control">
                    <option value="">선택하세요.</option>
                    <option value="평일">평일</option>
                    <option value="주말">주말</option>
                </select>
                </div>
                <div class="input-box">
                    <span class="details">스터디 시간</span>
                    <input type="text" name="partTime">
                </div>
                <div class="input-box">
                <span class="details">오픈 채팅 링크</span>
                <input type="text" name ="chatLink" >
                </div>
                
            	</div>
            	<span class="details">스터디 내용</span>
            	<div class="gender-details" style="margin-top : 10px">
                <textarea placeholder="스터디 내용 입력" name="content"></textarea>
            	</div>

            <div class="button">
                <input type="submit" value="등록">
                <input type="reset" value="다시 작성">
                <input type="button" value="목록보기" onclick="window.location='../4.스터디찾기/스터디목록.jsp'">
                <input type="hidden" name="name" value="<%=M_Name %>">
                <input type="hidden" name="memCode" value="<%= M_MemCode%>">
            </div>
        </form>
    </div>
</div>      
</body>
</html>