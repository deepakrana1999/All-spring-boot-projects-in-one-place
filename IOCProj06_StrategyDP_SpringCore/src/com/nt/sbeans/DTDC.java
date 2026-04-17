package com.nt.sbeans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("dtdc")
@Lazy(true)
public final class DTDC implements ICourier{
	
	public DTDC() 
	{
		System.out.println("DTDC::0-param Constructer");
	}
	@Override
	public String deliver(int oid) 
	{
		return "DTDC courier is ready to delever"+oid+"order number products";
	}

}
