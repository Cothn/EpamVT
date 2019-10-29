/*
 * Всеволод Гринчик 751003 (HRYNCHYK USEVALAD)
 * CRUD VT 2019
 */

package beans;

/**
 * Хранит описание комикса
 */
public class Comics extends  LibraryObj{
    /** вид рисовки */
    private String drawing;
    /** вселенная комикса */
    private String universe;


    public Comics() {
        super();
    }

    public Comics(int id, int authorId, String title, int publishingHouseId, int pagesNum, String description,  String drawing, String universe) {
        super( id, authorId, title, publishingHouseId, pagesNum,  description);
        this.drawing = drawing;
        this.universe = universe;

    }

    public Comics(int authorId, String title, int publishingHouseId, int pagesNum, String description,  String drawing, String universe) {
        super(authorId, title, publishingHouseId, pagesNum,  description);
        this.drawing = drawing;
        this.universe = universe;
    }

    /**
     * Генерация строкового представления обьекта
     * @return Строковое представление описания комикса
     */
    @Override
    public String stringView() {

        String result;
        result = String.format("Comics | id: %-10d| ",this.getId());
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
        result += String.format(" Numbers of page: %-6d | drawing: %-18s| universe: %-15s|  description: %-40s|", this.getPagesNum(), drawing, universe, this.getDescription());
        return result;
    }

    public String getDrawing() {
        return drawing;
    }

    public String getUniverse() {
        return universe;
    }

}
