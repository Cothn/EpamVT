package beans;


public class Comics extends  LibraryObj{

    private String drawing;
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




    @Override
    public String StringView() {

        String result;
        result = String.format("Comics | id: %-13d| ",this.getId());
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
        result += String.format(" Numbers of page: %-5d|  drawing: %-18s| universe: %-12s|  description: %-40s|", this.getPagesNum(), drawing, universe, this.getDescription());

        return result;
    }

    public String getDrawing() {
        return drawing;
    }

    public void setDrawing(String drawing) {
        this.drawing = drawing;
    }

    public String getUniverse() {
        return universe;
    }

    public void setUniverse(String universe) {
        this.universe = universe;
    }
}
