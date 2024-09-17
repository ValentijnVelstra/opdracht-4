package nl.valentijn.main;

import nl.valentijn.system.Book;
import nl.valentijn.system.Library;

import java.util.Scanner;
import java.util.regex.Pattern;

import static nl.valentijn.system.Library.books;

public class Main {
    public static void main(String[] args) {

        Pattern names = Pattern.compile("[a-zA-Z]{1,}");
        Pattern numbers = Pattern.compile("[0-9]{1,}");
        Library library = new Library();


        while (true) {
            Scanner optie = new Scanner(System.in);  // Create a Scanner object
            System.out.println(""" 
                    Choose: 1. Add a book.
                            2. Remove a book.
                            3. show a book.
                            4. borrow a book.
                            5. return a book.
                            6. show all books.
                            7. show borrowed books.
                            8. show available books.
                    """);
            Integer choice = optie.nextInt();

            switch (choice) { //de switch kijkt welke menu keuze is gamaakt

                case 1:

                    Scanner addNewBook = new Scanner(System.in);

                    System.out.println("ID: ");
                    while(!addNewBook.hasNext(numbers)) {
                        System.out.println("Please enter a valid ID: ");
                        addNewBook.next();
                    }
                    long bookid = Long.parseLong(addNewBook.next());

                    System.out.println("Title: ");
                    while(!addNewBook.hasNext(names)) {
                        System.out.println("Please enter a valid ID: ");
                        addNewBook.next();
                    }
                    String bookTitle = addNewBook.next();

                    System.out.println("Author: ");
                    while(!addNewBook.hasNext(names)) {
                        System.out.println("Please enter a valid ID: ");
                        addNewBook.next();
                    }
                    String bookAuthor = addNewBook.next();

                    System.out.println("Pages: ");
                    while(!addNewBook.hasNext(numbers)) {
                        System.out.println("Please enter a valid ID: ");
                        addNewBook.next();
                    }
                    int bookPages = Integer.parseInt(addNewBook.next());

                    System.out.println("ISBN: ");
                    while(!addNewBook.hasNext(numbers)) {
                        System.out.println("Please enter a valid ID: ");
                        addNewBook.next();
                    }
                    String bookisbn = addNewBook.next();

                    library.addBook(bookid, bookTitle, bookAuthor, bookPages, bookisbn);
                    break;

                case 2:

                    Scanner remover = new Scanner(System.in);
                    System.out.println("Book ID: ");
                    long removeBook = Long.parseLong(remover.next());
                    Book bookFound = null;

                    for (Book book : books){
                        if (book.id == removeBook){
                            bookFound = book;
                            break;
                        }
                    }
                    library.removeBook(bookFound);

                case 3:

                    Scanner bookFinder = new Scanner(System.in);
                    System.out.println("Book ID: ");
                    long foundBook = Long.parseLong(bookFinder.next());
                    Book bookFound1 = null;

                    for (Book book : books){
                        if (book.id == foundBook){
                            bookFound1 = book;
                            break;
                        }
                    }
                    library.showBook(bookFound1); //dit zet alles klaar om geprint te worden
                    System.out.println(library.showBook(bookFound1)); // we moeten java nog wel vertellen het uit te printen
                    break;

                case 4:

                    Scanner bookBorrow = new Scanner(System.in);
                    System.out.println("Book ID: ");
                    long borrowedBook = Long.parseLong(bookBorrow.next());
                    Book bookBorrowed = null;

                    for (Book book : books){
                        if (book.id == borrowedBook){
                            bookBorrowed = book;
                            break;
                        }
                    }
                    library.borrowBook(bookBorrowed);
                    break;

                case 5:

                    Scanner bookReturn = new Scanner(System.in);
                    System.out.println("Book ID: ");
                    long returnedBook = Long.parseLong(bookReturn.next());
                    Book bookReturned = null;

                    for (Book book : books){
                        if (book.id == returnedBook){
                            bookReturned = book;
                            break;
                        }
                    }
                    library.returnBook(bookReturned);
                    break;

                case 6:
                    for (Book book : books){
                        System.out.println(library.showBook(book));
                    }
                case 7:

                    for (Book book : books){
                        if (book.borrowed == true){
                            System.out.println(library.showBook(book));
                            break;
                        }
                    }
                case 8:
                    for (Book book : books){
                        if (book.borrowed == false){
                            System.out.println(library.showBook(book));
                            break;
                        }
                    }

            }
        }
    }
}