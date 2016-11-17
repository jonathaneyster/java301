package org.elevenfifty.java301;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application
{
	public static void main(String[] args)
	{
		//SpringApplication.run(Application.class, args);
		ConfigurableApplicationContext context = new SpringApplicationBuilder()
				.sources(Application.class)
				.run(args);
		
	}
}	


