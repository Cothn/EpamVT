package service;

import DAO.*;
//import DAO.BD_impl.AuthorDAO_SQLImpl;
//import DAO.BD_impl.EmployerDAO_SQLImpl;
//import DAO.BD_impl.LibraryDAO_SQLImpl;
//import DAO.BD_impl.PublishingHouseDAO_SQLImpl;
import DAO.xml_dom_impl.AuthorDAO_Dom_Impl;
import DAO.xml_dom_impl.EmployerDAO_Dom_Impl;
import DAO.xml_dom_impl.LibraryDAO_Dom_Impl;
import DAO.xml_dom_impl.PublHouseDAO_Dom_Impl;

import beans.Author;
import beans.Employer;
import beans.LibraryObj;
import beans.PublishingHouse;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.List;


public class MigrationService {

    public static final Logger LOG = Logger.getLogger( MigrationService.class.getName());

    public static void MigrateAll() throws ServiceException
    {

        try {

            LOG.log(Level.INFO,"Start authors migration");
            //AuthorDAO authorDao = new AuthorDAO_Sax_Impl();
            //AuthorDAO authorDao = new AuthorDAO_Stax_Impl();
            AuthorDAO authorDao = new AuthorDAO_Dom_Impl();
            LOG.log(Level.INFO,"Begin XML authors parse");
            List<Author> authors = authorDao.getAll();
           // authorDao = new AuthorDAO_SQLImpl();
            LOG.log(Level.INFO,"Begin SQL authors write");
            authorDao.addAuthors(authors);
            LOG.log(Level.INFO,"End authors migration");

            LOG.log(Level.INFO,"Begin employers migration");
            //EmployerDAO employerDao = new EmployerDAO_Sax_Impl();
            //EmployerDAO employerDao = new EmployerDAO_Stax_Impl();
            EmployerDAO employerDao = new EmployerDAO_Dom_Impl();
            LOG.log(Level.INFO,"Begin XML employers parse");
            List<Employer> employers = employerDao.getAll();
           // employerDao = new EmployerDAO_SQLImpl();
            LOG.log(Level.INFO,"Begin SQL employers write");
            employerDao .addEmployers(employers);
            LOG.log(Level.INFO,"End employers migration");

            LOG.log(Level.INFO,"Begin library migration");
            //LibraryDAO libraryDao = new LibraryDAO_Sax_Impl();
            //LibraryDAO libraryDao = new LibraryDAO_Stax_Impl();
            LibraryDAO libraryDao = new LibraryDAO_Dom_Impl();
            LOG.log(Level.INFO,"Begin XML library parse");
            List<LibraryObj> library = libraryDao.getAll();
           // libraryDao = new LibraryDAO_SQLImpl();
            LOG.log(Level.INFO,"Begin SQL library write");
            libraryDao.addLibraryObjs(library);
            LOG.log(Level.INFO,"End library migration");

            LOG.log(Level.INFO,"Begin publishingHouses migration");
           //PublishingHouseDAO publhouseDao = new PublHouseDAO_Sax_Impl();
            //PublishingHouseDAO publhouseDao = new PublHouseDAO_Stax_Impl();
            PublishingHouseDAO publhouseDao = new PublHouseDAO_Dom_Impl();
            LOG.log(Level.INFO,"Begin XML publishingHouses parse");
            List<PublishingHouse> publhouses = publhouseDao.getAll();
            //publhouseDao = new PublishingHouseDAO_SQLImpl();
            LOG.log(Level.INFO,"Begin SQL publishingHouses write");
            publhouseDao.addPublishingHouses(publhouses);
            LOG.log(Level.INFO,"End publishingHouses migration");
        }
        catch (DaoException e)
        {
            LOG.log(Level.ERROR,e.getMessage());
            throw new ServiceException(e);
        }
    }
}
