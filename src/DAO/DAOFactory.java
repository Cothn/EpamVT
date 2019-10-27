package DAO;

public class DAOFactory {
    private static final LibraryDAO libraryDAO = new LibraryDAOFileImpl();
    // private static final AuthorDAO authorDAO = new AuthorDAOFileImpl();
    //  private static final EmployerDAO employerDAO = new EmployerDAOFileImpl();
    // private static final LibraryCardDAO libraryCardDAO = new LibraryCardDAOFileImpl();

    public  static LibraryDAO getLibraryDAO()
    {
        return libraryDAO;
    }

/*
    public static AuthorDAO getAuthorDAO() {
        return authorDAO;
    }

    public static EmployerDAO getEmployerDAO() {
        return employerDAO;
    }

    public static LibraryCardDAO getLibraryCardDAO() {
        return libraryCardDAO;
    }*/
}
