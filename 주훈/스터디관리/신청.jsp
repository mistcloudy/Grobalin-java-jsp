<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>신청양식</title>
    <link rel="stylesheet" href="/css/신청서.css">
</head>
<body>
    <div class="container">
        <div class="title">이미 수락 받은 신청서 입니다!</div>
        <div class="user-details">
            <div class="input-box">
                <span class="details">제목</span>
                <input type="text" name="title" value="" readonly>
            </div>
        <form action="#">
            <div class="user-details">
                <div class="input-box">
                    <span class="details">작성자</span>
                    <input type="text" name="name" value="" readonly>
                </div>
                <div class="input-box">
                    <span class="details">비밀번호</span>
                    <input type="password" name="password" value="" readonly>
                </div>
                <span>신청내용</span>
                <div class="gender-details">
                    <textarea placeholder="내용 입력" name="content" readonly></textarea>
                </div>
            </div>
            <div class="button">
                <input type="button" name="get" value="뒤로" onClick="location.href='/스터디관리/관리메인.jsp'">
                <input type="button" name="turn" value="삭제"  style="float: right;" onClick="location.href='/스터디관리/관리메인.jsp'">
            </div>
        </form>
    </div>
</body>
</html>