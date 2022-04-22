<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="StudyRoom.*" %>
    <%@ page import="java.util.*" %>
    <script src="https://kit.fontawesome.com/ea243819fd.js" crossorigin="anonymous"></script>
    <link type="text/css" rel="stylesheet" href="../StudyRoom/css/idex1.css">
    <link type="text/css" rel="stylesheet" href="../StudyRoom/css/main.css">
    <link type="text/css" rel="stylesheet" href="../StudyRoom/css/footer.css">
    <link type="text/css" rel="stylesheet" href="../StudyRoom/css/목록.css">
    <%
    String StudyCode = request.getParameter("StudyCode");   
    StudyRoomDAO Stdao = StudyRoomDAO.getInstance();
    StudyRoomVO Stvo = Stdao.getContent(StudyCode);
    %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>스터디 상세내용 보기</title>
</head>
<body>
    <div class="container">
        <div class="title">스터디 상세내용 보기</div>
            <div class="user-details">
                <div class="input-box">
                    <span class="details">스터디 제목</span>
                    <input type="text" value="<%=Stvo.getTitle() %>" readonly>
                </div>
                <div class="input-box">
                    <span class="details">언어명</span>
                    <input type="text" value="<%=Stvo.getLanName() %>" readonly>
                </div>
                <div class="input-box">
                    <span class="details">모집 언어 레벨</span>
                    <input type="text" value="<%=Stvo.getLevel() %>" readonly>
                </div>
                <div class="input-box">
                    <span class="details">지역</span>
                    <input type="text" value="<%=Stvo.getArea() %>" readonly>
                </div>
                <div class="input-box">
                    <span class="details">스터디 요일</span>
                    <input type="text" value="<%=Stvo.getWeek() %>" readonly>                </div>
                <div class="input-box">
                    <span class="details">스터디 시간</span>
                    <input type="text" value="<%=Stvo.getPartTime() %>" readonly>                </div>
                <div class="input-box">
                    <span class="details">연락 수단</span>
                    <input type="text" value=" <%=Stvo.getChatLink() %>" readonly>
                </div>
                <div class="input-box">
                    <span class="details">최근 수정 일자</span>
                    <input type="text" value="<%=Stvo.getWriteDay() %>" readonly>
                </div>
                <div class="input-box">
                    <span class="details">조회수</span>
                    <input type="text" value="<%=Stvo.getCount() %>" readonly>
                </div>
                <span class="details">스터디 내용</span>
            </div>
            <div class="gender-details">
                <textarea rows="20" cols="260" placeholder="<%=Stvo.getContent() %>" name="content" readonly></textarea>
            </div>
            <div class="button">
			<form action="ModifyForm.jsp">
			<input type="submit" value="수정하기">
			<input type="button" value="목록보기" onclick="document.location.href='ListStudy.jsp'"> 

			<!-- 수정페이지 분리 시 지울것 -->	
			<input type="hidden" name="StudyCode" value="<%=StudyCode%>">
			</form>
            </div>
        </form>
    </div>
</div>
            <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
            <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>          
</body>
</html>