<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
  <div class="d-flex justify-content-center align-content-center">
  <main class="form-signin" style="width: 400px; padding-top: 150px;">
    <form action="" method="post">
     
      <h1 class="h3 mb-3 fw-normal">Please sign in</h1>
      <div class="form-floating">
        <input type="text" class="form-control" id="newid" placeholder="newid" name="newid">
        <label for="newid">Id</label>
      </div>
      <div class="form-floating">
        <input type="password" class="form-control" id="sign_passwd" placeholder="sign_passwd" name="sign_passwd">
        <label for="sign_passwd">Password</label>
      </div>
  
      <div class="checkbox mb-3">
      
      </div>
      <button class="w-100 btn btn-lg " style="background-color: rgb(255, 237, 246);" type="submit">Sign in</button>
    </form>
  </main>
  </div>
  <form action="login.do" method="post">
		<div class="d-flex justify-content-center align-content-center">
			<main class="form-signin" style="width: 400px; padding-top: 50px;">


				<h1 class="h3 mb-3 fw-normal">Please sign in</h1>
				<div class="form-floating">
					<input type="text" class="form-control" id="newid"
						placeholder="newid" name="newid" value="${signup.newid}">
					<label for="newid">Id</label>
				</div>
				<div class="form-floating">
					<input type="password" class="form-control" id="sign_passwd"
						placeholder="sign_passwd" name="sign_passwd"
						value="${signup.sign_passwd}"> <label for="sign_passwd">Password</label>
				</div>

				<div class="checkbox mb-3"></div>
				<input type="submit" value="Sign in" />

				<!-- class="w-100 btn btn-lg" style="background-color: rgb(255, 237, 246);" -->
			</main>
		</div>
	</form>
  
</body>
</html>