package com.nt.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;

@Configurable
@ComponentScan(basePackages="com.nt.sbeans")
public class AppConfig {

}
