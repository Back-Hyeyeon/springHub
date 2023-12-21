<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/common/headerLogin.jsp" />
 <form action="login.do" method="post">
  <div class="d-flex justify-content-center align-content-center">
  <main class="form-signin" style="width: 400px; padding-top: 50px;">
  
   
      <h1 class="h3 mb-3 fw-normal">Please sign in</h1>
      <div class="form-floating">
        <input type="text" class="form-control" id="newid" placeholder="newid" name="newid" value="${signup.newid}">
        <label for="newid">Id</label>
      </div>
      <div class="form-floating">
        <input type="password" class="form-control" id="sign_passwd" placeholder="sign_passwd" name="sign_passwd" value="${signup.sign_passwd}">
        <label for="sign_passwd">Password</label>
      </div>
  
      <div class="checkbox mb-3">
      
      </div>
      <input class="w-100 btn btn-lg" style="background-color: rgb(255, 237, 246);" type="submit" value="Sign in"/>
      
   
  </main>
  </div>
   </form>
</body>
</html>