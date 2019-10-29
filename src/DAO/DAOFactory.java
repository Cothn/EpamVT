/*
 * Всеволод Гринчик 751003 (HRYNCHYK USEVALAD)
 * CRUD VT 2019
 */
package DAO;

import DAO.impl.AuthorDAOFileImpl;
import DAO.impl.EmployerDAOFileImpl;
import DAO.impl.LibraryDAOFileImpl;
import DAO.impl.PublishingHouseDAOFileImpl;

/**
 * Содержит методы получения конкреттных DAO через итерфейс
 */
public class DAOFactory {
    /** текущая реализация {@link LibraryDAO} */
    private static final LibraryDAO libraryDAO = new LibraryDAOFileImpl();
    /** текущая реализация {@link AuthorDAO} */
    private static final AuthorDAO authorDAO = new AuthorDAOFileImpl();
    /** текущая реализация {@link PublishingHouseDAO} */
    private static final PublishingHouseDAO publishingHouseDAO = new PublishingHouseDAOFileImpl();
    /** текущая реализация {@link EmployerDAO} */
    private static final EmployerDAO employerDAO = new EmployerDAOFileImpl();

    public  static LibraryDAO getLibraryDAO()
    {
        return libraryDAO;
    }
    public static AuthorDAO getAuthorDAO() {
        return authorDAO;
    }
    public static PublishingHouseDAO getPublishingHouseDAO () {
        return publishingHouseDAO ;
    }
    public static EmployerDAO getEmployerDAO() {
        return employerDAO;
    }


}
