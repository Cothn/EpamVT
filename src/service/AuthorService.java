/*
 * Всеволод Гринчик 751003 (HRYNCHYK USEVALAD)
 * CRUD VT 2019
 */
package service;

import beans.Author;

import java.util.ArrayList;

/**
 * Интерфейс доступа к бизнес логике обьекта {@link Author}
 */
public interface AuthorService {

    /**
     * Передает обьект по его идентификатору
     * @param id идентификатор обьекта
     * @return найденный обьект или null
     */
    Author getAuthor(Integer id);

    /**
     * Добавляет новый обьект(author) в базу данных
     * @param author новый обьект
     */
    void addAuthor(Author author) ;

    /**
     * Извлекает полный массив обьектов {@link Author}
     * @return полный массив обьектов {@link Author}
     */
    ArrayList<Author> getAllAuthor() ;

    /**
     * Замещает обьект с идентификатором id на обьект author
     * @param id идентификатор замещаемого обьекта
     * @param author новаый обьект
     */
    void update(Integer id, Author author) ;

    /**
     * Удаляет обьект с идентификатором id
     * @param id идентификатор удаляемого обьекта
     */
    void deleteAuthorById(Integer id);

    /**
     * Сортирует все обьекты по имени
     * @param ascending вид сортировки (если true то по возрастанию)
     * @return отссортированный массив
     */
    ArrayList<Author> sortByName(boolean ascending);

    /**
     * Ищет обьект по имени
     * @param name имя автора
     * @return массив подходящих обьектов
     */
    ArrayList<Author> findByName(String name);

}
