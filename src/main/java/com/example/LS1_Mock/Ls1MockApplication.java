package com.example.LS1_Mock;

import com.example.LS1_Mock.config.ApplicationConfig1;
import com.example.LS1_Mock.config.ApplicationConfig2;
import com.example.LS1_Mock.config.ApplicationConfig3;
import com.example.LS1_Mock.service.BookService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class Ls1MockApplication {

	/**
	 *
	 */
	private static final String BEAN_NAMES = "============bean names==========";

	public static void main(String[] args) {

		// Case1: XML Config. ComponentScan
		ApplicationContext context0 = new ClassPathXmlApplicationContext("application.xml");
		String[] beanDefinitionNames0 = context0.getBeanDefinitionNames();
		System.out.println("===========bean names==========");
		System.out.println(Arrays.toString(beanDefinitionNames0));
		BookService bookService = context0.getBean("bookService", BookService.class);
		System.out.println(bookService.getClass());
		((ConfigurableApplicationContext) context0).close();

		// Case2: Java Config1. Java Class + Bean Method
		ApplicationContext context1 = new AnnotationConfigApplicationContext(ApplicationConfig1.class);
		System.out.println(BEAN_NAMES);
		String[] beanDefinitionNames1 = context1.getBeanDefinitionNames();
		System.out.println(Arrays.toString(beanDefinitionNames1));
		BookService bookService1 = (BookService) context1.getBean("bookService");
		((ConfigurableApplicationContext) context1).close();

		// Case3. Java Config2. Java Class
		ApplicationContext context2 = new AnnotationConfigApplicationContext(ApplicationConfig2.class);
		System.out.println(BEAN_NAMES);
		String[] beanDefinitionNames2 = context2.getBeanDefinitionNames();
		System.out.println(Arrays.toString(beanDefinitionNames2));
		BookService bookService2 = (BookService) context2.getBean("bookService");
		((ConfigurableApplicationContext) context2).close();

		// Case4. Java Config3. Java Class
		ApplicationContext context3 = new AnnotationConfigApplicationContext(ApplicationConfig3.class);
		System.out.println(BEAN_NAMES);
		String[] beanDefinitionNames3 = context3.getBeanDefinitionNames();
		System.out.println(Arrays.toString(beanDefinitionNames3));
		BookService bookService3 = (BookService) context3.getBean("bookService");
		((ConfigurableApplicationContext) context3).close();

		// Case5. SpringBoot ComponentScan
		ApplicationContext context4 = new AnnotationConfigApplicationContext(Ls1MockApplication.class);
		System.out.println(BEAN_NAMES);
		String[] beanDefinitionNames4 = context4.getBeanDefinitionNames();
		System.out.println(Arrays.toString(beanDefinitionNames4));
		BookService bookService4 = (BookService) context4.getBean("bookService");
		((ConfigurableApplicationContext) context4).close();
	}
}
