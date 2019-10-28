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

    public void setName(String name) {

        this.name = name;

    }

    public String getSurname() {

        return surname;

    }

    public void setSurname(String surname) {

        this.surname = surname;

    }

    public String getPhone() {

        return phone;

    }

    public void setPhone(String phone) {

        this.phone = phone;

    }

    public String getPosition() {

        return position;

    }

    public void setPosition(String position) {

        this.position = position;

    }

    @Override
    public String StringView() {

        String result;
        result = String.format(" id: %-13d| ",this.getId());

        result += String.format(" Name: %-13s|  Surname: %-20s| phone: %-13s|  position: %-13s|", this.name, this.surname, this.phone, this.position);

        return result;
    }
}
