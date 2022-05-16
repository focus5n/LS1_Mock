package com.example.LS1_Mock.service;

import com.example.LS1_Mock.BookStatus;
import com.example.LS1_Mock.domain.Book;
import com.example.LS1_Mock.repository.BookRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class BookServiceMockTest {
    @Mock
    private BookRepository bookRepository;

    @Test
    @DisplayName("With Mock")
    public void mockSave() {

        // given, 준비
        Book book = new Book();
        System.out.println(bookRepository.getClass());
        // 테스트할 기능을 추가할 땐 이곳에 when 추가하기
        when(bookRepository.save(book)).thenReturn(book);

        // when, 실행
        BookService bookService = new BookService(bookRepository);
        Book result = bookService.save(book);

        // then, 검증
        assertThat(book.getCreated()).isNotNull();
        assertThat(book.getBookStatus()).isEqualTo(BookStatus.DRAFT);
        assertThat(result).isNotNull();
        assertThat(book).isEqualTo(result);
    }
}
