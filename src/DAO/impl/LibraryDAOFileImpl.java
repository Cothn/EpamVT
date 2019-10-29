/*
 * Всеволод Гринчик 751003 (HRYNCHYK USEVALAD)
 * CRUD VT 2019
 */
package DAO.impl;


import DAO.DAOFactory;
import DAO.LibraryDAO;
import DAO.impl.Serializers.LibrarySerializerFactory;
import beans.LibraryObj;
import beans.MyPerentClass;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static Const.GlobalConstant.SourceFilePath;

/*Book    (Genre, ISBN)    (Name, PageCount, Author, Id)
  Article (Topic, Subject) (Name, PageCount, Author, Id)
*/
public class LibraryDAOFileImpl implements LibraryDAO {
    /** Кеш Обьектов  {@link LibraryObj}*/
    private ArrayList<LibraryObj> libraryObjBuff = null;

    /** имя файла храняшего обьекты */
    private String fileName = SourceFilePath +"\\Library.txt";

    /**
     * Передает копию полного массива обьектов {@link LibraryObj} за пределы класса
     * @return копия полного массива обьектов {@link LibraryObj}
     */
    @Override
    public List<LibraryObj> getAll() {
        ArrayList<LibraryObj> allLibraryObj = (ArrayList<LibraryObj>)getAllLibraryObj();
        return (ArrayList<LibraryObj>) allLibraryObj.clone();
    }

    /**
     * Обьеденят десериализованные обьект в единый список
     * @return полный массив обьектов {@link LibraryObj}
     */
    private List<LibraryObj> getAllLibraryObj() {
        boolean needUpdate = false;
        if(libraryObjBuff != null)
            return libraryObjBuff;

        ArrayList<LibraryObj> allLibraryObj = new ArrayList<>();
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

                LibrarySerializerFactory librarySerializerFactory = new LibrarySerializerFactory();
                LibraryObj buffObj = librarySerializerFactory.parseLibraryObj(line);
                if((buffObj.getAuthorId() != 0 ) && (DAOFactory.getAuthorDAO().getById(buffObj.getAuthorId()) == null ) )
                {
                    buffObj.setAuthorId(0);
                    needUpdate =true;
                }
                if((buffObj.getPublishingHouseId() != 0 ) && (DAOFactory.getPublishingHouseDAO().getById(buffObj.getPublishingHouseId()) == null ) )
                {
                    buffObj.setPublishingHouseId(0);
                    needUpdate =true;
                }
                allLibraryObj.add(buffObj);
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

        libraryObjBuff = allLibraryObj;
        if (needUpdate)
        {
            saveLibraryToFile(libraryObjBuff);
        }
        return allLibraryObj;
    }

    /**
     * Ищет обьект по его идентификатору
     * @param id идентификатор обьекта
     * @return найденный обьект или null
     */
    @Override
    public LibraryObj getById(Integer id) {
        ArrayList<LibraryObj> allLibraryObj = (ArrayList<LibraryObj>)getAllLibraryObj();
        for(LibraryObj libraryObj : allLibraryObj)
        {
            if(libraryObj.getId() == id)
                return libraryObj;
        }
        return null;
    }

    /**
     * Замещает обьект с идентификатором id на обьект libraryObj(использует {@link LibraryDAOFileImpl#saveLibraryToFile(ArrayList)})
     * @param id идентификатор замещаемого обьекта
     * @param libraryObj новаый обьект
     * @return номер обьекта в списке или 0 если обьекта с идентификатором id  не существует
     */
    @Override
    public int update(Integer id, LibraryObj libraryObj) {
        ArrayList<LibraryObj> allLibraryObj = (ArrayList<LibraryObj>)getAllLibraryObj();
        for(int i = 0; i < allLibraryObj.size();i++)
        {
            if(allLibraryObj.get(i).getId() == id)
            {
                allLibraryObj.set(i,libraryObj);
                saveLibraryToFile(allLibraryObj);
                return i;
            }
        }
        return 0;
    }

    /**
     * Удаляет обьект с идентификатором id (использует {@link LibraryDAOFileImpl#saveLibraryToFile(ArrayList)})
     * @param id идентификатор удаляемого обьекта
     * @return true если удаление прошло успешно иначе false
     */
    @Override
    public boolean deleteById(Integer id) {
        ArrayList<LibraryObj> allLibraryObj = (ArrayList<LibraryObj>)getAllLibraryObj();
        for(int i = 0; i < allLibraryObj.size();i++)
        {
            if(allLibraryObj.get(i).getId() == id)
            {
                allLibraryObj.remove(i);
                saveLibraryToFile(allLibraryObj);
                return true;
            }
        }
        return false;
    }

    /**
     * Добавляет новый обьект(newLibraryObj) в базу данных(использует {@link LibraryDAOFileImpl#saveLibraryToFile(ArrayList)})
     * @param newLibraryObj новый обьект
     * @return true если добавление прошло успешно иначе false
     */
    @Override
    public boolean create(LibraryObj newLibraryObj) {
        ArrayList<LibraryObj> allLibraryObj = (ArrayList<LibraryObj>)getAllLibraryObj();
        newLibraryObj.setId(MyPerentClass.getUniqId(new ArrayList<>(allLibraryObj)));
        allLibraryObj.add(newLibraryObj);
        saveLibraryToFile(allLibraryObj);
        return true;
    }

    /**
     * Сохраняет обьекты в базу данных
     * @param libraryObjs полный список обьектов {@link LibraryObj}
     */
    private void saveLibraryToFile(ArrayList<LibraryObj> libraryObjs)
    {
        try(FileWriter writer = new FileWriter(fileName, false))
        {
            for(LibraryObj libraryObj: libraryObjs)
            {
                LibrarySerializerFactory librarySerializerFactory = new LibrarySerializerFactory();
                writer.write(librarySerializerFactory.formatLibraryObj(libraryObj));
                writer.append('\n');
            }
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

}
