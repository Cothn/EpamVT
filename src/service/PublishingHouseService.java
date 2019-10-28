package service;

import beans.PublishingHouse;

import java.util.ArrayList;

public interface PublishingHouseService {
    PublishingHouse getPublishingHouse(Integer id);

    void addPublishingHouse(PublishingHouse publishingHouse);

    ArrayList<PublishingHouse> getAllPublishingHouse();

    void update(Integer id, PublishingHouse publishingHouse);


    void deletePublishingHouseById(Integer id);

    ArrayList<PublishingHouse> sortByTitle(boolean ascending);


     ArrayList<PublishingHouse> findByTitle(String title);



}
