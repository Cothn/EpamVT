import java.util.Calendar;
import java.util.GregorianCalendar;

public class PublichingHouse {
    private int idPublichingHouse;

    private String title;

    private String adress;

    private String phone;

    private Calendar birthDate;

    private String Description;

    public PublichingHouse() {

        this.birthDate = new GregorianCalendar();

    }

    public PublichingHouse(int idPublichingHouse, String title, String adress, String phone, Calendar birthDate, String description) {
        this.idPublichingHouse = idPublichingHouse;
        this.adress = adress;
        this.phone = phone;

        this.birthDate = birthDate;
        this.title = title;
        Description = description;
    }

    public Calendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getIdPublichingHouse() {
        return idPublichingHouse;
    }

    public void setIdPublichingHouse(int idPublichingHouse) {
        this.idPublichingHouse = idPublichingHouse;
    }
}
