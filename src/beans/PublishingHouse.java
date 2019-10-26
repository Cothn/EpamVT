package beans;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class PublishingHouse {

    private String title;

    private String adress;

    private String phone;

    private Calendar birthDate;

    private String Description;

    public PublishingHouse() {

        this.birthDate = new GregorianCalendar();

    }

    public PublishingHouse(String title, String adress, String phone, Calendar birthDate, String description) {
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

}
