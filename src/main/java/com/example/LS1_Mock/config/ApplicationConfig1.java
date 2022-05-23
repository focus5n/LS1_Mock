package com.example.LS1_Mock.config;

import com.example.LS1_Mock.repository.BookRepository;
import com.example.LS1_Mock.service.BookService;
import org.springframework.context.annotation.Bean;

public class ApplicationConfig1 {
    @Bean
    public BookRepository bookRepository() {
        return new BookRepository();
    }

    @Bean
    public BookService bookService() {
        BookService bookService = new BookService();
        bookService.setBookRepository(bookRepository());
        return bookService;
    }
}
