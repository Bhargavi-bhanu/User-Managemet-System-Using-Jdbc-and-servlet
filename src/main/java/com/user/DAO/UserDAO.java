package com.user.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.user.DTO.UserDetails;

public class UserDAO//Data Access Object
{
   
   private static final String url="jdbc:mysql://localhost:3306/user_management_system?user=root&password=root";
   private static final String insert_user_details="insert into user_details(Name,EmailID,MobileNumber,Address,Password,Gender) values(?,?,?,?,?,?)";
   private static final String display_user_details="select * from user_details";
   private static final String update_user_details="Update user_details set Name=?,EmailID=?,MobileNumber=?,Address=?,Password=?,Gender=? where id=?";
   private static final String delete_user_details="delete from user_details where id=?"; 
   private static final String get_user_details="select * from user_details where id=?";
   private static final String filter_user_details="select * from user_details where Name=? or EmailID=? or Gender=? or Address=?";
  public void insertUserDetails(UserDetails userDetails)
  {		
//    System.out.println("DAO Details:"+userDetails);
//    System.out.println("Data Inserted");
	  
	  try 
	  {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connect=DriverManager.getConnection(url);
	//String query="insert into user_details values(?,?,?,?,?,?,?); ";
		PreparedStatement ps=connect.prepareStatement(insert_user_details);
	//	ps.setInt(1, userDetails.getId());
		ps.setString(1, userDetails.getName());
		ps.setString(2, userDetails.getEmail());
		ps.setLong(3, userDetails.getMobile());
		ps.setString(4, userDetails.getAddress());
		ps.setString(5, userDetails.getPassword());
		ps.setString(6, userDetails.getGender());
		ps.executeUpdate();
		System.out.println("Data Inserted");
		connect.close();
		
	  } 
	  catch (Exception e) 
	  {
		e.printStackTrace();
	  }
  }
  public List<UserDetails> displayUserDetails()
  {
	  try 
	  {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connect=DriverManager.getConnection(url); 
		//String query="select * from user_details";
		Statement s=connect.createStatement();
		ResultSet rs=s.executeQuery(display_user_details);
		List<UserDetails> listOfUserDetails=new ArrayList<UserDetails>();
		while(rs.next())
		{
			//System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getLong(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7));
			UserDetails userDetails=new UserDetails();
			userDetails.setId(rs.getInt("ID"));
			userDetails.setName(rs.getString("Name"));
			userDetails.setEmail(rs.getString("EmailID"));
			userDetails.setMobile(rs.getLong("MobileNumber"));
			userDetails.setAddress(rs.
					getString("Address"));
			userDetails.setPassword(rs.getString("Password"));
			userDetails.setGender(rs.getString("Gender"));
			listOfUserDetails.add(userDetails);
			
		}
		connect.close();
		return listOfUserDetails;
	  } 
	  catch (Exception e) 
	  {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	 }
      
  }
  public void updateUserDetails(int id,UserDetails userDetails) 
  {
	  try 
	  {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connect=DriverManager.getConnection(url);
		PreparedStatement ps=connect.prepareStatement(update_user_details);
		ps.setString(1, userDetails.getName());
		ps.setString(2, userDetails.getEmail());
		ps.setLong(3, userDetails.getMobile());
		ps.setString(4, userDetails.getAddress());
		ps.setString(5, userDetails.getPassword());
		ps.setString(6, userDetails.getGender());
		ps.setInt(7, id);
		ps.executeUpdate();
		System.out.println("Data Updated");
		connect.close();
	  } 
	  catch (Exception e) 
	  {
		e.printStackTrace();
	  }	   
  }
  public void deleteUserDetails(int id)
  {
	  try 
	  {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connect=DriverManager.getConnection(url);
		PreparedStatement ps=connect.prepareStatement(delete_user_details);
		ps.setInt(1,id);
		ps.executeUpdate();
		System.out.println("Data Deleted");
		connect.close();
		
	  } 
	  catch (Exception e) 
	  {
		e.printStackTrace();
		
	  }
		    
  }
  public UserDetails getUserDetails(int id)
  {
	  UserDetails userDetails=new UserDetails();
	  try
	  {
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  Connection connect=DriverManager.getConnection(url);
		  PreparedStatement ps=connect.prepareStatement(get_user_details);
		  ps.setInt(1,id);
		  ResultSet rs=ps.executeQuery();
		  while(rs.next())
			{
				userDetails.setId(rs.getInt("ID"));
				userDetails.setName(rs.getString("Name"));
				userDetails.setEmail(rs.getString("EmailID"));
				userDetails.setMobile(rs.getLong("MobileNumber"));
				userDetails.setAddress(rs.getString("Address"));
				userDetails.setPassword(rs.getString("Password"));
				userDetails.setGender(rs.getString("Gender"));		
	        }
			connect.close();	  
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	  return userDetails;
  }
  public List<UserDetails> filterUserDetails(String filter)
  {
	   List<UserDetails> listofuserdetails=new ArrayList<UserDetails>();
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect=DriverManager.getConnection(url); 
			PreparedStatement ps=connect.prepareStatement(filter_user_details);
			ps.setString(1, filter);
			ps.setString(2, filter);
			ps.setString(3, filter);
			ps.setString(4, filter);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
		
				UserDetails userDetails=new UserDetails();
				userDetails.setId(rs.getInt("ID"));
				userDetails.setName(rs.getString("Name"));
				userDetails.setEmail(rs.getString("EmailID"));
				userDetails.setMobile(rs.getLong("MobileNumber"));
				userDetails.setAddress(rs.getString("Address"));
				userDetails.setPassword(rs.getString("Password"));
				userDetails.setGender(rs.getString("Gender"));
				listofuserdetails.add(userDetails);		
			}
			connect.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return listofuserdetails;	  
	 }
}