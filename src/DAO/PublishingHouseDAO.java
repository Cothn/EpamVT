package DAO;

import beans.PublishingHouse;

import java.util.ArrayList;

public interface PublishingHouseDAO {
    ArrayList<PublishingHouse> getAll();

    PublishingHouse getById(Integer id);

    int update(Integer id,PublishingHouse publishingHouse);

    boolean deleteById(Integer id);

    boolean delete(PublishingHouse publishingHouse);

    boolean create(PublishingHouse newPublishingHouse);
}
