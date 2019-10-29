/*
 * Всеволод Гринчик 751003 (HRYNCHYK USEVALAD)
 * CRUD VT 2019
 */
package DAO;

import beans.LibraryObj;

import java.util.ArrayList;

/**
 * Интерфейс доступа к базе даных хранящей обьекты {@link LibraryObj}
 */
public interface LibraryDAO {
    /**
     * Передает полный массив обьектов {@link LibraryObj}
     * @return полный массив обьектов {@link LibraryObj}
     */
    ArrayList<LibraryObj> getAll();

    /**
     * Обьеденят десериализованные обьект в единый список
     * @return полный массив обьектов {@link LibraryObj}
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
}
