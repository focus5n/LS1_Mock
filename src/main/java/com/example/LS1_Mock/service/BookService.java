package com.example.LS1_Mock.service;

import com.example.LS1_Mock.BookStatus;
import com.example.LS1_Mock.domain.Book;
import com.example.LS1_Mock.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) { this.bookRepository = bookRepository; }

    public BookService() {

    }

    public Book save(Book book) {
        book.setCreated(new Date());
        book.setBookStatus(BookStatus.DRAFT);
        return bookRepository.save(book);
    }
    public Book find(Book book) { return book; }
    public void setBookRepository(BookRepository bookRepository) { this.bookRepository = bookRepository; }

    // 객체 초기화 (autowired 이미 된 상태)
    @PostConstruct
    public void postConstructor() {
        System.out.println("+++++++++++");
        System.out.println("BookService 초기화");
        System.out.println(bookRepository.getClass());
        System.out.println("+++++++++++");
    }
}
