package DAO.impl.Serializers;

import beans.Article;
import beans.Book;
import beans.Comics;
import beans.LibraryObj;

import java.util.HashMap;
import java.util.Map;

public class LibrarySerializerFactory {


    static Map<String, LibrarySerializer> map = new HashMap<String, LibrarySerializer>(){};
    static {
        map.put(Book.class.getSimpleName(), new BookSerializer());
        map.put(Article.class.getSimpleName(), new ArticleSerializer());
        map.put(Comics.class.getSimpleName(), new ComicsSerializer());
    }

    public LibraryObj  ParseLibraryObj(String libraryObjAsString)
    {
        String[] bookInfo = libraryObjAsString.split("#");///!!!
        LibrarySerializer librarySerializer = map.get(bookInfo[0]);
        return librarySerializer.ParseLibraryObj(libraryObjAsString);
    }

    public String FormatLibraryObj(LibraryObj libraryObj)
    {
        LibrarySerializer librarySerializer = map.get(libraryObj.getClass().getSimpleName());
        return librarySerializer.FormatLibraryObj(libraryObj);
    }
}
