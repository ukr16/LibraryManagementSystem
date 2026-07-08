package com.ukr.Service;


import com.ukr.Model.Book;
import com.ukr.Model.Member;
import com.ukr.Repository.BookRepository;
import com.ukr.Repository.MemberRepository;

import java.util.List;
import java.util.stream.Collectors;

public class LibraryServiceImpl implements LibraryService {

    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;

    public LibraryServiceImpl(BookRepository bookRepository, MemberRepository memberRepository) {
        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
    }


    @Override
    public void addBook(Book book) {
        bookRepository.saveBook(book);
    }

    @Override
    public void registerMember(String memberId, String memberName) {
        memberRepository.save(new Member(memberId, memberName));
    }

    @Override
    public String issueBook(String bookId, String memberId) {
        Book book = bookRepository.findByBookId(bookId);
        Member member = memberRepository.findByMemberId(memberId);

        if(book == null) return "Book not found.";
        if(member == null) return "Member not found.";

        if(!book.isAvailable()) return "Book is already checked out.";
        book.setAvailable(false);

        return "Book \"" + book.getTitle() + "\" issued to " + member.getMemberName() + ".";
    }

    @Override
    public String returnBook(String bookId) {
        Book book = bookRepository.findByBookId(bookId);
        if (book == null) return "Book not found.";
        if (book.isAvailable()) return "Book was not checked out.";

        book.setAvailable(true);
        return "Book \"" + book.getTitle() + "\" returned successfully.";
    }

    @Override
    public List<Book> listAvailableBooks() {
        return bookRepository.findAllBooks().stream()
                .filter(Book::isAvailable)
                .collect(Collectors.toList());
    }
}
