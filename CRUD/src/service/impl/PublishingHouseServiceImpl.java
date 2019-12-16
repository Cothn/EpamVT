/*
 * Всеволод Гринчик 751003 (HRYNCHYK USEVALAD)
 * CRUD VT 2019
 */
package service.impl;

import DAO.DAOFactory;
import DAO.DaoException;
import beans.PublishingHouse;
import service.PublishingHouseService;
import service.ServiceException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Хранит методы работы c обьектами {@link PublishingHouse}
 */
public class PublishingHouseServiceImpl  implements PublishingHouseService {

    /**
     * Передает обьект по его идентификатору, обращается к DAO
     * @param id идентификатор обьекта
     * @return найденный обьект или null
     */
    public PublishingHouse getPublishingHouse(Integer id) {
        return DAOFactory.getPublishingHouseDAO().getById(id);
    }

    /**
     * Добавляет новый обьект(publishingHouse) в базу данных через DAO
     * @param publishingHouse новый обьект
     */
    public void addPublishingHouse(PublishingHouse publishingHouse) {
        DAOFactory.getPublishingHouseDAO().create(publishingHouse);
    }

    /**
     * Извлекает полный массив обьектов {@link PublishingHouse} через DAO
     * @return полный массив обьектов {@link PublishingHouse}
     */
    public List<PublishingHouse> getAllPublishingHouse() throws ServiceException{
        try {
            return DAOFactory.getPublishingHouseDAO().getAll();
        }
        catch (DaoException e)
        {
            throw new ServiceException(e);
        }
    }

    /**
     * Замещает обьект с идентификатором id на обьект publishingHouse черз DAO
     * @param id идентификатор замещаемого обьекта
     * @param publishingHouse новаый обьект
     */
    public void update(Integer id, PublishingHouse publishingHouse) {
        DAOFactory.getPublishingHouseDAO().update(id,publishingHouse);
    }

    /**
     * Удаляет обьект с идентификатором id через DAO
     * @param id идентификатор удаляемого обьекта
     */
    public void deletePublishingHouseById(Integer id) {

        DAOFactory.getPublishingHouseDAO().deleteById(id);
    }

    /**
     * Сортирует все обьекты по названию
     * @param ascending вид сортировки (если true то по возрастанию)
     * @return отссортированный массив
     */
    public List<PublishingHouse> sortByTitle(boolean ascending)throws ServiceException
    {
        try {
            ArrayList<PublishingHouse> all = (ArrayList<PublishingHouse>) DAOFactory.getPublishingHouseDAO().getAll();
            all.sort(new PublishingHouseTitleComparator());
            if (!ascending) {
                Collections.reverse(all);
            }
            return all;
        }
        catch (DaoException e)
        {
            throw new ServiceException(e);
        }
    }

    /**
     * Ищет обьект по названию
     * @param title название издательства
     * @return массив подходящих обьектов
     */
    public List<PublishingHouse> findByTitle(String title) throws ServiceException {
        try {
            ArrayList<PublishingHouse> allPublishingHouse = (ArrayList<PublishingHouse>) DAOFactory.getPublishingHouseDAO().getAll();
            ArrayList<PublishingHouse> findPublishingHouse = new ArrayList<>();
            for (PublishingHouse publishingHouse : allPublishingHouse) {
                if (publishingHouse.getTitle().equals(title))
                    findPublishingHouse.add(publishingHouse);
            }

            return findPublishingHouse;
        }
        catch (DaoException e)
        {
            throw new ServiceException(e);
        }
    }

    private static class PublishingHouseTitleComparator implements Comparator<PublishingHouse> {

        public int compare(PublishingHouse f, PublishingHouse t){
            return   f.getTitle().compareTo(t.getTitle());
        }
    }

}
