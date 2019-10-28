package service.impl;

import DAO.DAOFactory;
import beans.Author;
import service.AuthorService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AuthorServiceImpl implements AuthorService {

    public Author getAuthor(Integer id) {
        return DAOFactory.getAuthorDAO().getById(id);
    }

    public void addAuthor(Author author) {
        DAOFactory.getAuthorDAO().create(author);
    }

    public ArrayList<Author> getAllAuthor() {

        return DAOFactory.getAuthorDAO().getAll();
    }

    public void update(Integer id, Author author) {
        DAOFactory.getAuthorDAO().update(id,author);
    }


    public void deleteAuthorById(Integer id) {

        DAOFactory.getAuthorDAO().deleteById(id);
    }

    public ArrayList<Author> sortByName(boolean ascending)
    {

        ArrayList<Author> libraryObj =  DAOFactory.getAuthorDAO().getAll();
        libraryObj.sort(new AuthorNameComparator());

        if (!ascending)
        {
            Collections.reverse(libraryObj);
        }
        return libraryObj;
    }


    public ArrayList<Author> findByName(String name) {

        ArrayList<Author> allAuthor =  DAOFactory.getAuthorDAO().getAll();
        ArrayList<Author> findAuthor = new ArrayList<>();
        for (Author author:allAuthor)
        {
            if(author.getName().equals(name))
                findAuthor.add(author);
        }

        return findAuthor;
    }

    class AuthorNameComparator implements Comparator<Author> {

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
