package service;


import service.impl.AuthorServiceImpl;
import service.impl.EmployerServiceImpl;
import service.impl.LibraryServiceImpl;
import service.impl.PublishingHouseServiceImpl;

/**
 * Содержит методы получения конкреттных реализаций бизнес логики через интерфейсы
 */
public class ServiceFactory {
    /** текущая реализация {@link LibraryService} */
    private static final LibraryService libraryService = new LibraryServiceImpl();

    /** текущая реализация {@link AuthorService} */
    private static final AuthorService authorService = new AuthorServiceImpl();

    /** текущая реализация {@link EmployerService} */
    private static final EmployerService employerService = new EmployerServiceImpl();

    /** текущая реализация {@link PublishingHouseService} */
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
