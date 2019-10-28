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
    ArrayList<LibraryObj> sortByPagesNum();
    ArrayList<LibraryObj> sortByTitle();
    ArrayList<LibraryObj> findByAuthor(int authorId);
}
