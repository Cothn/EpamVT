/*
 * Всеволод Гринчик 751003 (HRYNCHYK USEVALAD)
 * CRUD VT 2019
 */
package DAO;

import beans.Author;

import java.util.ArrayList;

/**
 * Интерфейс доступа к базе даных хранящей обьекты {@link Author}
 */
public interface AuthorDAO {
    /**
     * Передает полный массив обьектов {@link Author}
     * @return полный массив обьектов {@link Author}
     */
    ArrayList<Author> getAll();

    /**
     * Обьеденят десериализованные обьект в единый список
     * @return полный массив обьектов {@link Author}
     */
    Author getById(Integer id);

    /**
     * Замещает обьект с идентификатором id на обьект author
     * @param id идентификатор замещаемого обьекта
     * @param author новаый обьект
     * @return номер обьекта в списке или 0 если обьекта с идентификатором id  не существует
     */
    int update(Integer id, Author author);

    /**
     * Удаляет обьект с идентификатором id
     * @param id идентификатор удаляемого обьекта
     * @return true если удаление прошло успешно иначе false
     */
    boolean deleteById(Integer id);

    /**
     * Добавляет новый обьект(newAuthor) в базу данных
     * @param newAuthor новый обьект
     * @return true если добавление прошло успешно иначе false
     */
    boolean create(Author newAuthor);
}
