package DAO;

import DAO.impl.AuthorDAOFileImpl;
import DAO.impl.EmployerDAOFileImpl;
import DAO.impl.LibraryDAOFileImpl;
import DAO.impl.PublishingHouseDAOFileImpl;

public class DAOFactory {
    private static final LibraryDAO libraryDAO = new LibraryDAOFileImpl();
    private static final AuthorDAO authorDAO = new AuthorDAOFileImpl();
    private static final PublishingHouseDAO publishingHouseDAO = new PublishingHouseDAOFileImpl();
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
