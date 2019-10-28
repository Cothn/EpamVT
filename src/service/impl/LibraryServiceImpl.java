package service.impl;

import DAO.DAOFactory;
import DAO.LibraryDAO;
import beans.LibraryObj;
import service.LibraryService;

import java.util.ArrayList;
import java.util.Comparator;

public class LibraryServiceImpl implements LibraryService {
    @Override
    public LibraryObj getLibraryObj(Integer id) {
        return DAOFactory.getLibraryDAO().getById(id);
    }
    @Override
    public void addLibraryObj(LibraryObj LibraryObj) {
        DAOFactory.getLibraryDAO().create(LibraryObj);
    }
    @Override
    public ArrayList<LibraryObj> getAllLibraryObj() {

        return DAOFactory.getLibraryDAO().getAll();
    }
    @Override
    public void update(Integer id, LibraryObj LibraryObj) {
        DAOFactory.getLibraryDAO().update(id,LibraryObj);
    }
    @Override
    public void deleteLibraryObj(LibraryObj LibraryObj) {

        DAOFactory.getLibraryDAO().delete(LibraryObj);
    }
    @Override
    public void deleteLibraryObjById(Integer id) {

        DAOFactory.getLibraryDAO().deleteById(id);
    }
    @Override
    public ArrayList<LibraryObj> sortByPagesNum()
    {
        ArrayList<LibraryObj> libraryObj =  DAOFactory.getLibraryDAO().getAll();
        libraryObj.sort(new LibraryObjPageComparator());
        return libraryObj;
    }
    @Override
    public ArrayList<LibraryObj> sortByTitle()
    {
        ArrayList<LibraryObj> allLibraryObj =  DAOFactory.getLibraryDAO().getAll();
        allLibraryObj.sort(new LibraryObjTitleComparator());
        return allLibraryObj;
    }

    @Override
    public ArrayList<LibraryObj> findByAuthor(int authorId) {

        ArrayList<LibraryObj> allLibraryObj =  DAOFactory.getLibraryDAO().getAll();
        ArrayList<LibraryObj> findLibraryObj = new ArrayList<>();
        for (LibraryObj LibraryObj:allLibraryObj)
        {
            if(LibraryObj.getAuthorId() == authorId)
                findLibraryObj.add(LibraryObj);
        }

        return findLibraryObj;
    }

    class LibraryObjPageComparator implements Comparator<LibraryObj> {

        public int compare(LibraryObj f, LibraryObj t){

            if(f.getPagesNum()> t.getPagesNum())
                return 1;
            else if(f.getPagesNum()< t.getPagesNum())
                return -1;
            else
                return 0;
        }
    }

    class LibraryObjTitleComparator implements Comparator<LibraryObj>{

        public int compare(LibraryObj f, LibraryObj t){

            return f.getTitle().compareTo(t.getTitle());
        }
    }
}
