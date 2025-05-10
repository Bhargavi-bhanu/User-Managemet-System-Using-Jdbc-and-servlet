<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="registration" method="post">
<div class="sub_1">
<label>Name</label>
<br>
<input type="text" name="name">
<br>
<label>EmailId</label>
<br>
<input type="email" name="email">
<br>
<label>Mobile</label>
<br>
<input type="number" name="mobile">
<br>
<label>Address</label>
<br>
<input type="text" name="address">
<br>
<label>password</label>
<br>
<input type="password" name="password">
<br>
<label>id</label>
<br>
<input type="number" name="id">
<br>
</div>
<div class="sub_2">
<label><input type="radio" name="gender" value="male" >Male</label>
<label><input type="radio" name="gender" value="female" >Female</label>
<label><input type="radio" name="gender" value="others" >Others</label>
</div>
<input type="submit" class="submit">
</form>
</body>
</html>