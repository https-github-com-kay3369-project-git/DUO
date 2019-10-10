<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="path" value="${pageContext.request.contextPath }"/> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../script/jquery-3.4.1.min.js"></script>
<script type="text/javascript">

function del(num){
	
	if(confirm('삭제하시겠습니까')){
		location.href="${path}/aticle_servlet/delnotice.do?num="+num;
	
	}
}
	
</script>
</head>
<body>
<%@include file="../include/header.jsp" %>
<form action="${path}/aticle_servlet/search.do" name="frm" id="frm" method="post">
	<select name="option" id="option">
		<option value="writer">이름</option>
		<option value="subject">제목</option>
		<option value="content">본문</option>
		<option value="all">이름+제목+본문</option>
	</select>
	<input type="text" name="keyword" />
	<input type="submit" value="검색" >
</form>
<hr />
<form action="" name="form1" method="post" >
	<table>
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>이름</td>
			<td>날짜</td>
			<td>조회수</td>
			<td>삭제</td>
		</tr>
	<c:forEach var="dto" items="${listAll}">
		<tr>
			<td>${dto.num}</td>
			<td>
				<c:forEach var="i" begin="1" end="${dto.re_level}">&nbsp;&nbsp;</c:forEach>
				<a href="${path}/aticle_servlet/view.do?num=${dto.num}">${dto.subject} [${dto.comment_count}]</a>
			</td>
			<td>${dto.writer}</td>
			<td>${dto.reg_date}</td>
			<td>${dto.readcount}</td>
			<td>
		<input type="button" onclick="del('${dto.num}')"  value="삭제">
			</td>	
		</tr>
		</c:forEach>
	<tr>
			<td colspan="7">
				<c:if test="${curBlock>1}">
					<a href="${path}/aticle_servlet/list.do?curPage=${prev}">[이전]</a>
				</c:if>
				<c:forEach var="i" begin="${startBlock}" end="${endBlock}">
					&nbsp;<a href="${path}/aticle_servlet/list.do?curPage=${i}">${i}</a>&nbsp;
				</c:forEach>
				<c:if test="${curBlock<totBlock}">
					<a href="${path}/aticle_servlet/list.do?curPage=${next}">[다음]</a>
				</c:if>
			</td>
		</tr> 
	</table>
	</form>
		<%@include file="../include/footer.jsp" %>
</body>
</html>