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

public class PublishingHouseDAOFileImpl implements PublishingHouseDAO {
    private ArrayList<PublishingHouse> PublishingHouseBuff = null;
    @Override
    public ArrayList<PublishingHouse> getAll() {
        ArrayList<PublishingHouse> allPublishingHouse = getAllPublishingHouse();
        return (ArrayList<PublishingHouse>) allPublishingHouse.clone();
    }
    private ArrayList<PublishingHouse> getAllPublishingHouse() {
        if(PublishingHouseBuff != null)
            return PublishingHouseBuff;

        ArrayList<PublishingHouse> allPublishingHouse = new ArrayList<PublishingHouse>();

        BufferedReader buff = null;
        FileReader myFile = null;

        try
        {
            myFile = new FileReader(".\\BD\\PublishingHouse.txt");
            buff = new BufferedReader(myFile);
            while (true)
            {
                String line = buff.readLine();
                if (line == null)
                    break;


                allPublishingHouse.add(PublishingHouseSerializer.ParsePublishingHouse(line));
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
        PublishingHouseBuff = allPublishingHouse;
        return allPublishingHouse;
    }


    @Override
    public PublishingHouse getById(Integer id) {
        ArrayList<PublishingHouse> allPublishingHouse = getAllPublishingHouse();
        for(PublishingHouse publishingHouse : allPublishingHouse)
        {
            if(publishingHouse.getId() == id)
                return publishingHouse;
        }
        return null;
    }

    @Override
    public int update(Integer id, PublishingHouse publishingHouse) {
        ArrayList<PublishingHouse> AllPublishingHouse = getAllPublishingHouse();
        for(int i = 0; i < AllPublishingHouse.size();i++)
        {
            if(AllPublishingHouse.get(i).getId() == id)
            {
                AllPublishingHouse.set(i,publishingHouse);
                saveAutorsToFile(AllPublishingHouse);
                return i;
            }
        };
        return 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        ArrayList<PublishingHouse> AllPublishingHouse = getAllPublishingHouse();
        for(int i = 0; i < AllPublishingHouse.size();i++)
        {
            if(AllPublishingHouse.get(i).getId() == id)
            {
                AllPublishingHouse.remove(i);
                saveAutorsToFile(AllPublishingHouse);
                return true;
            }
        };
        return false;
    }

    @Override
    public boolean delete(PublishingHouse publishingHouse) {
        ArrayList<PublishingHouse> AllPublishingHouse = getAllPublishingHouse();
        AllPublishingHouse .remove(publishingHouse);
        saveAutorsToFile(AllPublishingHouse);
        return true;
    }

    @Override
    public boolean create(PublishingHouse newAuthor) {

        ArrayList<PublishingHouse> AllPublishingHouse = getAllPublishingHouse();
        newAuthor.setId(MyPerentClass.getUniqId(new ArrayList<>(AllPublishingHouse)));
        AllPublishingHouse.add(newAuthor);
        saveAutorsToFile(AllPublishingHouse);
        return true;
    }

    public void saveAutorsToFile(ArrayList<PublishingHouse> authors)
    {
        try(FileWriter writer = new FileWriter(".\\BD\\Authors.txt", false))
        {
            for(PublishingHouse publishingHouse: authors)
            {
                writer.write(PublishingHouseSerializer.FormatPublishingHouse(publishingHouse));
                writer.append('\n');
            }
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
