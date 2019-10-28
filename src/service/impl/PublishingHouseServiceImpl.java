package service.impl;

import DAO.DAOFactory;
import beans.PublishingHouse;
import service.PublishingHouseService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PublishingHouseServiceImpl  implements PublishingHouseService {
    public PublishingHouse getPublishingHouse(Integer id) {
        return DAOFactory.getPublishingHouseDAO().getById(id);
    }

    public void addPublishingHouse(PublishingHouse publishingHouse) {
        DAOFactory.getPublishingHouseDAO().create(publishingHouse);
    }

    public ArrayList<PublishingHouse> getAllPublishingHouse() {

        return DAOFactory.getPublishingHouseDAO().getAll();
    }

    public void update(Integer id, PublishingHouse publishingHouse) {
        DAOFactory.getPublishingHouseDAO().update(id,publishingHouse);
    }

    public void deletePublishingHouse(PublishingHouse publishingHouse) {

        DAOFactory.getPublishingHouseDAO().delete(publishingHouse);
    }

    public void deletePublishingHouseById(Integer id) {

        DAOFactory.getPublishingHouseDAO().deleteById(id);
    }

    public ArrayList<PublishingHouse> sortByTitle(boolean ascending)
    {
        ArrayList<PublishingHouse> libraryObj =  DAOFactory.getPublishingHouseDAO().getAll();
        libraryObj.sort(new PublishingHouseTitleComparator());
        if (!ascending)
        {
            Collections.reverse(libraryObj);
        }
        return libraryObj;
    }


    public ArrayList<PublishingHouse> findByTitle(String title) {

        ArrayList<PublishingHouse> allPublishingHouse =  DAOFactory.getPublishingHouseDAO().getAll();
        ArrayList<PublishingHouse> findPublishingHouse = new ArrayList<>();
        for (PublishingHouse publishingHouse:allPublishingHouse)
        {
            if(publishingHouse.getTitle().equals(title))
                findPublishingHouse.add(publishingHouse);
        }

        return findPublishingHouse;
    }


    class PublishingHouseTitleComparator implements Comparator<PublishingHouse> {

        public int compare(PublishingHouse f, PublishingHouse t){
            int result =  f.getTitle().compareTo(t.getTitle());
            return result;
        }
    }

}
