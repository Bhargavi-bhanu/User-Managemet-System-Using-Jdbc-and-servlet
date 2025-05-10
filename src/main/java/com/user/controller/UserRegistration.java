package com.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.DTO.UserDetails;
import com.user.service.UserService;

@WebServlet("/registration")
public class UserRegistration extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String username=req.getParameter("name");
		String email=req.getParameter("email");
		Long mobile=Long.parseLong(req.getParameter("mobile"));
		String address=req.getParameter("address");
		String password=req.getParameter("password");
		String gender=req.getParameter("gender");
		int id=Integer.parseInt(req.getParameter("id"));
		
		
		
		UserDetails details=new UserDetails();
		details.setName(username);
		details.setEmail(email);
		details.setMobile(mobile);
		details.setAddress(address);
		details.setPassword(password);
		details.setGender(gender);
		details.setId(id);
		
		System.out.println("request is generated");
		System.out.println("Controller layer");
		UserService service=new UserService();
		service.userRegistrationDetails(details);
		
		
		
	}
	

}
