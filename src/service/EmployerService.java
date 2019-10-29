package service;

import beans.Employer;

import java.util.ArrayList;

/**
 * Интерфейс доступа к бизнес логике обьекта {@link Employer}
 */
public interface EmployerService {

    /**
     * Передает обьект по его идентификатору
     * @param id идентификатор обьекта
     * @return найденный обьект или null
     */
    Employer getEmployer(Integer id);

    /**
     * Добавляет новый обьект(employer) в базу данных
     * @param employer новый обьект
     */
    void addEmployer(Employer employer) ;

    /**
     * Извлекает полный массив обьектов {@link Employer}
     * @return полный массив обьектов {@link Employer}
     */
    ArrayList<Employer> getAllEmployer() ;

    /**
     * Замещает обьект с идентификатором id на обьект employer
     * @param id идентификатор замещаемого обьекта
     * @param employer новаый обьект
     */
    void update(Integer id, Employer employer) ;

    /**
     * Удаляет обьект с идентификатором id
     * @param id идентификатор удаляемого обьекта
     */
    void deleteEmployerById(Integer id);

    /**
     * Сортирует все обьекты по имени
     * @param ascending вид сортировки (если true то по возрастанию)
     * @return отссортированный массив
     */
    ArrayList<Employer> sortByName(boolean ascending);

    /**
     * Ищет обьект по должности
     * @param position должность автора
     * @return массив подходящих обьектов
     */
    ArrayList<Employer> findByPosition(String position);
}
