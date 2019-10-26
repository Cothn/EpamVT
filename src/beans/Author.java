package beans;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Author extends MyPerentClass{

    private String name;

    private String surname;

    private Calendar birthDate;

    private String Description;



    public Author() {

        this.birthDate = new GregorianCalendar();

    }



    public Author(String name, String surname, Calendar birthDate, String description) {


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



    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
