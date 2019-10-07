<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DUO</title>
</head>
<body>
<h1>데이트 해 DUO!</h1><hr />
<form action="${path}/login_success.do" name="loginForm" method="post">
	<p>${nick_name}(${id})님 환영합니다.</p><br/>
	<input type="button" id="btnUpdate" value="회원정보 수정"/>
	<input type="submit" id="btnLogout" value="로그아웃"/>
</form>
</body>
</html>