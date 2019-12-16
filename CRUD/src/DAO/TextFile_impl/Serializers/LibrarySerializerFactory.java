package DAO.TextFile_impl.Serializers;

import beans.Article;
import beans.Book;
import beans.Comics;
import beans.LibraryObj;

import java.util.HashMap;
import java.util.Map;

/**
 * Содержит методы получения конкреттных реализаций сериализатора логики через интерфейсы
 */
public class LibrarySerializerFactory {
    /**символ разделитель*/
    private static String separator = "#";

    /**Hash-Map соотносящая имя класса и его сериализатор*/
    static private Map<String, LibrarySerializer> map = new HashMap<String, LibrarySerializer>(){};
    static {
        map.put(Book.class.getSimpleName(), new BookSerializer());
        map.put(Article.class.getSimpleName(), new ArticleSerializer());
        map.put(Comics.class.getSimpleName(), new ComicsSerializer());
    }

    /**
     * Определяет класс обьекта и передает строку содержащюю параметры класса в подходящий сериализатор
     * @param libraryObjAsString строка содержащая файловое представление класса
     * @return класс сгенирированный на основе строки libraryObjAsString
     */
    public LibraryObj parseLibraryObj(String libraryObjAsString)
    {
        String[] bookInfo = libraryObjAsString.split(separator);
        LibrarySerializer librarySerializer = map.get(bookInfo[0]);
        return librarySerializer.parseLibraryObj(libraryObjAsString);
    }

    /**
     * Определяет сериализатор обьекта и передает в подходящий сериализатор
     * @param libraryObj обьект для сериализации
     * @return строка содержащая файловое представление класса
     */
    public String formatLibraryObj(LibraryObj libraryObj)
    {
        LibrarySerializer librarySerializer = map.get(libraryObj.getClass().getSimpleName());
        return librarySerializer.formatLibraryObj(libraryObj);
    }
}
