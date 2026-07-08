package com.ukr.Repository;

import com.ukr.Model.Book;

import java.util.List;


public interface BookRepository {
    void saveBook(Book book);
    Book findByBookId(String bookId);
    List<Book> findAllBooks();
}
