package com.nt.exception;

public class DoctorNotFountException extends RuntimeException{
      public DoctorNotFountException() 
      {
    	  
      }
      public DoctorNotFountException(String msg) 
      {
    	  super(msg);
      }
}
