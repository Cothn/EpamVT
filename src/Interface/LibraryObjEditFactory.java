/*
 * Всеволод Гринчик 751003 (HRYNCHYK USEVALAD)
 * CRUD VT 2019
 */
package Interface;


import Interface.impl.console.ArticleEditInterfaceImpl;
import Interface.impl.console.BookEditInterfaceImpl;
import Interface.impl.console.ComicsEditInterfaceImpl;
import beans.Article;
import beans.Book;
import beans.Comics;

import java.util.HashMap;
import java.util.Map;

/**
 * Содержит методы получения конкреттных реализаций интерфейса создания обьекта
 */
public class LibraryObjEditFactory {

    /**Hash-Map соотносящая имя класса и его интерфейса создания обьекта*/
    static private Map<String, LibraryObjEditInterface> map = new HashMap<String, LibraryObjEditInterface>(){};
    static {
        map.put(Book.class.getSimpleName(), new BookEditInterfaceImpl());
        map.put(Article.class.getSimpleName(), new ArticleEditInterfaceImpl());
        map.put(Comics.class.getSimpleName(), new ComicsEditInterfaceImpl());
    }

    /**
     * Получает обьект по его имени
     * @param LibraryObjType тип обьекта
     * @return интерфейс создания обьекта
     */
    public static LibraryObjEditInterface GetEditInterface(String LibraryObjType)
    {
        return map.get(LibraryObjType);
    }
}
