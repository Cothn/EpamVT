package beans;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class LibraryObj extends MyPerentClass {
    private int authorId;
    private String title;
    private int publishingHouseId;
    private int pagesNum;
    private String Description;

    public LibraryObj() {}

    public LibraryObj(int id, int authorId, String title, int publishingHouseId, int pagesNum, String description) {
        super(id);
        this.authorId = authorId;
        this.title = title;
        this.publishingHouseId = publishingHouseId;
        this.pagesNum = pagesNum;
        Description = description;
}

    public LibraryObj(int authorId, String title, int publishingHouseId, int pagesNum, String description) {
        this.authorId = authorId;
        this.title = title;
        this.publishingHouseId = publishingHouseId;
        this.pagesNum = pagesNum;
        Description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPagesNum() {
        return pagesNum;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getPublishingHouseId() {
        return publishingHouseId;
    }

    public void setPublishingHouseId(int publishingHouseId) {
        this.publishingHouseId = publishingHouseId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
}
