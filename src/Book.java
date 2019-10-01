import java.util.Calendar;

public class Book extends LibraryObj{

    private Author author;
    private String Genre;
    private String ISBN;


    public Book() {
        super();
    }



    public Book(int idLibraryObj, String title,  Author publichingHouse, Calendar birthDate, String description, Author author, String genre, String isbn) {
        super(idLibraryObj, title, publichingHouse, birthDate,  description);
        this.author = author;
        Genre = genre;
        ISBN = isbn;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
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
