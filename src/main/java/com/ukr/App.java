package com.ukr;

import com.ukr.Model.Book;
import com.ukr.Model.Member;
import com.ukr.Service.LibraryService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        LibraryService libraryService = context.getBean("libraryService", LibraryService.class);

        libraryService.addBook(new Book("101", "IELTS", "Teaxs Review"));
        libraryService.addBook(new Book("102", "GRE", "TEXAS EYER"));

        libraryService.registerMember("111", "Uday");
        libraryService.issueBook("101","111");
        System.out.println("Available Books");
        libraryService.listAvailableBooks().forEach(b -> System.out.println(" - " + b.getTitle()));

        // Return the book
        System.out.println(libraryService.returnBook("101"));

        // List again
        System.out.println("Available books after return:");
        libraryService.listAvailableBooks().forEach(b -> System.out.println(" - " + b.getTitle()));
    }
}
