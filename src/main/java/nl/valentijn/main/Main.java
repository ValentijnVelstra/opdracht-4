package nl.valentijn.main;

import nl.valentijn.system.Book;
import nl.valentijn.system.Library;

import java.util.Scanner;
import java.util.regex.Pattern;

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

                    library.removeBook(removeBook);

                case 3:

                    Scanner bookFinder = new Scanner(System.in);
                    System.out.println("Book ID: ");
                    long foundBook1 = Long.parseLong(bookFinder.next());
                    library.showBook(foundBook1); //dit zet alles klaar om geprint te worden
                    System.out.println(library.showBook(foundBook1)); // we moeten java nog wel vertellen het uit te printen
                    break;

                case 4:

                    Scanner bookBorrow = new Scanner(System.in);
                    System.out.println("Book ID: ");
                    long borrowedBook = Long.parseLong(bookBorrow.next());

                    library.borrowBook(borrowedBook);
                    break;

                case 5:

                    Scanner bookReturn = new Scanner(System.in);
                    System.out.println("Book ID: ");
                    long returnedBook = Long.parseLong(bookReturn.next());
                    library.returnBook(returnedBook);
                    break;

                case 6:

                    Library.showBooks();
                    break;

                case 7:

                    Library.showBorrowedBooks();
                    break;

                case 8:
                    Library.showAvailableBooks();
                    break;

            }
        }
    }
}