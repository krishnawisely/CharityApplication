package com.revature.charity.exception;

public class DBException extends Exception {
	public DBException(String exceptionMessage)
	{
		super(exceptionMessage);
	}
	public DBException(String exceptionMessage, Throwable t)
	{
		super(exceptionMessage,t);
	}
}
