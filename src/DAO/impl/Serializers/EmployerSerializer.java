package DAO.impl.Serializers;

import beans.Employer;

public class EmployerSerializer {
    //Employer    Id#Name#Surname#birthDate#description
    private static String separator = "#";

    public static   Employer ParseEmployer(String employerAsString) {
        String[] employerInfo = employerAsString.split(separator);

        if(employerInfo.length != 6)
            return null;

        Employer result;
        result = new Employer(Integer.parseInt(employerInfo[1]),  employerInfo[2], employerInfo[3], employerInfo[4], employerInfo[5]);
        return result;
    }

    public static String FormatEmployer(Employer author) {

        String result;
        result = "Employer" + separator + author.getId() + separator + author.getName() + separator + author.getSurname();
        result += separator + author.getPhone()+ separator + author.getPosition();
        return result;
    }
}
