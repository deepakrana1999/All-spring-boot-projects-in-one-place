package com.nt.sbeans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("bDart")
@Lazy(true)
public final class BlueDart implements ICourier 
{
   public BlueDart() 
   {
	   System.out.println("BlueDart::0-param constructer");
   }
   @Override
   public String deliver(int oid) 
   {
	   return "BlueDart courier is ready to delever"+oid+"order number product";
   }
}

