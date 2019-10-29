/*
 * Всеволод Гринчик 751003 (HRYNCHYK USEVALAD)
 * CRUD VT 2019
 */
package DAO;

import beans.Author;

import java.util.ArrayList;
import java.util.List;

/**
 * Интерфейс доступа к базе даных хранящей обьекты {@link Author}
 */
public interface AuthorDAO {
    /**
     * Передает полный массив обьектов {@link Author}
     * @return полный массив обьектов {@link Author}
     */
    List<Author> getAll();

    /**
     * Ищет обьект по его идентификатору
     * @param id идентификатор обьекта
     * @return найденный обьект или null
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
