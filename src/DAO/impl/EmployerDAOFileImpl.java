/*
 * Всеволод Гринчик 751003 (HRYNCHYK USEVALAD)
 * CRUD VT 2019
 */
package DAO.impl;

import DAO.EmployerDAO;
import DAO.impl.Serializers.EmployerSerializer;
import beans.Employer;
import beans.MyPerentClass;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static Const.GlobalConstant.SourceFilePath;

public class EmployerDAOFileImpl implements EmployerDAO {
    /** Кеш Обьектов  {@link Employer}*/
    private ArrayList<Employer> employersBuff = null;

    /** имя файла храняшего обьекты */
    private final String fileName = SourceFilePath +"\\Employers.txt";

    /**
     * Передает копию полного массива обьектов {@link Employer} за пределы класса
     * @return копия полного массива обьектов {@link Employer}
     */
    public ArrayList<Employer> getAll() {
        ArrayList<Employer> allEmployer = getAllEmployer();
        return (ArrayList<Employer>) allEmployer.clone();
    }

    /**
     * Обьеденят десериализованные обьект в единый список
     * @return полный массив обьектов {@link Employer}
     */
    private ArrayList<Employer> getAllEmployer() {
        boolean needUpdate = false;
        if(employersBuff != null)
            return employersBuff;

        ArrayList<Employer> allEmployer = new ArrayList<>();
        BufferedReader buff = null;
        FileReader myFile = null;

        try
        {
            myFile = new FileReader(fileName);
            buff = new BufferedReader(myFile);

            while (true)
            {
                String line = buff.readLine();
                if ((line == null) || (line.equals("")))
                    break;

                allEmployer.add(EmployerSerializer.ParseEmployer(line));
                //System.out.println(line);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                buff.close();
                myFile.close();
            }
            catch (IOException e1)
            {
                e1.printStackTrace();
            }
        }

        employersBuff = allEmployer;
        return allEmployer;
    }

    /**
     * Ищет обьект по его идентификатору
     * @param id идентификатор обьекта
     * @return найденный обьект или null
     */
    public Employer getById(Integer id) {
        ArrayList<Employer> allEmployer = getAllEmployer();
        for(Employer libraryObj : allEmployer)
        {
            if(libraryObj.getId() == id)
                return libraryObj;
        }
        return null;
    }

    /**
     * Замещает обьект с идентификатором id на обьект employer(использует {@link EmployerDAOFileImpl#saveEmployersToFile(ArrayList)})
     * @param id идентификатор замещаемого обьекта
     * @param employer новаый обьект
     * @return номер обьекта в списке или 0 если обьекта с идентификатором id  не существует
     */
    public int update(Integer id, Employer employer) {
        ArrayList<Employer> allEmployer = getAllEmployer();
        for(int i = 0; i < allEmployer.size();i++)
        {
            if(allEmployer.get(i).getId() == id)
            {
                allEmployer.set(i,employer);
                saveEmployersToFile(allEmployer);
                return i;
            }
        }
        return 0;
    }

    /**
     * Удаляет обьект с идентификатором id (использует {@link EmployerDAOFileImpl#saveEmployersToFile(ArrayList)})
     * @param id идентификатор удаляемого обьекта
     * @return true если удаление прошло успешно иначе false
     */
    public boolean deleteById(Integer id) {
        ArrayList<Employer> allEmployer = getAllEmployer();
        for(int i = 0; i < allEmployer.size();i++)
        {
            if(allEmployer.get(i).getId() == id)
            {
                allEmployer.remove(i);
                saveEmployersToFile(allEmployer);
                return true;
            }
        }
        return false;
    }

    /**
     * Добавляет новый обьект(newEmployer) в базу данных(использует {@link EmployerDAOFileImpl#saveEmployersToFile(ArrayList)})
     * @param newEmployer новый обьект
     * @return true если добавление прошло успешно иначе false
     */
    public boolean create(Employer newEmployer) {

        ArrayList<Employer> allEmployer = getAllEmployer();
        newEmployer.setId(MyPerentClass.getUniqId(new ArrayList<>(allEmployer)));
        allEmployer.add(newEmployer);
        saveEmployersToFile(allEmployer);
        return true;
    }

    /**
     * Сохраняет обьекты в базу данных
     * @param employers полный список обьектов {@link Employer}
     */
    private void saveEmployersToFile(ArrayList<Employer> employers)
    {
        try(FileWriter writer = new FileWriter(fileName, false))
        {
            for(Employer employer: employers)
            {
                writer.write(EmployerSerializer.FormatEmployer(employer));
                writer.append('\n');
            }
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
