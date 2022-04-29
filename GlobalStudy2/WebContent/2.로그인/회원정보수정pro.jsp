<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("utf-8");%>
    <jsp:useBean id="dao" class="Login.LoginDAO" />
    <jsp:useBean id="vo" class="Login.LoginVO">
    <jsp:setProperty name="vo" property="*"/>
    </jsp:useBean>
    <% String loginID = (String)session.getAttribute("loginID");
    vo.setId(loginID);
    dao.updateMember(vo);
    /* System.out.println(vo.getPw()); */
    %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" http-equiv="Refresh" content="0;url=../1.메인사이트/main.jsp">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
alert("회원정보가 수정 되었습니다.");
</script>
</body>
</html>