package DAO.impl.Serializers;

import beans.Author;

/**
 * Хранит методы сериализации/десериализации {@link Author} в текстовый файл
 */
public class AuthorSerializer {
    //Author    Id#Name#Surname#birthDate#description
    /**символ разделитель*/
    private static String separator = "#";

    /**
     * Генерирует класс на основе строки
     * @param authorAsString строка содержащая файловое представление класса
     * @return класс сгенирированный на основе строки libraryObjAsString
     */
    public static   Author ParseAuthors(String authorAsString) {
        String[] authorInfo = authorAsString.split(separator);

        if(authorInfo.length != 6)
            return null;

        Author result;
        result = new Author(Integer.parseInt(authorInfo[1]),  authorInfo[2], authorInfo[3], authorInfo[4], authorInfo[5]);
        return result;
    }

    /**
     * Генерирует строку на основе класса libraryObj
     * @param author обьект для сериализации
     * @return строка содержащая файловое представление класса
     */
    public static String FormatAuthor(Author author) {

        String result = null;
        result = "Author" + separator + author.getId() + separator + author.getName() + separator + author.getSurname();
        result += separator + author.getBirthDate()+ separator + author.getDescription();
        return result;
    }
}
