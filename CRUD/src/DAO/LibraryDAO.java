/*
 * Всеволод Гринчик 751003 (HRYNCHYK USEVALAD)
 * CRUD VT 2019
 */
package DAO;

import beans.LibraryObj;

import java.util.ArrayList;
import java.util.List;

/**
 * Интерфейс доступа к базе даных хранящей обьекты {@link LibraryObj}
 */
public interface LibraryDAO {
    /**
     * Передает полный массив обьектов {@link LibraryObj}
     * @return полный массив обьектов {@link LibraryObj}
     */
    List<LibraryObj> getAll() throws DaoException;

    /**
     * Ищет обьект по его идентификатору
     * @param id идентификатор обьекта
     * @return найденный обьект или null
     */
    LibraryObj getById(Integer id);

    /**
     * Замещает обьект с идентификатором id на обьект libraryObj
     * @param id идентификатор замещаемого обьекта
     * @param LibraryObj новаый обьект
     * @return номер обьекта в списке или 0 если обьекта с идентификатором id  не существует
     */
    int update(Integer id, LibraryObj LibraryObj);

    /**
     * Удаляет обьект с идентификатором id 
     * @param id идентификатор удаляемого обьекта
     * @return true если удаление прошло успешно иначе false
     */
    boolean deleteById(Integer id);

    /**
     * Добавляет новый обьект(newLibraryObj) в базу данных
     * @param newLibraryObj новый обьект
     * @return true если добавление прошло успешно иначе false
     */
    boolean create(LibraryObj newLibraryObj);

    /**
     * Добавляет новые обьекты(newLibraryObjs) в базу данных
     * @param newLibraryObjs новые обьекты
     * @return true если добавление прошло успешно иначе false
     */
    boolean addLibraryObjs(List<LibraryObj> newLibraryObjs)throws DaoException;
}
