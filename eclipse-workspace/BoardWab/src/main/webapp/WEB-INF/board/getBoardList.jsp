<%@page import="java.util.List"%>
<%@page import="com.mire.biz.board.BoardVO"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
//BoardVO vo = new BoardVO();
//List<BoardVO> boardList = (List)session.getAttribute("boardList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글 목록</h1>
	<h3>${userName}	님 환영 .<a href="logout.do">Log-out</a>
	</h3>
	<!-- 검색 시작 -->
	<form action="getBoardList.do" method="post">
		<table border="1" cellpadding="0" cellspacing="0" width="700">
			<tr>
				<td align="right">
					<!-- <select name="searchCondition">
							<option value="TITLE">제목
							<option value="CONTENT">내용
					</select>  --> <select name="searchCondition">
						<c:forEach items="${conditionMap}" var="data">
							<option value="${data.value}">${data.key}</option>
						</c:forEach>
				</select> 
				<input name="searchKeyword" type="text" /> 
				<input type="submit" value="검색" />
				</td>
			</tr>
		</table>
	</form>

	<!-- 검색 종료  -->
	<table border="1" cellpadding="0" cellspacing="0" width="700">
		<tr>
			<th bgcolor="orange" width="100">번호</th>
			<th bgcolor="orange" width="200">제목</th>
			<th bgcolor="orange" width="150">작성</th>
			<th bgcolor="orange" width="150">등록일</th>
			<th bgcolor="orange" width="100">조회수</th>
		</tr>
		<c:forEach var="board" items="${boardList }">
			<%-- <% for(BoardVO board : boardList) { %>  --%>
			<tr>
				<td>${board.seq}</td>
				<td align="left">
				<a href="getBoard.do?seq=${board.seq}">	${board.title}</a>
				</td>
				<td>${board.writer}</td>
				<td>${board.regDate}</td>
				<td>${board.cnt}</td>
			</tr>
			<%-- <% } %> --%>
		</c:forEach>
	</table>

	<br>
	<a href="insertBoard.jsp">새글 등록</a>
</body>
</html>