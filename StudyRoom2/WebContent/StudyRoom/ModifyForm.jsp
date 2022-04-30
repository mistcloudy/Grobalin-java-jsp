<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="StudyRoom.*" %>
    <%@ page import="java.util.*" %>
    
    <%
    String StudyCode = request.getParameter("StudyCode");   
    StudyRoomDAO Stdao = StudyRoomDAO.getInstance();
    StudyRoomVO Stvo = Stdao.getContent(StudyCode);
    %>
    <script src="https://kit.fontawesome.com/ea243819fd.js" crossorigin="anonymous"></script>
    <link type="text/css" rel="stylesheet" href="../StudyRoom/css/idex1.css">
    <link type="text/css" rel="stylesheet" href="../StudyRoom/css/main.css">
    <link type="text/css" rel="stylesheet" href="../StudyRoom/css/footer.css">
    <link type="text/css" rel="stylesheet" href="../StudyRoom/css/목록.css">
    
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>스터디 등록</title>
</head>
<body>
<form action="ModifyProc.jsp">
    <div class="container">
        <div class="title">스터디 상세내용</div>
            <div class="user-details">
                <div class="input-box">
                    <span class="details">스터디 제목</span>
                    <input type="text" name="Title" value="<%=Stvo.getTitle() %>"  required>
                </div>
                <div class="input-box">
                    <span class="details">언어명</span>
                    <select id="row1" name="LanName" class="form-control">
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
                    <select id="row1" name="Level" class="form-control">
                     	<option value="<%=Stvo.getLevel() %>"><%=Stvo.getLevel() %></option>
                        <option value="초급">초급</option>
                        <option value="중급">중급</option>
                        <option value="고급">고급</option>
                    </select>
                </div>
                <div class="input-box">
                    <span class="details">지역</span>
                    <select id="row1" name="Area" value=""class="form-control">
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
                    <select id="row1" name="Week" class="form-control">
                   	<option value="<%=Stvo.getWeek() %>"><%=Stvo.getWeek() %></option> 
                    <option value="평일">평일</option>
                    <option value="주말">주말</option>
                </select>
                </div>
                <div class="input-box">
                    <span class="details">스터디 시간</span>
                    <input type="text" name="PartTime" value="<%=Stvo.getPartTime() %>"required>
                </div>
                <div class="input-box">
                    <span class="details">연락 수단(오픈채팅방, 카카오톡ID)</span>
					<input type="text" name="ChatLink" value="<%=Stvo.getChatLink() %>">
                </div>
                <div class="input-box">
                    <span class="details">조회수</span>
                    <input type="text" name="Count" value="<%=Stvo.getCount() %>" readonly>
                </div>
                
            </div>
            <div class="gender-details">
            	<span class="details">스터디 내용</span>
                <textarea placeholder="<%=Stvo.getContent() %>" name="content"></textarea>
            </div>
            <div class="button">
                <input type="submit" value="수정">
                <input type="reset" value="취소">
                <input type="submit" value="목록" onclick="document.location.href='ListStudy.jsp'">
            </div>
        </form>
    </div>
            <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
            <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>      
             <input type="hidden" name="WriteDay" value="<%=Stvo.getWriteDay() %>">    
</body>
</html>