/*
 * Всеволод Гринчик 751003 (HRYNCHYK USEVALAD)
 * CRUD VT 2019
 */
package DAO;

import beans.Employer;

import java.util.ArrayList;

/**
 * Интерфейс доступа к базе даных хранящей обьекты {@link Employer}
 */
public interface EmployerDAO {
    /**
     * Передает полный массив обьектов {@link Employer}
     * @return полный массив обьектов {@link Employer}
     */
    ArrayList<Employer> getAll();

    /**
     * Обьеденят десериализованные обьект в единый список
     * @return полный массив обьектов {@link Employer}
     */
    Employer getById(Integer id);

    /**
     * Замещает обьект с идентификатором id на обьект employer
     * @param id идентификатор замещаемого обьекта
     * @param employer новаый обьект
     * @return номер обьекта в списке или 0 если обьекта с идентификатором id  не существует
     */
    int update(Integer id, Employer employer);

    /**
     * Удаляет обьект с идентификатором id 
     * @param id идентификатор удаляемого обьекта
     * @return true если удаление прошло успешно иначе false
     */
    boolean deleteById(Integer id);

    /**
     * Добавляет новый обьект(employer) в базу данных
     * @param employer новый обьект
     * @return true если добавление прошло успешно иначе false
     */
    boolean create(Employer employer);
}
