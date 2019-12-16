/*
  Всеволод Гринчик 751003 (HRYNCHYK USEVALAD)
  CRUD VT 2019
 */

package beans;

/**
 * Хранит описание автора
 */
public class Author extends MyPerentClass{
    /** имя */
    private String name;
    /**  фамилия */
    private String surname;
    /** дата рождения */
    private String birthDate;
    /** описаня автора */
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

    public void setName(String Name) {

        name= Name;

    }

    public void setSurname(String surName) {

        surname= surName;

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

    public void setBirthDate(String birth_date) {
        birthDate = birth_date;
    }

    /**
     * Генерация строкового представления обьекта
     * @return Строковое представление описания автора
     */
    @Override
    public String stringView() {
        String result;
        result = String.format(" id: %-10d| ",this.getId());
        result += String.format(" Name: %-13s|  Surname: %-20s| birthDate: %-10s|  description: %-70s|", this.name, this.surname, this.birthDate, this.Description);
        return result;
    }
}
