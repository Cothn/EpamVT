import java.util.Calendar;

public class Book extends LibraryObj{

    private String Genre;
    private String ISBN;


    public Book() {
        super();
    }



    public Book(int idLibraryObj, String title,  Author publichingHouse, Calendar birthDate, String description, Author author, String genre, String isbn) {
        super(idLibraryObj, author, title, publichingHouse, birthDate,  description);
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
