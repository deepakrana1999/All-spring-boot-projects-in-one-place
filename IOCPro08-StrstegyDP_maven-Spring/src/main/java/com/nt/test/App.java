package com.nt.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.AppConfig;
import com.nt.sbeans.Vehicle;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
         
        Vehicle vehicle=ctx.getBean("vehicle",Vehicle.class);
      
         vehicle.jounery("hyd","goa");
        ctx.close();
    }
}
