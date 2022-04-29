<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>개인정보 수정</title>
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
        <link href="../css/검색등록.css" rel="stylesheet">
        <link href="../css/main.css" rel="stylesheet">
        <link href="../css/사이드바.css" rel="stylesheet">
    </head>
    <body id="page-top">
        <nav class="navbar">
            <div class="navbar_logo">
                <i class="fa-solid fa-award"></i>   
                <a href="/1.메인사이트/main.html">LOGO</a>
            </div>
            <ul class="navbar_menu">
                <li><a href="/4.스터디찾기/index.jsp">스터디찾기</a></li>
                <li><a href="/5.스터디등록/idex.jsp">스터디등록</a></li>
                <li><a href="#">레벨테스트</a></li>
                <li><a href="/7.내스터디/개인정보.jsp">내스터디</a></li>
                <li><a href="#">후기작성</a></li>
            </ul>
            <ul class="navbar_icons">
            <li><a href="../2.로그인/로그인.jsp"><i class="fa-solid fa-user"></i></a></li>
            </ul>
    
            <a href="#" class="navbar_toogleBtn">
                <i class="fa-solid fa-bars"></i>
            </a>
        </nav>
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top" id="sideNav">
            <a class="navbar-brand js-scroll-trigger" href="#page-top">
                <span class="d-block d-lg-none">언어스터디</span>
                <span class="d-none d-lg-block"><img class="img-fluid img-profile rounded-circle mx-auto mb-2" src="/연습용/img/네즈코.png" alt="..." /></span>
            </a>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav">
                    <li class="nav-item"><a class="nav-link js-scroll-trigger" href="/7.내스터디/개인정보.jsp">개인정보</a></li>
                    <li class="nav-item"><a class="nav-link js-scroll-trigger" href="/스터디정보/정보메인.jsp">스터디정보</a></li>
                    <li class="nav-item"><a class="nav-link js-scroll-trigger" href="/스터디신청/신청메인.jsp">스터디신청</a></li>
                    <li class="nav-item"><a class="nav-link js-scroll-trigger" href="/스터디관리/관리메인.jsp">스터디관리</a></li>
                    <li class="nav-item"><a class="nav-link js-scroll-trigger" href="/스터디후기/후기메인.jsp">후기작성</a></li>
                </ul>
            </div>
        </nav>
        <!-- Page Content-->
        <div class="container">
            <div class="title">회원정보수정</div>
            <form action="#">
                <div class="user-details">
                    <div class="input-box">
                        <span class="details">이름</span>
                        <input type="text" name="name" value="위성은">
                    </div>
                    <div class="input-box">
                        <span class="details">성별</span>
                        <select id="row1" name="sex" class="form-control">
                        <option value="">선택하세요.</option>
                        <option value="1">남</option>
                        <option value="2">여</option>
                    </select>
                    </div>
                    <div class="input-box">
                        <span class="details">레벨</span>
                        <select id="row1" name="level" class="form-control">
                        <option value="">선택하세요.</option>
                        <option value="1">고급</option>
                        <option value="2">중급</option>
                        <option value="3">하급</option>
                    </select>
                    </div>
                    <div class="input-box">
                        <span class="details">생년월일</span>
                        <input type="date" name="birth" value="1996-02-29">
                    </div>
                    <div class="input-box">
                        <span class="details">지역</span>
                        <select id="row1" name="area" class="form-control">
                            <option value="">선택하세요.</option>
                            <option value="1">울릉도</option>
                            <option value="2">동남쪽</option>
                            <option value="3">뱃길따라</option>
                            <option value="4">이백리</option>
                            <option value="5">외로운</option>
                            <option value="6">섬하나</option>
                        </select>
                    </div>
                    <div class="input-box">
                        <span class="details">가입일자</span>
                        <input type="date" name="joinday" value="2022-04-05">
                    </div>
                </div>
                <span>소개 글 변경</span>
                <div class="gender-details">
                    <textarea placeholder="얼마...안남았다...빨리 레이아웃짜자" name="content"></textarea>
                </div>
                <div class="button">
                    <input type="button" value="수정완료" onClick="location.href='/7.내스터디/개인정보.jsp'">
                </div>
            </form>
            <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
        </div>
    </body>
</html>
