package com.example.LS1_Mock.service;

import com.example.LS1_Mock.BookStatus;
import com.example.LS1_Mock.domain.Book;
import com.example.LS1_Mock.repository.BookRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
public class BookServiceTest {
    private BookRepository bookRepository;

    @Test
    @DisplayName("Service: 구현 안 된 Repository 사용")
    public void save() {
        Book book = new Book();
        BookService bookService = new BookService(bookRepository);

        Book result = bookService.save(book);
        assertThat(book.getCreated()).isNull();
        assertThat(book.getBookStatus()).isEqualTo(BookStatus.DRAFT);
        assertThat(result).isNotNull();
        assertThat(book).isEqualTo(result);
    }
}

