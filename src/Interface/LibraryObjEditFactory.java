package Interface;


import Interface.impl.console.ArticleEditInterfaceImpl;
import Interface.impl.console.BookEditInterfaceImpl;
import Interface.impl.console.ComicsEditInterfaceImpl;
import beans.Article;
import beans.Book;
import beans.Comics;

import java.util.HashMap;
import java.util.Map;

public class LibraryObjEditFactory {
    static private Map<String, LibraryObjEditInterface> map = new HashMap<String, LibraryObjEditInterface>(){};
    static {
        map.put(Book.class.getSimpleName(), new BookEditInterfaceImpl());
        map.put(Article.class.getSimpleName(), new ArticleEditInterfaceImpl());
        map.put(Comics.class.getSimpleName(), new ComicsEditInterfaceImpl());
    }

    public static LibraryObjEditInterface GetEditInterface(String LibraryObjType)
    {
        return map.get(LibraryObjType);
    }
}
