package DAO.TextFile_impl.Serializers;

import beans.Employer;

/**
 * Хранит методы сериализации/десериализации {@link Employer} в текстовый файл
 */
public class EmployerSerializer {
    //Employer    Id#Name#Surname#birthDate#description
    /**символ разделитель*/
    private static String separator = "#";

    /**
     * Генерирует класс на основе строки
     * @param employerAsString строка содержащая файловое представление класса
     * @return класс сгенирированный на основе строки libraryObjAsString
     */
    public static   Employer parseEmployer(String employerAsString) {
        String[] employerInfo = employerAsString.split(separator);

        if(employerInfo.length != 6)
            return null;

        Employer result;
        result = new Employer(Integer.parseInt(employerInfo[1]),  employerInfo[2], employerInfo[3], employerInfo[4], employerInfo[5]);
        return result;
    }

    /**
     * Генерирует строку на основе класса libraryObj
     * @param employer обьект для сериализации
     * @return строка содержащая файловое представление класса
     */
    public static String formatEmployer(Employer employer) {

        String result;
        result = "Employer" + separator + employer.getId() + separator + employer.getName() + separator + employer.getSurname();
        result += separator + employer.getPhone()+ separator + employer.getPosition();
        return result;
    }
}
