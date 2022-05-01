<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>스터디 수정</title>
    <script src="https://kit.fontawesome.com/ea243819fd.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="stylesheet" href="/css/검색등록.css">
</head>
<body>
    <div class="container">
        <div class="title">스터디등록된거</div>
        <form action="#">
            <div class="user-details">
                <div class="input-box">
                    <span class="details">작성자 이름</span>
                    <input type="text" name="name" readonly>
                </div>
                <div class="input-box">
                    <span class="details">스터디 제목</span>
                    <input type="text" name="title" readonly>
                </div>
                <div class="input-box">
                    <span class="details">지역</span>
                    <select id="row1" name="area" class="form-control">
                        <option value="">선택하세요.</option>
                        <option value="1">강남</option>
                        <option value="2">영등포</option>
                        <option value="3">서초구</option>
                        <option value="4">부평</option>
                        <option value="5">송도</option>
                        <option value="6">무인도</option>
                    </select>
                </div>
                <div class="input-box">
                    <span class="details">언어명</span>
                    <select id="row1" name="lanname" class="form-control">
                        <option value="">선택하세요.</option>
                        <option value="1">일본어</option>
                        <option value="2">중국어</option>
                        <option value="3">스페인어</option>
                        <option value="4">아랍어</option>
                        <option value="5">프랑스어</option>
                        <option value="6">영어</option>
                    </select>
                </div>
                <div class="input-box">
                    <span class="details">모임날짜</span>
                    <input type="date" name="parttime" readonly>
                </div>
                <div class="input-box">
                    <span class="details">모임시간</span>
                    <input type="time" name="parttime" readonly>
                </div>
                <div class="input-box">
                    <span class="details">모집 시간</span>
                    <input type="time" name="startday" readonly>
                    <spna></spna>
                    <input type="time" name="endday" readonly>
                </div>
                <div class="input-box">
                    <span class="details">최대 인원</span>
                    <select id="row1" name="Personnel" class="form-control">
                        <option value="">선택하세요.</option>
                        <option value="1">1명</option>
                        <option value="2">2명</option>
                        <option value="3">3명</option>
                        <option value="4">4명</option>
                        <option value="5">5명</option>
                        <option value="6">6명</option>
                    </select>
                </div>
                <span class="details">스터디 내용</span>
            </div>
            <div class="gender-details">
                <textarea placeholder="내용 입력" name="content" readonly></textarea>
            </div>
            <div class="button">
                <input type="button" value="수정완료" onClick="location.href='/스터디정보/정보메인.jsp'">
                <input type="button" value="뒤로" onClick="location.href='/스터디정보/등록스터디.jsp'">
            </div>
        </form>
    </div>
</div>
            <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
            <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>          
</body>
</html>