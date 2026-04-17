package com.nt.sbeans;

import org.springframework.stereotype.Component;

@Component("dEngine")
public final class DesielEngine implements IEngine {
	
     @Override
	public void startEngine() 
	{
		System.out.println("DesielEngine:: Desiel Engine started");
	}
    @Override
    public void stopEngine() 
    {
    	System.out.println("DEsielEngine::Desiel Engine stopped");
    }
}
