<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="Login.*" %>
    <jsp:useBean id="dao" class="Login.LoginDAO"/>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>login</title>
  <link rel="stylesheet" href="../css/회원가입.css">
</head>
<body>
  <form method="post" action="회원가입pro.jsp">
  <div class="container">
  <div class="insert">
  <table>
  <caption><h2>회원가입 양식</h2></caption>
  <tr>
      <td class="col1">이름</td>
      <td class="col2"><input type="text" name="name" maxlength="5"></td>
  </tr>
  <tr>
      <td class="col1">아이디</td>
      <td class="col2">
          <input type="text" name="id" maxlength="10">
      </td>
  </tr>
  <tr>
      <td class="col1">비밀번호</td>
      <td class="col2">
          <input type="password" name="pw" maxlength="16">
          <p>※비밀번호는 <span class="num">문자, 숫자, 특수문자(~!@#$%^&*)의 조합
          10 ~ 16자리</span>로 입력이 가능합니다.</p>
      </td>
  </tr>
  <tr>
      <td class="col1">비밀번호 확인</td>
      <td class="col2"><input type="password" name="pwCheck" maxlength="16"></td>
  </tr>
  <tr>
      <td class="col1">휴대폰 번호</td>
      <td class="col2">
      <input type="text" name="phone" maxlength="50"></td>
  </tr>
  <tr>
      <td class="col1">이메일</td>
      <td class="col2">
          <input type="text" name="email" maxlength="50">
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
        <input id="btn3" type="submit" value="회원가입">
  </td>
  </tr>
  </table>
  </div>
  </div>
</form>
</body>
</html>