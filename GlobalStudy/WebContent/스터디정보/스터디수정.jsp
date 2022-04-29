<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="MyStudy.*" %>
    <%@ page import="StudyRoom.*" %>
    <%@ page import="java.util.*" %>
    
    <%
    
    int StudyCode = Integer.parseInt(request.getParameter("StudyCode"));
    StudyRoomDAO Stdao = StudyRoomDAO.getInstance();
    StudyRoomVO Stvo = Stdao.getContent(StudyCode);

    %>
    <script src="https://kit.fontawesome.com/ea243819fd.js" crossorigin="anonymous"></script>
    <link type="text/css" rel="stylesheet" href="../css/main.css">
    <link type="text/css" rel="stylesheet" href="../css/검색등록.css">
    
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>스터디 수정</title>
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
                <li><a href="#">레벨테스트</a></li>
                <li><a href="../7.내스터디/개인정보.jsp">내스터디</a></li>
                <li><a href="#">후기작성</a></li>
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
<form action="../스터디정보/스터디수정Proc.jsp" method="get">

        <div class="title">스터디 상세내용</div>
            <div class="user-details">
                <div class="input-box">
                    <span class="details">스터디 제목</span>
                    <input type="text" name="title" value="<%=Stvo.getTitle() %>" >
                </div>
                <div class="input-box">
                    <span class="details">언어명</span>
                    <select id="row1" name="lanName" class="form-control">
                    <option value="<%=Stvo.getLanName() %>"><%=Stvo.getLanName() %></option>
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
                     	<option value="<%=Stvo.getLevel() %>"><%=Stvo.getLevel() %></option>
                        <option value="초급">초급</option>
                        <option value="중급">중급</option>
                        <option value="고급">고급</option>
                    </select>
                </div>
                <div class="input-box">
                    <span class="details">지역</span>
                    <select id="row1" name="area" class="form-control">
                    <option value="<%=Stvo.getArea() %>"><%=Stvo.getArea() %></option>
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
                   	<option value="<%=Stvo.getWeek() %>"><%=Stvo.getWeek() %></option> 
                    <option value="평일">평일</option>
                    <option value="주말">주말</option>
                </select>
                </div>
                <div class="input-box">
                    <span class="details">스터디 시간</span>
                    <input type="text" name="partTime" value="<%=Stvo.getPartTime() %>"required>
                </div>
                <div class="input-box">
                    <span class="details">오픈 채팅 링크</span>
					<input type="text" name="chatLink" value="<%=Stvo.getChatLink() %>">
                </div>
                <div class="input-box">
                    <span class="details">조회수</span>
                    <input type="text" name="count" value="<%=Stvo.getCount() %>" readonly>
                </div>
                
            </div>
            <div class="gender-details">
            	<span class="details">스터디 내용</span>
                <textarea name="content"><%=Stvo.getContent() %></textarea>
            </div>
            <div class="button">
                <input type="submit" value="수정완료">
                <input type="reset" value="취소">
                <input type="submit" value="목록보기" onclick="document.location.href='../스터디정보/정보메인.jsp'">
               <%--  <input type="hidden" name="writeDay" value="<%=Stvo.getWriteDay() %>">  --%> 
                <input type="hidden" name="studyCode" value="<%= StudyCode%>">  
            </div>
        </form>
        </div>
      </div>    
             
</body>
</html>