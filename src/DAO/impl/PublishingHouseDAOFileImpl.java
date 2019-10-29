/*
 * Всеволод Гринчик 751003 (HRYNCHYK USEVALAD)
 * CRUD VT 2019
 */
package DAO.impl;

import DAO.PublishingHouseDAO;
import DAO.impl.Serializers.PublishingHouseSerializer;
import beans.MyPerentClass;
import beans.PublishingHouse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static Const.GlobalConstant.SourceFilePath;

public class PublishingHouseDAOFileImpl implements PublishingHouseDAO {
    /** Кеш Обьектов  {@link PublishingHouse}*/
    private ArrayList<PublishingHouse> publishingHouseBuff = null;

    /** имя файла храняшего обьекты */
    private final String fileName = SourceFilePath +"\\PublishingHouse.txt";

    /**
     * Передает копию полного массива обьектов {@link PublishingHouse} за пределы класса
     * @return копия полного массива обьектов {@link PublishingHouse}
     */
    @Override
    public List<PublishingHouse> getAll() {
        ArrayList<PublishingHouse> allPublishingHouse = (ArrayList<PublishingHouse>)getAllPublishingHouse();
        return (ArrayList<PublishingHouse>) allPublishingHouse.clone();
    }

    /**
     * Обьеденят десериализованные обьект в единый список
     * @return полный массив обьектов {@link PublishingHouse}
     */
    private List<PublishingHouse> getAllPublishingHouse() {
        if(publishingHouseBuff != null)
            return publishingHouseBuff;

        ArrayList<PublishingHouse> allPublishingHouse = new ArrayList<>();
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

                allPublishingHouse.add(PublishingHouseSerializer.parsePublishingHouse(line));
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
        publishingHouseBuff = allPublishingHouse;
        return allPublishingHouse;
    }

    /**
     * Ищет обьект по его идентификатору
     * @param id идентификатор обьекта
     * @return найденный обьект или null
     */
    @Override
    public PublishingHouse getById(Integer id) {
        ArrayList<PublishingHouse> allPublishingHouse = (ArrayList<PublishingHouse>)getAllPublishingHouse();
        for(PublishingHouse publishingHouse : allPublishingHouse)
        {
            if(publishingHouse.getId() == id)
                return publishingHouse;
        }
        return null;
    }

    /**
     * Замещает обьект с идентификатором id на обьект libraryObj(использует {@link PublishingHouseDAOFileImpl#savePublishingHouseToFile(ArrayList)})
     * @param id идентификатор замещаемого обьекта
     * @param publishingHouse новаый обьект
     * @return номер обьекта в списке или 0 если обьекта с идентификатором id  не существует
     */
    @Override
    public int update(Integer id, PublishingHouse publishingHouse) {
        ArrayList<PublishingHouse> AllPublishingHouse = (ArrayList<PublishingHouse>)getAllPublishingHouse();
        for(int i = 0; i < AllPublishingHouse.size();i++)
        {
            if(AllPublishingHouse.get(i).getId() == id)
            {
                AllPublishingHouse.set(i,publishingHouse);
                savePublishingHouseToFile(AllPublishingHouse);
                return i;
            }
        }
        return 0;
    }

    /**
     * Удаляет обьект с идентификатором id (использует {@link PublishingHouseDAOFileImpl#savePublishingHouseToFile(ArrayList)})
     * @param id идентификатор удаляемого обьекта
     * @return true если удаление прошло успешно иначе false
     */
    @Override
    public boolean deleteById(Integer id) {
        ArrayList<PublishingHouse> AllPublishingHouse = (ArrayList<PublishingHouse>)getAllPublishingHouse();
        for(int i = 0; i < AllPublishingHouse.size();i++)
        {
            if(AllPublishingHouse.get(i).getId() == id)
            {
                AllPublishingHouse.remove(i);
                savePublishingHouseToFile(AllPublishingHouse);
                return true;
            }
        }
        return false;
    }

    /**
     * Добавляет новый обьект(newPublishingHous) в базу данных(использует {@link PublishingHouseDAOFileImpl#savePublishingHouseToFile(ArrayList)})
     * @param newPublishingHouse новый обьект
     * @return true если добавление прошло успешно иначе false
     */
    @Override
    public boolean create(PublishingHouse newPublishingHouse) {
        ArrayList<PublishingHouse> AllPublishingHouse = (ArrayList<PublishingHouse>)getAllPublishingHouse();
        newPublishingHouse.setId(MyPerentClass.getUniqId(new ArrayList<>(AllPublishingHouse)));
        AllPublishingHouse.add(newPublishingHouse);
        savePublishingHouseToFile(AllPublishingHouse);
        return true;
    }

    /**
     * Сохраняет обьекты в базу данных
     * @param publishingHouses полный список обьектов {@link PublishingHouse}
     */
    private void savePublishingHouseToFile(ArrayList<PublishingHouse> publishingHouses)
    {
        try(FileWriter writer = new FileWriter(fileName, false))
        {
            for(PublishingHouse publishingHouse: publishingHouses)
            {
                writer.write(PublishingHouseSerializer.formatPublishingHouse(publishingHouse));
                writer.append('\n');
            }
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
