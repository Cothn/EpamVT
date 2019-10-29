/*
 * Всеволод Гринчик 751003 (HRYNCHYK USEVALAD)
 * CRUD VT 2019
 */

package beans;

/**
 * Базовый клас для описания различных текстовых обьектов хранящихся в библиотеке
 */
public class LibraryObj extends MyPerentClass {
    /** идентификатор атора */
    private int authorId;
    /** название */
    private String title;
    /** идентификатор издательства */
    private int publishingHouseId;
    /** число страниц */
    private int pagesNum;
    /** описание обьекта */
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
