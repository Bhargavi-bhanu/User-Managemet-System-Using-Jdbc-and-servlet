package com.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.DTO.UserDetails;
import com.user.service.UserService;

@WebServlet("updateuserdetails")
public class UpdateUser extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		UserService userService=new UserService();
		
		HttpSession session=req.getSession();
		int id=(int)session.getAttribute("id");
		
		
		String username=req.getParameter("name");
		String email=req.getParameter("email");
		Long mobile=Long.parseLong(req.getParameter("mobile"));
		String address=req.getParameter("address");                               
		String password=req.getParameter("password");    
		String gender=req.getParameter("gender");
		
		
		UserDetails details=new UserDetails();
		details.setName(username);
		details.setEmail(email);
		details.setMobile(mobile);
		details.setAddress(address);
		details.setPassword(password);
		details.setGender(gender);
		details.setId(id);
		
	  userService.updateUserDetails(id,details);
	  List<UserDetails> userDetailsList=userService.getAllUserDetails();
	  
	  session.setAttribute("listofuserdetails", userDetailsList);
	  
	  RequestDispatcher dispatcher=req.getRequestDispatcher("AllUserDetails.jsp");
	  dispatcher.forward(req, resp);
		
	}
    
}














