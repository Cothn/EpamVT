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
    private ArrayList<Employer> employersBuff = null;
    private final String fileName = SourceFilePath +"\\Employers.txt";

    public ArrayList<Employer> getAll() {
        ArrayList<Employer> allEmployer = getAllEmployer();
        return (ArrayList<Employer>) allEmployer.clone();
    }

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


    public Employer getById(Integer id) {
        ArrayList<Employer> allEmployer = getAllEmployer();
        for(Employer libraryObj : allEmployer)
        {
            if(libraryObj.getId() == id)
                return libraryObj;
        }
        return null;
    }

    public int update(Integer id, Employer libraryObj) {
        ArrayList<Employer> allEmployer = getAllEmployer();
        for(int i = 0; i < allEmployer.size();i++)
        {
            if(allEmployer.get(i).getId() == id)
            {
                allEmployer.set(i,libraryObj);
                saveLibraryToFile(allEmployer);
                return i;
            }
        }
        return 0;
    }

    public boolean deleteById(Integer id) {
        ArrayList<Employer> allEmployer = getAllEmployer();
        for(int i = 0; i < allEmployer.size();i++)
        {
            if(allEmployer.get(i).getId() == id)
            {
                allEmployer.remove(i);
                saveLibraryToFile(allEmployer);
                return true;
            }
        }
        return false;
    }

    public boolean delete(Employer libraryObj) {
        ArrayList<Employer> allEmployer = getAllEmployer();
        allEmployer .remove(libraryObj);
        saveLibraryToFile(allEmployer);
        return true;
    }

    public boolean create(Employer newLibraryObj) {

        ArrayList<Employer> allEmployer = getAllEmployer();
        newLibraryObj.setId(MyPerentClass.getUniqId(new ArrayList<>(allEmployer)));
        allEmployer.add(newLibraryObj);
        saveLibraryToFile(allEmployer);
        return true;
    }

    private void saveLibraryToFile(ArrayList<Employer> employers)
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
