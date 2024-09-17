package nl.valentijn.system;

import java.util.*;


public class Library {

    public static List<Book> books = new ArrayList<>();

    public void addBook(long id, String title, String author, int pages, String isbn){

        Book newBook = new Book(id, title, author, pages, isbn, false);
        books.add(newBook);
    }
    public void removeBook(Book bookFound){

        books.remove(bookFound);
    }
    /**
     * ik had eerst Book.toString. dit zorgde dat alles statische moest worden omdat het via de class word benaderd
     * als we het via de variablele doen hoeft niet alles statische te worden.
     */
    public String showBook(Book bookFound1){
        return bookFound1.toString();
    }
    public void borrowBook(Book bookBorrowed){
        bookBorrowed.borrowBook();

    }
    public void returnBook(Book bookReturned){
        bookReturned.returnBook();
    }
    String showBooks(){
        return books.toString();
    }
    String showBorrowedBooks(){
        return books.toString();
    }
    String showAvailableBooks(){
        return books.toString();
    }
}
