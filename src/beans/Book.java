/*
 * Всеволод Гринчик 751003 (HRYNCHYK USEVALAD)
 * CRUD VT 2019
 */

package beans;

/**
 * Хранит описание книги
 */
public class Book extends LibraryObj{

    /** жанр */
    private String Genre;
    /** международный идентефикатор книги */
    private String ISBN;

    public Book() {
        super();
    }

    public Book(int id, int authorId, String title, int publishingHouseId, int pagesNum, String description,  String genre, String isbn) {
        super( id, authorId, title, publishingHouseId, pagesNum,  description);
        Genre = genre;
        ISBN = isbn;
    }

    public Book(int authorId, String title, int publishingHouseId, int pagesNum, String description,  String genre, String isbn) {
        super(authorId, title, publishingHouseId, pagesNum,  description);
        Genre = genre;
        ISBN = isbn;
    }

    public String getGenre() {
        return Genre;
    }

    public String getISBN() {
        return ISBN;
    }

    /**
     * Генерация строкового представления обьекта
     * @return Строковое представление описания книги
     */
    @Override
    public String stringView() {

        String result;
        result = String.format("book   | id: %-10d| ",this.getId());
        if (this.getAuthorId() != 0){
            result += String.format(" AuthorId: %-14d| ", this.getAuthorId());
        }
        else
        {
            result += " AuthorId: author unknown| ";
        }
        result += String.format("title: %-20s|", this.getTitle());
        if (this.getPublishingHouseId() != 0){
            result += String.format(" PublishingHouseId: %-24d| ", this.getPublishingHouseId());
        }
        else
        {
            result += " PublishingHouseId: publishing house unknown| ";
        }
        result += String.format(" Numbers of page: %-6d | genre: %-20s| ISBN: %-19s|  description: %-40s|", this.getPagesNum(), Genre, ISBN, this.getDescription());
        return result;
    }
}
