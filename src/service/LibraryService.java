package service;

import beans.LibraryObj;

import java.util.ArrayList;

public interface LibraryService {
    LibraryObj getLibraryObj(Integer Id);
    void addLibraryObj(LibraryObj LibraryObj);
    ArrayList<LibraryObj> getAllLibraryObj();
    void update(Integer id,LibraryObj LibraryObj);
    void deleteLibraryObj(LibraryObj LibraryObj);
    void deleteLibraryObjById(Integer id);
    ArrayList<LibraryObj> sortByPageNum();
    ArrayList<LibraryObj> sortByAuthor();
    ArrayList<LibraryObj> findByName(String name);
}
