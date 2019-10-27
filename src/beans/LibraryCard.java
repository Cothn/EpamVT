package beans;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class LibraryCard {

    private Calendar dateIn;

    private Calendar dateOut;

    private String name;

    private String surName;
    private String phone;
    private ArrayList<Book> books;




    public LibraryCard() {

        this.dateIn = new GregorianCalendar();

        this.dateOut = new GregorianCalendar();

    }

    public LibraryCard(Calendar dateStart, Calendar dateEnd,String name, String SurName, String dateOfMembership, String address, ArrayList<Book> books)
    {
        this.dateIn = dateStart;
        this.dateOut = dateEnd;
        this.name = name;
        this.surName = SurName;
        this.books = books;
    }



    public Calendar getDateStart() {

        return dateIn;

    }



    public void setDateStart(Calendar dateStart) {

        this.dateIn = dateStart;

    }



    public Calendar getDateEnd() {

        return dateOut;

    }



    public void setDateEnd(Calendar dateEnd) {

        this.dateOut = dateEnd;

    }









    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }
}
