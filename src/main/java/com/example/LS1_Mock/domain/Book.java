package com.example.LS1_Mock.domain;

import com.example.LS1_Mock.BookStatus;

import java.util.Date;

public class Book {
    private Date created;
    private BookStatus bookStatus;

    public Date getCreated() { return created; }
    public BookStatus getBookStatus() { return bookStatus; }

    public void setCreated(Date created) { this.created = created; }
    public void setBookStatus(BookStatus bookStatus) { this.bookStatus = bookStatus; }
}
