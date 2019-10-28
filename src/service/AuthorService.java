package service;

import beans.Author;

import java.util.ArrayList;

public interface AuthorService {
    Author getAuthor(Integer id);
    void addAuthor(Author author) ;
    ArrayList<Author> getAllAuthor() ;
    void update(Integer id, Author author) ;
    void deleteAuthorById(Integer id);
    ArrayList<Author> sortByName(boolean ascending);
    ArrayList<Author> findByName(String name);

}
