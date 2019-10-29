/*
 * Всеволод Гринчик 751003 (HRYNCHYK USEVALAD)
 * CRUD VT 2019
 */
package DAO;

import beans.PublishingHouse;

import java.util.ArrayList;

/**
 * Интерфейс доступа к базе даных хранящей обьекты {@link PublishingHouse}
 */
public interface PublishingHouseDAO {
    /**
     * Передает полный массив обьектов {@link PublishingHouse}
     * @return полный массив обьектов {@link PublishingHouse}
     */
    ArrayList<PublishingHouse> getAll();

    /**
     * Обьеденят десериализованные обьект в единый список
     * @return полный массив обьектов {@link PublishingHouse}
     */
    PublishingHouse getById(Integer id);

    /**
     * Замещает обьект с идентификатором id на обьект publishingHouse
     * @param id идентификатор замещаемого обьекта
     * @param publishingHouse новаый обьект
     * @return номер обьекта в списке или 0 если обьекта с идентификатором id  не существует
     */
    int update(Integer id,PublishingHouse publishingHouse);

    /**
     * Удаляет обьект с идентификатором id 
     * @param id идентификатор удаляемого обьекта
     * @return true если удаление прошло успешно иначе false
     */
    boolean deleteById(Integer id);

    /**
     * Добавляет новый обьект(newPublishingHouse) в базу данных
     * @param newPublishingHouse новый обьект
     * @return true если добавление прошло успешно иначе false
     */
    boolean create(PublishingHouse newPublishingHouse);
}
