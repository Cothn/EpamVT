package service;

import beans.LibraryObj;

import java.util.ArrayList;

public interface LibraryService {
    LibraryObj getLibraryObj(Integer Id);
    void addLibraryObj(LibraryObj LibraryObj);
    ArrayList<LibraryObj> getAllLibraryObj();
    void update(Integer id,LibraryObj LibraryObj);
    void deleteLibraryObjById(Integer id);
   // ArrayList<LibraryObj> sortByPagesNum();
    ArrayList<LibraryObj> sortByTitle(boolean ascending);
    ArrayList<LibraryObj> findByAuthor(int authorId);
    ArrayList<LibraryObj> findByPublishingHouse(int publishingHouseId);
}
