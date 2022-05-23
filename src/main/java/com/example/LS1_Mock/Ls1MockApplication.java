package com.example.LS1_Mock;

import com.example.LS1_Mock.config.ApplicationConfig1;
import com.example.LS1_Mock.config.ApplicationConfig2;
import com.example.LS1_Mock.config.ApplicationConfig3;
import com.example.LS1_Mock.service.BookService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class Ls1MockApplication {

	public static void main(String[] args) {
		ApplicationContext context0 = new ClassPathXmlApplicationContext("application.xml");
		String[] beanDefinitionNames0 = context0.getBeanDefinitionNames();
		System.out.println("===========bean names==========");
		System.out.println(Arrays.toString(beanDefinitionNames0));
		BookService bookService = context0.getBean("bookService", BookService.class);
		System.out.println(bookService.getClass());

		// Java Config
		ApplicationContext context1 = new AnnotationConfigApplicationContext(ApplicationConfig2.class);
		System.out.println("============bean names==========");
		String[] beanDefinitionNames1 = context1.getBeanDefinitionNames();
		System.out.println(Arrays.toString(beanDefinitionNames1));
		BookService bookService1 = (BookService) context1.getBean("bookService");

		// Java Config
		ApplicationContext context2 = new AnnotationConfigApplicationContext(ApplicationConfig3.class);
		System.out.println("============bean names==========");
		String[] beanDefinitionNames2 = context2.getBeanDefinitionNames();
		System.out.println(Arrays.toString(beanDefinitionNames2));
		BookService bookService2 = (BookService) context2.getBean("bookService");
	}

}
