package beans;

import java.util.Calendar;

public class Book extends LibraryObj{

    private String Genre;
    private String ISBN;



    public Book() {
        super();
    }



    public Book( Author author, String title, PublishingHouse publishingHouse, Calendar birthDate, String description,  String genre, String isbn) {
        super( author, title, publishingHouse, birthDate,  description);
        Genre = genre;
        ISBN = isbn;
    }


    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
}
