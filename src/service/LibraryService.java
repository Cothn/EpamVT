package service;

import beans.LibraryObj;

import java.util.ArrayList;

/**
 * Интерфейс доступа к бизнес логике обьекта {@link LibraryObj}
 */
public interface LibraryService {

    /**
     * Передает обьект по его идентификатору, обращается к DAO
     * @param iD идентификатор обьекта
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
    ArrayList<LibraryObj> getAllLibraryObj();

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
   // ArrayList<LibraryObj> sortByPagesNum();
    /**
     * Сортирует все обьекты по названию
     * @param ascending вид сортировки (если true то по возрастанию)
     * @return отссортированный массив
     */
    ArrayList<LibraryObj> sortByTitle(boolean ascending);

    /**
     * Ищет обьект по имени
     * @param authorId идентификатор автора
     * @return массив подходящих обьектов
     */
    ArrayList<LibraryObj> findByAuthor(int authorId);

    /**
     * Ищет обьект по имени
     * @param publishingHouseId идентификатор издательства
     * @return массив подходящих обьектов
     */
    ArrayList<LibraryObj> findByPublishingHouse(int publishingHouseId);
}
