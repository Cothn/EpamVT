public class Employee {
    private int idEmployee;

    private String name;

    private String surname;

    private String phone;

    private String department;



    public Employee() {

    }



    public Employee(int idEmployee, String name, String surname, String phone, String department) {

        this.idEmployee = idEmployee;

        this.name = name;

        this.surname = surname;

        this.phone = phone;

        this.department = department;

    }



    public int getIdEmployee() {

        return idEmployee;

    }



    public void setIdEmployee(int idEmployee) {

        this.idEmployee = idEmployee;

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
