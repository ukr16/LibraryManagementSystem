package com.ukr.Service;

import com.ukr.Model.Book;

import java.util.List;

public interface LibraryService {

    void addBook(Book book);
    void registerMember(String memberId, String memberName);
    String issueBook(String bookId, String memberId);
    String returnBook(String bookId);
    List<Book> listAvailableBooks();
}
