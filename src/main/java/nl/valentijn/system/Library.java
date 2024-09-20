package nl.valentijn.system;

import java.util.*;


public class Library {

    private static List<Book> books = new ArrayList<>();

    public void addBook(long id, String title, String author, int pages, String isbn){

        Book newBook = new Book(id, title, author, pages, isbn, false);
        books.add(newBook);
    }
    public void removeBook(long removeBook){
        Book bookFound = null;

        for (Book book : books){
            if (book.id == removeBook){
                bookFound = book;
                break;
            }
        }
        books.remove(bookFound);
    }
    /**
     * ik had eerst Book.toString. dit zorgde dat alles statische moest worden omdat het via de class word benaderd
     * als we het via de variablele doen hoeft niet alles statische te worden.
     */
    public String showBook(long foundBook1){
        Book bookFound1 = null;

        for (Book book : books){
            if (book.id == foundBook1){
                bookFound1 = book;
                break;
            }
        }
        return bookFound1.toString();
    }
    public void borrowBook(long borrowedBook){
        Book bookBorrowed = null;

        for (Book book : books){
            if (book.id == borrowedBook){
                bookBorrowed = book;
                break;
            }
        }
        bookBorrowed.borrowBook();

    }
    public void returnBook(long bookReturned){
        Book foundBook = null;

        for (Book book : books){
            if (book.id == bookReturned){
                foundBook = book;
                break;
            }
        }
        foundBook.returnBook();
    }
    public static String showBooks(){
        for (Book book : books){
            System.out.println(book.toString());
        }
        return books.toString();
    }
    public static String showBorrowedBooks(){
        for (Book book : books){
            if (book.borrowed == true){
                System.out.println(book.toString());
            }
        }
        return books.toString();
    }
    public static String showAvailableBooks(){
        for (Book book : books){
            if (book.borrowed == false){
                System.out.println(book.toString());
            }
        }
        return books.toString();
    }
}
