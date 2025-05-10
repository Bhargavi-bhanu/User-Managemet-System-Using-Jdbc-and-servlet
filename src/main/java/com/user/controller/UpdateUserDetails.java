package com.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.DTO.UserDetails;
import com.user.service.UserService;

@WebServlet("/updateUserDetails")
public class UpdateUserDetails extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		int id=Integer.parseInt(req.getParameter("id"));
		
		UserService service=new UserService();
		UserDetails userDetails=service.getUserDetails(id);
		
		HttpSession session=req.getSession();
		session.setAttribute("userDetails", userDetails);
		session.setAttribute("id", id);
		
		System.out.println(userDetails);
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("update.jsp");
		dispatcher.forward(req, resp);
		
	}

}




























