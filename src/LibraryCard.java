import java.util.Calendar;
import java.util.GregorianCalendar;

public class LibraryCard {
    private int idCard;

    private Calendar dateIn;

    private Calendar dateOut;

    private LibraryObj libraryObj;

    private Employee employee;




    public LibraryCard() {

        this.dateIn = new GregorianCalendar();

        this.dateOut = new GregorianCalendar();

    }



    public LibraryCard(int idCard, Calendar dateStart, Calendar dateEnd, LibraryObj libraryObj, Employee employee) {

        this.idCard = idCard;

        this.dateIn = dateStart;

        this.dateOut = dateEnd;

        this.libraryObj = libraryObj;

        this.employee = employee;

    }



    public int getIdCard() {

        return idCard;

    }



    public void setIdCard(int idCard) {

        this.idCard = idCard;

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







    public Employee getEmployee() {

        return employee;

    }



    public void setEmployee(Employee employee) {

        this.employee = employee;

    }

    public LibraryObj getLibraryObj() {
        return libraryObj;
    }

    public void setLibraryObj(LibraryObj libraryObj) {
        this.libraryObj = libraryObj;
    }
}
