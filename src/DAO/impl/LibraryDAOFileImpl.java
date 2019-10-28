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

import static Const.GlobalConstant.SourceFilePath;

/*Book    (Genre, ISBN)    (Name, PageCount, Author, Id)
  Article (Topic, Subject) (Name, PageCount, Author, Id)
*/
public class LibraryDAOFileImpl implements LibraryDAO {

    private ArrayList<LibraryObj> LibraryObjBuff = null;
    private String fileName = SourceFilePath +"\\Library.txt";
    @Override
    public ArrayList<LibraryObj> getAll() {
        ArrayList<LibraryObj> allLibraryObj = getAllLibraryObj();
        return (ArrayList<LibraryObj>) allLibraryObj.clone();
    }

    private ArrayList<LibraryObj> getAllLibraryObj() {
        boolean needUpdate = false;
        if(LibraryObjBuff != null)
            return LibraryObjBuff;

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
                LibraryObj buffObj = librarySerializerFactory.ParseLibraryObj(line);
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

        LibraryObjBuff = allLibraryObj;
        if (needUpdate)
        {
            saveLibraryToFile(LibraryObjBuff);
        }
        return allLibraryObj;
    }

    @Override
    public LibraryObj getById(Integer id) {
        ArrayList<LibraryObj> allLibraryObj = getAllLibraryObj();
        for(LibraryObj libraryObj : allLibraryObj)
        {
            if(libraryObj.getId() == id)
                return libraryObj;
        }
        return null;
    }

    @Override
    public int update(Integer id, LibraryObj libraryObj) {
        ArrayList<LibraryObj> allLibraryObj = getAllLibraryObj();
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

    @Override
    public boolean deleteById(Integer id) {
        ArrayList<LibraryObj> allLibraryObj = getAllLibraryObj();
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

    @Override
    public boolean delete(LibraryObj libraryObj) {
        ArrayList<LibraryObj> allLibraryObj = getAllLibraryObj();
        allLibraryObj .remove(libraryObj);
        saveLibraryToFile(allLibraryObj);
        return true;
    }

    @Override
    public boolean create(LibraryObj newLibraryObj) {
        ArrayList<LibraryObj> allLibraryObj = getAllLibraryObj();
        newLibraryObj.setId(MyPerentClass.getUniqId(new ArrayList<>(allLibraryObj)));
        allLibraryObj.add(newLibraryObj);
        saveLibraryToFile(allLibraryObj);
        return true;
    }

    private void saveLibraryToFile(ArrayList<LibraryObj> libraryObjs)
    {
        try(FileWriter writer = new FileWriter(fileName, false))
        {
            for(LibraryObj libraryObj: libraryObjs)
            {
                LibrarySerializerFactory librarySerializerFactory = new LibrarySerializerFactory();
                writer.write(librarySerializerFactory.FormatLibraryObj(libraryObj));
                writer.append('\n');
            }
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

}
