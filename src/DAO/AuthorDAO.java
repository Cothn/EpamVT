package DAO;

import beans.Author;

import java.util.ArrayList;

public interface AuthorDAO {
    ArrayList<Author> getAll();
    Author getById(Integer id);
    int update(Integer id, Author author);
    boolean deleteById(Integer id);
    boolean delete(Author author);
    boolean create(Author newAuthor);
}
