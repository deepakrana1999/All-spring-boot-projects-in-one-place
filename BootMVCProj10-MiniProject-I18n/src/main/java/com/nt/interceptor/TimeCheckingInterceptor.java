//Interceptor
package com.nt.interceptor;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class TimeCheckingInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
			throws Exception {
		
		if(!req.getServletPath().equalsIgnoreCase("/")) 
		{
			//get System date and time
			LocalDateTime idt=LocalDateTime.now();
			//get hour
			int hour=idt.getHour();
			if(hour<9||hour>23) 
			{
				RequestDispatcher rd=req.getRequestDispatcher("/timeout.jsp");
				rd.forward(req, res);
				return false;
			}
			
		}
		return true;
	}

}
