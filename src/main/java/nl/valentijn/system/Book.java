package nl.valentijn.system;

public class Book {
    public long id;
    private String title;
    private String author;
    private int pages;
    private String isbn;
    public Boolean borrowed;

    Book(long id, String title, String author, int pages, String isbn, Boolean borrowed){
        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.isbn = isbn;
        this.borrowed = borrowed;
    }

    /**
     * een getter (methode met 1 functie) die het boek id terug geeft
     * @return geeft het boek id
     */
    long getid(){
        return id;
    }
    /**
     * returned een true or false waarde voor borrowed
     */
    Boolean hasBeenBorrowed(){
        return borrowed;
    }
    String getTitleWithAuthor(){
        return title + author;
    }
    public String toString(){
        return """ 
                    ID: %s
                    Title: %s
                    Author: %s
                    Pages: %s
                    ISBN: %s
                    Borrowed: %s
                    """.formatted( id, title, author, pages, isbn, borrowed);
    }
    void borrowBook(){
        Boolean a = true;
        borrowed = a;
    }
    void returnBook(){
        Boolean b = false;
        borrowed = b;
    }
}
