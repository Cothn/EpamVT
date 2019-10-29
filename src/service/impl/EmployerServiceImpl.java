package service.impl;

import DAO.DAOFactory;
import beans.Employer;
import service.EmployerService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
    public ArrayList<Employer> getAllEmployer() {

        return DAOFactory.getEmployerDAO().getAll();
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
    public ArrayList<Employer> sortByName(boolean ascending)
    {
        ArrayList<Employer> Objs =  DAOFactory.getEmployerDAO().getAll();
        Objs.sort(new EmployerNameComparator());
        if (!ascending)
        {
            Collections.reverse(Objs);
        }
        return Objs;
    }

    /**
     * Ищет обьект по должности
     * @param position должность автора
     * @return массив подходящих обьектов
     */
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

    static class EmployerNameComparator implements Comparator<Employer> {

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
