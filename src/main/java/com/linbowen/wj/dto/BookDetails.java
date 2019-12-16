package com.linbowen.wj.dto;

import com.linbowen.wj.pojo.Author;
import com.linbowen.wj.pojo.Book;

public class BookDetails {

    private Book book;

    private Author author;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

}
