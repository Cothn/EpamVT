package beans;

public class Employer extends MyPerentClass {

    private String name;
    private String surname;
    private String phone;
    private String position;

    public Employer(int id, String name, String surname, String phone, String position) {

        super(id);
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.position = position;

    }

    public Employer(String name, String surname, String phone, String position) {

        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public String StringView() {

        String result;
        result = String.format(" id: %-10d| ",this.getId());
        result += String.format(" Name: %-13s|  Surname: %-20s| phone: %-13s|  position: %-13s|", this.name, this.surname, this.phone, this.position);
        return result;
    }
}
