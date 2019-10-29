/*
 * Всеволод Гринчик 751003 (HRYNCHYK USEVALAD)
 * CRUD VT 2019
 */
package service.impl;

import DAO.DAOFactory;
import beans.LibraryObj;
import service.LibraryService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Хранит методы работы c обьектами {@link LibraryObj}
 */
public class LibraryServiceImpl implements LibraryService {

    /**
     * Передает обьект по его идентификатору, обращается к DAO
     * @param id идентификатор обьекта
     * @return найденный обьект или null
     */
    @Override
    public LibraryObj getLibraryObj(Integer id) {
        return DAOFactory.getLibraryDAO().getById(id);
    }

    /**
     * Добавляет новый обьект(author) в базу данных через DAO
     * @param LibraryObj новый обьект
     */
    @Override
    public void addLibraryObj(LibraryObj LibraryObj) {
        DAOFactory.getLibraryDAO().create(LibraryObj);
    }

    /**
     * Извлекает полный массив обьектов {@link LibraryObj} через DAO
     * @return полный массив обьектов {@link LibraryObj}
     */
    @Override
    public List<LibraryObj> getAllLibraryObj() {

        return DAOFactory.getLibraryDAO().getAll();
    }

    /**
     * Замещает обьект с идентификатором id на обьект LibraryObj черз DAO
     * @param id идентификатор замещаемого обьекта
     * @param LibraryObj новаый обьект
     */
    @Override
    public void update(Integer id, LibraryObj LibraryObj) {
        DAOFactory.getLibraryDAO().update(id,LibraryObj);
    }

    /**
     * Удаляет обьект с идентификатором id через DAO
     * @param id идентификатор удаляемого обьекта
     */
    @Override
    public void deleteLibraryObjById(Integer id) {

        DAOFactory.getLibraryDAO().deleteById(id);
    }

    /*@Override
    public ArrayList<LibraryObj> sortByPagesNum()
    {
        ArrayList<LibraryObj> libraryObj =  DAOFactory.getLibraryDAO().getAll();
        libraryObj.sort(new LibraryObjPageComparator());
        return libraryObj;
    }*/

    /**
     * Сортирует все обьекты по названию
     * @param ascending вид сортировки (если true то по возрастанию)
     * @return отссортированный массив
     */
    @Override
    public List<LibraryObj> sortByTitle(boolean ascending)
    {
        ArrayList<LibraryObj> allLibraryObj =  (ArrayList<LibraryObj>)DAOFactory.getLibraryDAO().getAll();
        allLibraryObj.sort(new LibraryObjTitleComparator());
        if (!ascending)
        {
            Collections.reverse(allLibraryObj);
        }
        return allLibraryObj;
    }

    /**
     * Ищет обьект по имени
     * @param authorId идентификатор автора
     * @return массив подходящих обьектов
     */
    @Override
    public List<LibraryObj> findByAuthor(int authorId) {

        ArrayList<LibraryObj> allLibraryObj =  (ArrayList<LibraryObj>)DAOFactory.getLibraryDAO().getAll();
        ArrayList<LibraryObj> findLibraryObj = new ArrayList<>();
        for (LibraryObj libraryObj:allLibraryObj)
        {
            if(libraryObj.getAuthorId() == authorId)
                findLibraryObj.add(libraryObj);
        }

        return findLibraryObj;
    }

    /**
     * Ищет обьект по имени
     * @param publishingHouseId идентификатор издательства
     * @return массив подходящих обьектов
     */
    @Override
    public List<LibraryObj> findByPublishingHouse(int publishingHouseId) {

        ArrayList<LibraryObj> allLibraryObj =  (ArrayList<LibraryObj>)DAOFactory.getLibraryDAO().getAll();
        ArrayList<LibraryObj> findLibraryObj = new ArrayList<>();
        for (LibraryObj libraryObj:allLibraryObj)
        {
            if(libraryObj.getPublishingHouseId() == publishingHouseId)
                findLibraryObj.add(libraryObj);
        }

        return findLibraryObj;
    }

    /*class LibraryObjPageComparator implements Comparator<LibraryObj> {

        public int compare(LibraryObj f, LibraryObj t){

            if(f.getPagesNum()> t.getPagesNum())
                return 1;
            else if(f.getPagesNum()< t.getPagesNum())
                return -1;
            else
                return 0;
        }
    }
*/
    private static class LibraryObjTitleComparator implements Comparator<LibraryObj>{

        public int compare(LibraryObj f, LibraryObj t){

            return f.getTitle().compareTo(t.getTitle());
        }
    }
}
