/*
 * Всеволод Гринчик 751003 (HRYNCHYK USEVALAD)
 * CRUD VT 2019
 */
package service.impl;

import DAO.DAOFactory;
import beans.Author;
import org.apache.log4j.Level;
import service.AuthorService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import DAO.DaoException;
import service.ServiceException;

/**
 * Хранит методы работы c обьектами {@link Author}
 */
public class AuthorServiceImpl implements AuthorService {

    /**
     * Передает обьект по его идентификатору, обращается к DAO
     * @param id идентификатор обьекта
     * @return найденный обьект или null
     */
    public Author getAuthor(Integer id) {
        return DAOFactory.getAuthorDAO().getById(id);
    }

    /**
     * Добавляет новый обьект(author) в базу данных через DAO
     * @param author новый обьект
     */
    public void addAuthor(Author author) {
        DAOFactory.getAuthorDAO().create(author);
    }

    /**
     * Извлекает полный массив обьектов {@link Author} через DAO
     * @return полный массив обьектов {@link Author}
     */
    public List<Author> getAllAuthor() throws ServiceException {

        try{
            return DAOFactory.getAuthorDAO().getAll();
        }
            catch (DaoException e)
        {
            throw new ServiceException(e);
        }
    }

    /**
     * Замещает обьект с идентификатором id на обьект author черз DAO
     * @param id идентификатор замещаемого обьекта
     * @param author новаый обьект
     */
    public void update(Integer id, Author author) {
        DAOFactory.getAuthorDAO().update(id,author);
    }

    /**
     * Удаляет обьект с идентификатором id через DAO
     * @param id идентификатор удаляемого обьекта
     */
    public void deleteAuthorById(Integer id) {

        DAOFactory.getAuthorDAO().deleteById(id);
    }

    /**
     * Сортирует все обьекты по имени
     * @param ascending вид сортировки (если true то по возрастанию)
     * @return отссортированный массив
     */
    public List<Author> sortByName(boolean ascending) throws ServiceException
    {
        try {
            ArrayList<Author> objs = (ArrayList<Author>) DAOFactory.getAuthorDAO().getAll();
            objs.sort(new AuthorNameComparator());

            if (!ascending) {
                Collections.reverse(objs);
            }
            return objs;
        }
        catch (DaoException e)
        {
            throw new ServiceException(e);
        }
    }

    /**
     * Ищет обьект по имени
     * @param name имя автора
     * @return массив подходящих обьектов
     */
    public List<Author> findByName(String name) throws ServiceException {//return colection
        try {
            ArrayList<Author> allAuthor = (ArrayList<Author>) DAOFactory.getAuthorDAO().getAll();
            ArrayList<Author> findAuthor = new ArrayList<>();
            for (Author author : allAuthor) {
                if (author.getName().equals(name))
                    findAuthor.add(author);
            }

            return findAuthor;
        }
        catch (DaoException e)
        {
            throw new ServiceException(e);
        }
    }

    private static class  AuthorNameComparator implements Comparator<Author> {

        public int compare(Author f, Author t){
            int result =  f.getName().compareTo(t.getName());
            if (result == 0)
            {
                result =  f.getSurname().compareTo(t.getSurname());
            }
            return result;
        }
    }
    
}
