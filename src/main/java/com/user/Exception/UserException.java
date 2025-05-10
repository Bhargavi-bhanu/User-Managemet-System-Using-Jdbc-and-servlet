package com.user.Exception;

public class UserException extends RuntimeException
{
	
	private String exceptionmsg;
	public UserException()
	{
		
	}
	public UserException(String exceptionmsg) 
	{
		
		this.exceptionmsg=exceptionmsg;
	}
	public String getExceptionmsg()
	{
		return exceptionmsg;
	}
	

}
