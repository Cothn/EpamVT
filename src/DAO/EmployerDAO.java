package DAO;

import beans.Employer;

import java.util.ArrayList;

public interface EmployerDAO {
    ArrayList<Employer> getAll();
    Employer getById(Integer id);
    int update(Integer id, Employer employer);
    boolean deleteById(Integer id);
    boolean delete(Employer employer);
    boolean create(Employer employer);
}
