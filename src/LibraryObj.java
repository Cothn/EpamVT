import java.util.Calendar;
import java.util.GregorianCalendar;

public class LibraryObj {
    private int idLibraryObj;
    private Author author;
    private String title;
    private Author PublichingHouse;
    private Calendar PublichingDate;
    private String Description;


    public LibraryObj() {

        this.PublichingDate = new GregorianCalendar();

    }


    public LibraryObj(int idLibraryObj, Author author, String title, Author publichingHouse, Calendar birthDate, String description) {
        this.idLibraryObj = idLibraryObj;
        this.author = author;

        this.title = title;
        PublichingHouse = publichingHouse;
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

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Author getPublichingHouse() {
        return PublichingHouse;
    }

    public void setPublichingHouse(Author publichingHouse) {
        PublichingHouse = publichingHouse;
    }


    public int getIdLibraryObj() {
        return idLibraryObj;
    }

    public void setIdLibraryObj(int idLibraryObj) {
        this.idLibraryObj = idLibraryObj;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
