<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="mainPage.do" method="post">
<jsp:include page="headerLogin.jsp"/>
<%-- <%@ include file="headerLogin.jsp" %> --%>
${userName}
</form>



</body>
</html>