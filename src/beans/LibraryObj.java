package beans;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class LibraryObj extends MyPerentClass {
    private Author author;
    private String title;
    private PublishingHouse publishingHouse;
    private int pagesNum;
    private String Description;


    public LibraryObj() {


    }


    public LibraryObj( Author author, String title, PublishingHouse publishingHouse, int pagesNum, String description) {

        this.author = author;

        this.title = title;
        this.publishingHouse = publishingHouse;
        this.pagesNum = pagesNum;
        Description = description;
}



    public String getTitle() {

        return title;

    }



    public void setTitle(String title) {

        this.title = title;

    }








    public String getSubject() {
        return Description;
    }

    public void setSubject(String subject) {
        Description = subject;
    }

    public PublishingHouse getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(PublishingHouse publishingHouse) {
        publishingHouse = publishingHouse;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getPagesNum() {
        return pagesNum;
    }

    public void setPagesNum(int pagesNum) {
        this.pagesNum = pagesNum;
    }
}
