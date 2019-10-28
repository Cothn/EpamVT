package beans;


public class Author extends MyPerentClass{

    private String name;
    private String surname;
    private String birthDate;
    private String Description;

    public Author() {


    }

    public Author(int id, String name, String surname,String birthDate, String description) {

        super(id);
        this.name = name;

        this.surname = surname;

        this.birthDate = birthDate;

        Description = description;
    }

    public Author( String name, String surname,String birthDate, String description) {

        this.name = name;

        this.surname = surname;

        this.birthDate = birthDate;

        Description = description;
    }

    public String getName() {

        return name;

    }

    public String getSurname() {

        return surname;

    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getBirthDate() {
        return birthDate;
    }

    @Override
    public String StringView() {
        String result;
        result = String.format(" id: %-10d| ",this.getId());
        result += String.format(" Name: %-13s|  Surname: %-20s| birthDate: %-10s|  description: %-70s|", this.name, this.surname, this.birthDate, this.Description);
        return result;
    }
}
