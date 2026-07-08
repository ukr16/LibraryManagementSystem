package com.ukr.Repository;

import com.ukr.Model.Book;

import java.util.ArrayList;
import java.util.List;

public class InMemoryBookRepository implements BookRepository{

    private final List<Book> books = new ArrayList<>();

    @Override
    public void saveBook(Book book) {
            books.add(book);
    }

    @Override
    public Book findByBookId(String bookId) {
        return books.stream().filter(book -> book.getBookId().equals(bookId)).findFirst().orElse(null);
    }

    @Override
    public List<Book> findAllBooks() {
        return books;
    }


}
