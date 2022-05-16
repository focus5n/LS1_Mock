package com.example.LS1_Mock;

import com.example.LS1_Mock.service.BookService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class Ls1MockApplication {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
		String[] beanDefinitionNames = context.getBeanDefinitionNames();
		System.out.println(Arrays.toString(beanDefinitionNames));
		BookService bookService = context.getBean("bookService", BookService.class);
	}

}
