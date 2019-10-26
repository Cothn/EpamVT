package beans;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class LibraryObj extends MyPerentClass {
    private Author author;
    private String title;
    private PublishingHouse publishingHouse;
    private Calendar PublichingDate;
    private String Description;


    public LibraryObj() {

        this.PublichingDate = new GregorianCalendar();

    }


    public LibraryObj( Author author, String title, PublishingHouse publishingHouse, Calendar birthDate, String description) {

        this.author = author;

        this.title = title;
        this.publishingHouse = publishingHouse;
        this.PublichingDate = birthDate;
        Description = description;
}



    public String getTitle() {

        return title;

    }



    public void setTitle(String title) {

        this.title = title;

    }






    public Calendar getBirthDate() {
        return PublichingDate;
    }

    public void setBirthDate(Calendar birthDate) {
        this.PublichingDate = birthDate;
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
}
