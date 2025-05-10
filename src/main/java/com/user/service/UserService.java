package com.user.service;

import java.util.List;

import com.user.DAO.UserDAO;
import com.user.DTO.UserDetails;
import com.user.Exception.UserException;

public class UserService
{
	UserDAO userDAO=new UserDAO();
	UserDetails details2=new UserDetails();
	public void userRegistrationDetails(UserDetails userDetails)
	{
		Long mobileNumber=details2.getMobile();
		 if(mobileNumber>=6000000000l && mobileNumber<=9999999999l)
		 {
			 details2.setMobile(mobileNumber);
		 }
		 else
		 {
			 throw new UserException("Invalid password");
		 }
		 String password=userDetails.getPassword();
		 if(password.length()==4)
		 {
			 details2.setPassword(password);
		 }
		 else
		 {
			 throw new UserException("Invalid password");
		 }
		 details2.setAddress(userDetails.getAddress());
		 details2.setName(userDetails.getName());
		 details2.setGender(userDetails.getGender());
		 details2.setEmail(userDetails.getEmail());
		 
		 System.out.println("Service layer");
		 UserDAO userdao=new UserDAO();
		 userDAO.insertUserDetails(details2);
		 
	}
	public List<UserDetails> getAllUserDetails()
    {
   	 return userDAO.displayUserDetails();
    }
    public void deleteUserDetails(int id)
    {
   	 userDAO.deleteUserDetails(id);
    }
    public void updateUserDetails(int id,UserDetails userDetails)
    {
   	 userDAO.updateUserDetails(id,userDetails);
    }
    public UserDetails getUserDetails(int id)
    {
   	  return userDAO.getUserDetails(id);
    }
  
	public List<UserDetails> filterUserDetails(String filter) {
		return userDAO.filterUserDetails(filter);
	}
		 
		 


	
	
}
