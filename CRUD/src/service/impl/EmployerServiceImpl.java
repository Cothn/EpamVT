/*
 * Всеволод Гринчик 751003 (HRYNCHYK USEVALAD)
 * CRUD VT 2019
 */
package service.impl;

import DAO.DAOFactory;
import DAO.DaoException;
import beans.Employer;
import service.EmployerService;
import service.ServiceException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Хранит методы работы c обьектами {@link Employer}
 */
public class EmployerServiceImpl implements EmployerService {

    /**
     * Передает обьект по его идентификатору, обращается к DAO
     * @param id идентификатор обьекта
     * @return найденный обьект или null
     */
    public Employer getEmployer(Integer id) {
        return DAOFactory.getEmployerDAO().getById(id);
    }

    /**
     * Добавляет новый обьект(employer) в базу данных через DAO
     * @param employer новый обьект
     */
    public void addEmployer(Employer employer) {
        DAOFactory.getEmployerDAO().create(employer);
    }

    /**
     * Извлекает полный массив обьектов {@link Employer} через DAO
     * @return полный массив обьектов {@link Employer}
     */
    public List<Employer> getAllEmployer() throws ServiceException{
        try {
            DAOFactory newF = new DAOFactory();
            return newF.getEmployerDAO().getAll();
        }
        catch (DaoException e)
        {
            throw new ServiceException(e);
        }
    }

    /**
     * Замещает обьект с идентификатором id на обьект employer черз DAO
     * @param id идентификатор замещаемого обьекта
     * @param employer новаый обьект
     */
    public void update(Integer id, Employer employer) {
        DAOFactory.getEmployerDAO().update(id,employer);
    }

    /**
     * Удаляет обьект с идентификатором id через DAO
     * @param id идентификатор удаляемого обьекта
     */
    public void deleteEmployerById(Integer id) {

        DAOFactory.getEmployerDAO().deleteById(id);
    }

    /**
     * Сортирует все обьекты по имени
     * @param ascending вид сортировки (если true то по возрастанию)
     * @return отссортированный массив
     */
    public List<Employer> sortByName(boolean ascending) throws ServiceException
    {
        try {
            ArrayList<Employer> objs = (ArrayList<Employer>) DAOFactory.getEmployerDAO().getAll();
            objs.sort(new EmployerNameComparator());
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
     * Ищет обьект по должности
     * @param position должность автора
     * @return массив подходящих обьектов
     */
    public List<Employer> findByPosition(String position) throws ServiceException{
        try {
            ArrayList<Employer> allEmployer = (ArrayList<Employer>) DAOFactory.getEmployerDAO().getAll();
            ArrayList<Employer> findEmployer = new ArrayList<>();
            for (Employer employer : allEmployer) {
                if (employer.getPosition().equals(position))
                    findEmployer.add(employer);
            }

            return findEmployer;
        }
        catch (DaoException e)
        {
            throw new ServiceException(e);
        }
    }

    private static class EmployerNameComparator implements Comparator<Employer> {

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
