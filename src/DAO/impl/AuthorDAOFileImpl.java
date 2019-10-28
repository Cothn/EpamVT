package DAO.impl;

import DAO.AuthorDAO;
import DAO.impl.Serializers.AuthorSerializer;
import beans.Author;
import beans.MyPerentClass;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AuthorDAOFileImpl  implements AuthorDAO {

    private ArrayList<Author> AuthorsBuff = null;
    @Override
    public ArrayList<Author> getAll() {
        ArrayList<Author> allAuthors = getAllAuthors();
        return (ArrayList<Author>) allAuthors.clone();
    }

    private ArrayList<Author> getAllAuthors() {
        if(AuthorsBuff != null)
            return AuthorsBuff;

        ArrayList<Author> allAuthors = new ArrayList<Author>();

        BufferedReader buff = null;
        FileReader myFile = null;

        try
        {
            myFile = new FileReader(".\\BD\\Authors.txt");
            buff = new BufferedReader(myFile);
            while (true)
            {
                String line = buff.readLine();
                if (line == null)
                    break;


                allAuthors.add(AuthorSerializer.ParseAuthors(line));

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
        AuthorsBuff = allAuthors;
        return allAuthors;
    }

    @Override
    public Author getById(Integer id) {
        ArrayList<Author> allAuthors = getAllAuthors();
        for(Author author : allAuthors)
        {
            if(author.getId() == id)
                return author;
        }
        return null;
    }

    @Override
    public int update(Integer id, Author author) {
        ArrayList<Author> AllAuthors = getAllAuthors();
        for(int i = 0; i < AllAuthors.size();i++)
        {
            if(AllAuthors.get(i).getId() == id)
            {
                AllAuthors.set(i,author);
                saveAutorsToFile(AllAuthors);
                return i;
            }
        };
        return 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        ArrayList<Author> AllAuthors = getAllAuthors();
        for(int i = 0; i < AllAuthors.size();i++)
        {
            if(AllAuthors.get(i).getId() == id)
            {
                AllAuthors.remove(i);
                saveAutorsToFile(AllAuthors);
                return true;
            }
        };
        return false;
    }

    @Override
    public boolean delete(Author author) {
        ArrayList<Author> AllAuthors = getAllAuthors();
        AllAuthors .remove(author);
        saveAutorsToFile(AllAuthors);
        return true;
    }

    @Override
    public boolean create(Author newAuthor) {

        ArrayList<Author> AllAuthors = getAllAuthors();
        newAuthor.setId(MyPerentClass.getUniqId(new ArrayList<>(AllAuthors)));
        AllAuthors.add(newAuthor);
        saveAutorsToFile(AllAuthors);
        return true;
    }

    public void saveAutorsToFile(ArrayList<Author> authors)
    {
        try(FileWriter writer = new FileWriter(".\\BD\\Authors.txt", false))
        {
            for(Author author: authors)
            {
                writer.write(AuthorSerializer.FormatAuthor(author));
                writer.append('\n');
            }
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
