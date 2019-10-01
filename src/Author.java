import java.util.Calendar;
import java.util.GregorianCalendar;

public class Author {
    private int idAuthor;

    private String name;

    private String surname;

    private Calendar birthDate;

    private String Description;



    public Author() {

        this.birthDate = new GregorianCalendar();

    }



    public Author(int idAuthor, String name, String surname, Calendar birthDate, String description) {

        this.idAuthor = idAuthor;

        this.name = name;

        this.surname = surname;

        this.birthDate = birthDate;

        Description = description;
    }



    public String getName() {

        return name;

    }



    public void setName(String name) {

        this.name = name;

    }



    public String getSurname() {

        return surname;

    }



    public void setSurname(String surname) {

        this.surname = surname;

    }



    public Calendar getBirthDate() {

        return birthDate;

    }



    public void setBirthDate(Calendar birthDate) {

        this.birthDate = birthDate;

    }



    public int getIdAuthor() {

        return idAuthor;

    }



    public void setIdAuthor(int id) {

        this.idAuthor = id;

    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
