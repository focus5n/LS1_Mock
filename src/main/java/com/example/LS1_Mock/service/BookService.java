package com.example.LS1_Mock.service;

import com.example.LS1_Mock.BookStatus;
import com.example.LS1_Mock.domain.Book;
import com.example.LS1_Mock.repository.BookRepository;

import java.util.Date;

public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) { this.bookRepository = bookRepository; }

    public Book save(Book book) {
        book.setCreated(new Date());
        book.setBookStatus(BookStatus.DRAFT);
        return bookRepository.save(book);
    }
    public Book find(Book book) { return book; }
    public void setBookRepository(BookRepository bookRepository) { this.bookRepository = bookRepository; }
}
