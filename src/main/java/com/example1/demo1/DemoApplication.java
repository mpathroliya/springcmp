package com.example1.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

// import net.bytebuddy.dynamic.loading.ClassLoadingStrategy.Configurable;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		// System.out.println("\n Dekho ye chal rha hai\nm.");

		//Alien a = context.getBean(Alien.class);	
		//a.show();
		// Alien a1 = context.getBean(Alien.class);	
		// a1.show();

		
	}

}
