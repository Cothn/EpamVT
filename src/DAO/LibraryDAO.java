package DAO;

import beans.LibraryObj;

import java.util.ArrayList;

public interface LibraryDAO {

    ArrayList<LibraryObj> getAll();

    LibraryObj getById(Integer id);

    int update(Integer id, LibraryObj LibraryObj);

    boolean deleteById(Integer id);

    boolean delete(LibraryObj LibraryObj);

    boolean create(LibraryObj newLibraryObj);
}
