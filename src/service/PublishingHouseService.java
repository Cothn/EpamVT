package service;

import beans.PublishingHouse;

import java.util.ArrayList;

/**
 * Интерфейс доступа к бизнес логике обьекта {@link PublishingHouse}
 */
public interface PublishingHouseService {

    /**
     * Передает обьект по его идентификатору
     * @param id идентификатор обьекта
     * @return найденный обьект или null
     */
    PublishingHouse getPublishingHouse(Integer id);

    /**
     * Добавляет новый обьект(publishingHouse) в базу данных
     * @param publishingHouse новый обьект
     */
    void addPublishingHouse(PublishingHouse publishingHouse);

    /**
     * Извлекает полный массив обьектов {@link PublishingHouse}
     * @return полный массив обьектов {@link PublishingHouse}
     */
    ArrayList<PublishingHouse> getAllPublishingHouse();

    /**
     * Замещает обьект с идентификатором id на обьект publishingHouse черз DAO
     * @param id идентификатор замещаемого обьекта
     * @param publishingHouse новаый обьект
     */
    void update(Integer id, PublishingHouse publishingHouse);

    /**
     * Удаляет обьект с идентификатором id через DAO
     * @param id идентификатор удаляемого обьекта
     */
    void deletePublishingHouseById(Integer id);

    /**
     * Сортирует все обьекты по названию
     * @param ascending вид сортировки (если true то по возрастанию)
     * @return отссортированный массив
     */
    ArrayList<PublishingHouse> sortByTitle(boolean ascending);

    /**
     * Ищет обьект по названию
     * @param title название издательства
     * @return массив подходящих обьектов
     */
    ArrayList<PublishingHouse> findByTitle(String title);



}
