<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/WEB-INF/common/headerLogin.jsp" />> 

 <form action="" method="get">
  <div class="d-flex justify-content-center">
  
  <div class="row pt-3 border border-5 " style="width: 1200px; margin-top: 50px;">
    <div class="col-sm-6 border border-2">
      <div class="d-flex justify-content-center align-content-center">
        <table class="text-center">
          <tr>
          <th>
            <div style="width: 650px; height: 450px; overflow: hidden;" class="border border-2">
            <img src="./08.image/paris.jpg" alt="전시이름" style="height: 100%; object-fit: cover;" class="border border-2" >
          </div>
          </th>
        </tr>
        <tr>
          <th style="font-size: 22px;">
            ITEM
          </th>
        </tr>
        </table>
    </div>
    </div>
    <div class="col-sm-6 border border-2">
      <div class="border border-2" style="margin: 50px 0px 0px 30px;" >
        <table class=" border border-2" style="width: 500px; height: 100%;">
          <tr>
            <th class="border border-2" style="height: 70px;">
              topics
            </th>
          </tr>
        <tr >
          <th class="border border-2"  style="height: 70px;">
            ITEM
          </th>
        </tr>
        <tr >
          <th class="border border-2 "  style="height: 70px;">
            quantity
          </th>
        </tr>
        <tr >
          <th class="border border-2 "  style="height: 70px;">
            <input type="button" class=" btn btn-lg " value="cart">
            <input type="button" class=" btn btn-lg " value="Purchase">
          </th>
        </tr>
        <tr >
          <th class="border border-2 "  style="height: 70px;">
            <hr>
            주의사항
            <ul style="font-size: 10px;">
              <li>sadasdsadsa <br> fsdfsdfsdzczdczcsdf</li>
              <li>asdasdasd</li>
              <li>asdsadasdasdasdas</li>
            </ul>
          </th>
        </tr>
        </table>
    </div>
    </div>
  </div>
</div>
<hr>


</form>



</body>
</html>