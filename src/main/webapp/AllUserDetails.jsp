<%@page import="java.util.Iterator"%>
<%@page import="com.user.DTO.UserDetails"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="UserDetails.css">
</head>
<body background-color="grey">
  <form action="alluserdetails" method="get">
  <center><h1>All User Details</h1>
  <%
  List<UserDetails> list=(List<UserDetails>)session.getAttribute("listofuserdetails");
  %>
  <center>
  <form action="filterdata">
  <input placeholder="Enter Name Or EmailId Or Gender" name="filter">
  <input type="submit" value="Submit">
  </form>
  </center>
  <table border=1px>
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>EmailID</th>
    <th>MobileNumber</th>
    <th>Address</th>-
    <th>Password</th>
    <th>Gender</th>
    <th>Activation</th>
  </tr>
 <%
 
 Iterator<UserDetails> itr=list.iterator();
 while(itr.hasNext())
 {
	 UserDetails user=itr.next();
	 out.print("<tr>");
	 out.print("<td>"+user.getId() +"</td>");
	 out.print("<td>"+user.getName() +"</td>");
	 out.print("<td>"+user.getEmail() +"</td>");
	 out.print("<td>"+user.getMobile() +"</td>");
	 out.print("<td>"+user.getAddress() +"</td>");
	 out.print("<td>"+user.getPassword() +"</td>");
	 out.print("<td>"+user.getGender() +"</td>");
	 out.print("<td><button><a href='./updateUserDetails?id="+user.getId()+"'>Update</a></button><button><a href='./deleteUserDetails?id="+user.getId()+"'>Delete</a></button>"+"</td>");
	 out.print("</tr>");
 }
	
 out.print("</table>");
 %>
 </center>
  </form>
</body>
</html>