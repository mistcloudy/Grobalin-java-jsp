<%@page import="Login.LoginVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="Login.*" %>
    <jsp:useBean id="dao" class="Login.LoginDAO"/>
    <%request.setCharacterEncoding("utf-8"); %>
    
    <%
	if(session.getAttribute("loginID")==null)
	{
		 %>
		<!DOCTYPE html>
		<html>
		<head>
		<meta charset="UTF-8" http-equiv="Refresh" content="1; url=../1.메인사이트/main.jsp">
		<title>Insert title here</title>
		</head>
		<body>
		<div align="center">
		<b>로그인을 하셔야합니다</b>
		</div>
		</body>
		</html>
		<%
		} else {
			String loginID=(String)session.getAttribute("loginID"); 
	    	LoginVO vo = dao.getMemebr(loginID);
    %>
    
    
<!DOCTYPE html>
<html lang="ko">
<head>
	
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="stylesheet" href="../css/회원가입.css">
       <link href="../css/main.css" rel="stylesheet"/>
        <link href="../css/사이드바.css" rel="stylesheet"/>
        <link href="../css/목록.css" rel="stylesheet">
</head>
<body>
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
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top" id="sideNav">
            <a class="navbar-brand js-scroll-trigger" href="/7.내스터디/개인정보.jsp">
                <span class="d-block d-lg-none">언어스터디</span>
                <span class="d-none d-lg-block"><img class="img-fluid img-profile rounded-circle mx-auto mb-2" src="/연습용/img/네즈코.png" alt="..." /></span>
            </a>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav">
                   <li class="nav-item"><a class="nav-link js-scroll-trigger" href="../7.내스터디/개인정보.jsp">개인정보</a></li>
                    <li class="nav-item"><a class="nav-link js-scroll-trigger" href="../스터디정보/정보메인.jsp">스터디정보</a></li>
                    <li class="nav-item"><a class="nav-link js-scroll-trigger" href="../스터디신청/신청메인.jsp">스터디신청</a></li>
                    <li class="nav-item"><a class="nav-link js-scroll-trigger" href="../스터디관리/관리메인.jsp">스터디관리</a></li>
                    <li class="nav-item"><a class="nav-link js-scroll-trigger" href="../스터디후기/후기메인.jsp">후기작성</a></li>
                </ul>
            </div>
        </nav>
  <form method="post" action="회원정보수정pro.jsp">
  <div class="container">
  <div class="insert">
  <table>
  <caption><h2>회원가입 양식</h2></caption>
  <tr>
      <td class="col1">이름</td>
      <td class="col2"><input type="text" name="name" maxlength="5" value="<%=vo.getName()%>"readonly ></td>
  </tr>
  <tr>
      <td class="col1">아이디</td>
      <td class="col2">
          <input type="text" name="id" maxlength="10" value="<%=vo.getId() %>" readonly>
      </td>
  </tr>
  <tr>
      <td class="col1">비밀번호</td>
      <td class="col2">
          <input type="password" name="pw" maxlength="16" value="<%=vo.getPw() %>">
          <p>※비밀번호는 <span class="num">문자, 숫자, 특수문자(~!@#$%^&*)의 조합
          10 ~ 16자리</span>로 입력이 가능합니다.</p>
      </td>
  </tr>
  <tr>
      <td class="col1">비밀번호 확인</td>
      <td class="col2"><input type="password" name="pwCheck" maxlength="16" value="<%=vo.getPw() %>"></td>
  </tr>
  <tr>
      <td class="col1">휴대폰 번호</td>
      <td class="col2">
      <input type="text" name="phone" maxlength="50" value="<%=vo.getPhone()%>"></td>
  </tr>
  <tr>
      <td class="col1">이메일</td>
      <td class="col2">
          <input type="text" name="email" maxlength="50" value="<%=vo.getEmail()%>">
  </tr>
  <tr>
    <tr>
      <td class="col1">언어명</td>
      <td class="col2">
                    <select id="row1" name="lanName" class="form-control">
                    <option value="">선택하세요</option>
                    <option value="영어">영어</option>
                    <option value="일본어">일본어</option>
                    <option value="중국어">중국어</option>
                    <option value="아랍어">아랍어</option>
                    <option value="스페인어">스페인어</option>
                    <option value="독일어">독일어</option>
                </select>
                
      </td>
  </tr>
    <tr>
      <td class="col1">언어레벨</td>
      <td class="col2">
      <select id="row1" name="level" class="form-control">
                      <option value="">선택하세요.</option>
                        <option value="초급">초급</option>
                        <option value="중급">중급</option>
                        <option value="고급">고급</option>
                    </select>          
      </td>
  </tr>
  <tr>
  <td>
        <input id="btn3" type="submit" value="회원정보수정"> 
  </td>
  </tr>
  </table>
  </div>
  </div>
</form>
</body>
<%
}
    %>
</html>