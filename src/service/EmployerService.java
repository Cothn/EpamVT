package service;

import beans.Employer;

import java.util.ArrayList;

public interface EmployerService {
    Employer getEmployer(Integer id);
    void addEmployer(Employer author) ;
    ArrayList<Employer> getAllEmployer() ;
    void update(Integer id, Employer employer) ;
    void deleteEmployerById(Integer id);
    ArrayList<Employer> sortByName(boolean ascending);
    ArrayList<Employer> findByPosition(String position);
}
