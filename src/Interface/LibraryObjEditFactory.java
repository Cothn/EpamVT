package Interface;


import Interface.impl.console.ArticleEditInterface;
import Interface.impl.console.BookEditInterface;
import Interface.impl.console.ComicsEditInterface;
import beans.Article;
import beans.Book;
import beans.Comics;

import java.util.HashMap;
import java.util.Map;

public class LibraryObjEditFactory {
    static Map<String, LibraryObjEditInterface> map = new HashMap<String, LibraryObjEditInterface>(){};
    static {
        map.put(Book.class.getSimpleName(), new BookEditInterface());
        map.put(Article.class.getSimpleName(), new ArticleEditInterface());
        map.put(Comics.class.getSimpleName(), new ComicsEditInterface());
    }


    public static LibraryObjEditInterface GetEditInterface(String LibraryObjType)
    {
        return map.get(LibraryObjType);
    }
}
