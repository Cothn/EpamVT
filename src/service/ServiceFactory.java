package service;


import service.impl.AuthorServiceImpl;
import service.impl.EmployerServiceImpl;
import service.impl.LibraryServiceImpl;
import service.impl.PublishingHouseServiceImpl;

public class ServiceFactory {
    private static final LibraryService libraryService = new LibraryServiceImpl();
    private static final AuthorService authorService = new AuthorServiceImpl();
    private static final EmployerService employerService = new EmployerServiceImpl();
    private static final PublishingHouseService publishingHouseService = new PublishingHouseServiceImpl();

    public  static LibraryService getLibraryService()
    {
        return libraryService;
    }


    public static AuthorService getAuthorService() {
        return authorService;
    }

    public static EmployerService getEmployerService() {
        return employerService;
    }
    public static PublishingHouseService getPublishingHouseService() {
        return publishingHouseService;
    }

}
