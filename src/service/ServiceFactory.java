package service;

import service.impl.AuthorServiceImpl;
import service.impl.EmployerServiceImpl;
import service.impl.LibraryCardServiceImpl;
import service.impl.LibraryServiceImpl;

public class ServiceFactory {
    private static final LibraryService libraryService = new LibraryServiceImpl();
   // private static final AuthorService authorService = new AuthorServiceImpl();
  //  private static final EmployerService employerService = new EmployerServiceImpl();
   // private static final LibraryCardService libraryCardService = new LibraryCardServiceImpl();

    public  static LibraryService getLibraryService()
    {
        return libraryService;
    }

/*
    public static AuthorService getAuthorService() {
        return authorService;
    }

    public static EmployerService getEmployerService() {
        return employerService;
    }

    public static LibraryCardService getLibraryCardService() {
        return libraryCardService;
    }*/
}
