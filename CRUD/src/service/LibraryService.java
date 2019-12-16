/*
 * Всеволод Гринчик 751003 (HRYNCHYK USEVALAD)
 * CRUD VT 2019
 */
package service;

import beans.LibraryObj;

import java.util.List;

/**
 * Интерфейс доступа к бизнес логике обьекта {@link LibraryObj}
 */
public interface LibraryService {

    /**
     * Передает обьект по его идентификатору, обращается к DAO
     * @param Id идентификатор обьекта
     * @return найденный обьект или null
     */
    LibraryObj getLibraryObj(Integer Id);

    /**
     * Добавляет новый обьект(author) в базу данных через DAO
     * @param LibraryObj новый обьект
     */
    void addLibraryObj(LibraryObj LibraryObj);

    /**
     * Извлекает полный массив обьектов {@link LibraryObj} через DAO
     * @return полный массив обьектов {@link LibraryObj}
     */
    List<LibraryObj> getAllLibraryObj() throws ServiceException;

    /**
     * Замещает обьект с идентификатором id на обьект LibraryObj черз DAO
     * @param id идентификатор замещаемого обьекта
     * @param LibraryObj новаый обьект
     */
    void update(Integer id,LibraryObj LibraryObj);

    /**
     * Удаляет обьект с идентификатором id через DAO
     * @param id идентификатор удаляемого обьекта
     */
    void deleteLibraryObjById(Integer id);
   // List<LibraryObj> sortByPagesNum();
    /**
     * Сортирует все обьекты по названию
     * @param ascending вид сортировки (если true то по возрастанию)
     * @return отссортированный массив
     */
    List<LibraryObj> sortByTitle(boolean ascending)throws ServiceException;

    /**
     * Ищет обьект по имени
     * @param authorId идентификатор автора
     * @return массив подходящих обьектов
     */
    List<LibraryObj> findByAuthor(int authorId)throws ServiceException;

    /**
     * Ищет обьект по имени
     * @param publishingHouseId идентификатор издательства
     * @return массив подходящих обьектов
     */
    List<LibraryObj> findByPublishingHouse(int publishingHouseId) throws ServiceException;
}
