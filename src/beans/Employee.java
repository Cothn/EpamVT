package beans;

public class Employee {

    private String name;

    private String surname;

    private String phone;

    private String department;



    public Employee() {

    }



    public Employee(String name, String surname, String phone, String department) {


        this.name = name;

        this.surname = surname;

        this.phone = phone;

        this.department = department;

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



    public String getDepartment() {

        return department;

    }



    public void setDepartment(String department) {

        this.department = department;

    }
}
