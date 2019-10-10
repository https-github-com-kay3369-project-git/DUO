<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <c:set var="path" value="${pageContext.request.contextPath }"></c:set>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자  </title>
<script src="../script/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
function btnDel(num){
	if(confirm('삭제하시겠습니까')){
		location.href="${path}/board_servlet/delboard.do?num="+num;
	
	}
	
}
</script>
</head>
<body>
<%@include file="../include/header.jsp" %>
<%@include file="../include/menu.jsp" %>
<form action="" name="board" method="post">
	<h2>게시물 목록</h2>
	<table>
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>제목</td>
			<td>날짜</td>
			<td>조회수</td>
			<td>삭제</td>
		</tr>
		<c:forEach var="dto" items="${listAll}">
		<tr>
            <td>${dto.num}</td>
			<td>${dto.writer}</td>
			<!-- 나중에 페이징 번호 넣을 곳 -->
			<td>
				<a href="${path}/board_servlet/view.do?num=${dto.num}">${dto.subject}[${dto.comment_count}]</a>
			</td>
			<td>${dto.reg_date}</td>
			<td>${dto.readcount}</td>
			<td>
		
			<input type="button" onclick="btnDel('${dto.num}')"  value="삭제">
		</tr>
		</c:forEach>
			<tr>
				<td colspan="6" align="center">
				<c:if test="${curBlock > 1}">
						<a href="${path}/board_servlet/allList.do?curPage=${prev_page}">[<<]</a>
						<a href="${path}/board_servlet/allList.do?curPage=${prev_page}">[이전]</a>	
				</c:if>
				
				<c:forEach var="i" begin="${block_start}" end="${block_end}">
					<a href="${path}/board_servlet/allList.do?curPage=${i}">${i}</a>&nbsp;
				</c:forEach>
				
 		    	<c:if test="${curBlock < totBlock}">
					<a href="${path}/board_servlet/allList.do?curPage=${next_page}">[다음]</a>
				</c:if>
				<a href=" ${path}/board_servlet/allList.do?curPage=${totPage}">[>>]</a>
				</td>
			</tr>
		</table>
	</form>
	<%@include file="../include/footer.jsp" %>
</body>
</html>