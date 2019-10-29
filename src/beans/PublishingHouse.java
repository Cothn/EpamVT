/*
 * Всеволод Гринчик 751003 (HRYNCHYK USEVALAD)
 * CRUD VT 2019
 */

package beans;

/**
 * Хранит описание издательства
 */
public class PublishingHouse extends MyPerentClass{

    /** название */
    private String title;
    /** адресс */
    private String address;
    /** телефон */
    private String phone;
    /** дата основания */
    private String FoundationDate;
    /** описаня издательства */
    private String Description;

    public PublishingHouse(int id, String title, String address, String phone, String FoundationDate, String description) {
        super(id);
        this.address = address;
        this.phone = phone;
        this.FoundationDate = FoundationDate;
        this.title = title;
        Description = description;
    }

    public PublishingHouse( String title, String address, String phone, String FoundationDate, String description) {
        this.address = address;
        this.phone = phone;
        this.FoundationDate = FoundationDate;
        this.title = title;
        Description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getFoundationDate() {
        return FoundationDate;
    }

    /**
     * Генерация строкового представления обьекта
     * @return Строковое представление описания издательства
     */
    @Override
    public String StringView() {

        String result;
        result = String.format(" id: %-10d| ",this.getId());
        result += String.format(" Title: %-13s|  Address: %-17s| phone: %-13s|  birthDate: %-13s|  Description: %-50s", this.title, this.address, this.phone, this.FoundationDate, this.Description);
        return result;
    }
}
