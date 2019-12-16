/*
 * Всеволод Гринчик 751003 (HRYNCHYK USEVALAD)
 * CRUD VT 2019
 */
package DAO;

import DAO.TextFile_impl.AuthorDAOFileImpl;
import DAO.TextFile_impl.EmployerDAOFileImpl;
import DAO.TextFile_impl.LibraryDAOFileImpl;
import DAO.TextFile_impl.PublishingHouseDAOFileImpl;
import DAO.xml_dom_impl.PublHouseDAO_Dom_Impl;
import DAO.xml_sax_impl.EmployerDAO_Sax_Impl;
import DAO.xml_sax_impl.LibraryDAO_Sax_Impl;
import DAO.xml_stax_impl.AuthorDAO_Stax_Impl;

/**
 * Содержит методы получения конкреттных DAO через итерфейс
 */
public class DAOFactory {
    /*  /** текущая реализация {@link LibraryDAO} */
    /*private static final LibraryDAO libraryDAO = new LibraryDAOFileImpl();
    /** текущая реализация {@link AuthorDAO} */
    /*private static final AuthorDAO authorDAO = new AuthorDAOFileImpl();
    /** текущая реализация {@link PublishingHouseDAO} */
   /* private static final PublishingHouseDAO publishingHouseDAO = new PublishingHouseDAOFileImpl();
    /** текущая реализация {@link EmployerDAO} */
    /* private static final EmployerDAO employerDAO = new EmployerDAOFileImpl();*/

    /** текущая реализация {@link LibraryDAO} */
    private static final LibraryDAO libraryDAO = new LibraryDAO_Sax_Impl();
    /** текущая реализация {@link AuthorDAO} */
    private static final AuthorDAO authorDAO = new AuthorDAO_Stax_Impl();
    /** текущая реализация {@link PublishingHouseDAO} */
    private static final PublishingHouseDAO publishingHouseDAO = new PublHouseDAO_Dom_Impl();
    /** текущая реализация {@link EmployerDAO} */
    private static final EmployerDAO employerDAO = new EmployerDAO_Sax_Impl();

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
