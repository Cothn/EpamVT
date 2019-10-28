package DAO.impl.Serializers;

import beans.Author;

public class AuthorSerializer {
    //Author    Id#Name#Surname#birthDate#description
    private static String separator = "#";

    public static   Author ParseAuthors(String authorAsString) {
        String[] authorInfo = authorAsString.split(separator);

        if(authorInfo.length != 6)
            return null;

        Author result;
        result = new Author(Integer.parseInt(authorInfo[1]),  authorInfo[2], authorInfo[3], authorInfo[4], authorInfo[5]);
        return result;
    }

    public static String FormatAuthor(Author author) {

        String result = null;
        result = "Author" + separator + author.getId() + separator + author.getName() + separator + author.getSurname();
        result += separator + author.getBirthDate()+ separator + author.getDescription();
        return result;
    }
}
