package service.impl;

import DAO.DAOFactory;
import beans.Employer;
import service.EmployerService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EmployerServiceImpl implements EmployerService {

    public Employer getEmployer(Integer id) {
        return DAOFactory.getEmployerDAO().getById(id);
    }

    public void addEmployer(Employer employer) {
        DAOFactory.getEmployerDAO().create(employer);
    }

    public ArrayList<Employer> getAllEmployer() {

        return DAOFactory.getEmployerDAO().getAll();
    }

    public void update(Integer id, Employer employer) {
        DAOFactory.getEmployerDAO().update(id,employer);
    }

    public void deleteEmployer(Employer employer) {

        DAOFactory.getEmployerDAO().delete(employer);
    }

    public void deleteEmployerById(Integer id) {

        DAOFactory.getEmployerDAO().deleteById(id);
    }

    public ArrayList<Employer> sortByName(boolean ascending)
    {
        ArrayList<Employer> libraryObj =  DAOFactory.getEmployerDAO().getAll();
        libraryObj.sort(new EmployerNameComparator());
        if (!ascending)
        {
            Collections.reverse(libraryObj);
        }
        return libraryObj;
    }


    public ArrayList<Employer> findByPosition(String position) {

        ArrayList<Employer> allEmployer =  DAOFactory.getEmployerDAO().getAll();
        ArrayList<Employer> findEmployer = new ArrayList<>();
        for (Employer employer:allEmployer)
        {
            if(employer.getPosition().equals(position))
                findEmployer.add(employer);
        }

        return findEmployer;
    }

    class EmployerNameComparator implements Comparator<Employer> {

        public int compare(Employer f, Employer t){
            int result =  f.getName().compareTo(t.getName());
            if (result == 0)
            {
                result =  f.getSurname().compareTo(t.getSurname());
            }
            return result;
        }
    }

}
