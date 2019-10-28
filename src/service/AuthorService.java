package service;

import beans.Author;

import java.util.ArrayList;

public interface AuthorService {
    Author getAuthor(Integer id);
    void addAuthor(Author author) ;
    ArrayList<Author> getAllAuthor() ;
     void update(Integer id, Author author) ;
    public void deleteAuthorById(Integer id);
    public ArrayList<Author> sortByName(boolean ascending);
    public ArrayList<Author> findByName(String name);



}
