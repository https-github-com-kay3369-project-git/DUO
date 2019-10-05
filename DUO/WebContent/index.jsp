<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="path" value="${pageContext.request.contextPath }"/> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
</head>
<body>
	<h2>회원 전용 페이지</h2> <hr />
	<a href="${path }/notice_servlet/write.do">글쓰기</a>
	<input type="submit" value="로그인" onclick="location.href='${path}/login.do'"/>	

</body>
</html>