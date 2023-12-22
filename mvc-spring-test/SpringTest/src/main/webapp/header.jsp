<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${path}/resources/css/hom.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>


	<div class="d-flex justify-content-center mt-4 " >
      <div>
			<h2 style="color: rgb(243, 132, 255);">The NULL</h2>
		</div>
		<div class="content-fixed top" style="margin-bottom: 0px;">
			<ul class="Menu1" style="margin-bottom: 0px;">
				<li class="dropbox"><a href="getCommodityList.do">전시문화</a> <span
					class="dropmenu"> <a href="#">특별전</a> <a href="#">전문전</a> <a
						href="#">역사전</a> <a href="#">아트페어</a>
				</span></li>
				<li class="dropbox"><a href="#">도서</a> <span class="dropmenu">
						<a href="#">서양미술</a> <a href="#">동양미술</a> <a href="#">현대미술</a> <a
						href="#">설치미술</a> <a href="#">사진전</a> <a href="#">에디션</a>
				</span></li>
				<li class="dropbox"><a href="#">컬렉션</a> <span class="dropmenu">
						<a href="#">디지털</a> <a href="#">데스크</a> <a href="#">패션</a> <a
						href="#">인형</a> <a href="#">컵</a>
				</span></li>
				<li class="dropbox"><a href="#">활동</a> <span class="dropmenu">
						<a href="http://wwww.naver.com">예술</a> <a href="#">도구정보</a>
				</span></li>
				<li class="dropbox"><a href="#">커뮤니티</a></li>
				<li class="dropbox"><a href="#">전시대관</a> <span class="dropmenu">
						<a href="#">서울</a> <a href="#">경기</a> <a href="#">인천</a> <a
						href="#">부산</a>
				</span></li>
			</ul>
			<ul class="Menu1" style="margin-bottom: 0px;">
				<li class="dropbox2 "><a href="loginPage.do"> 로그인 </a></li>
				<li class="dropbox2 "><a href="#">회원가입</a></li>
			</ul>
		</div>
	</div>
	<hr class="m-0">