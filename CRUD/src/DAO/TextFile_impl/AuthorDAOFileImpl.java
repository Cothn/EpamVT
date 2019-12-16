/*
 * Всеволод Гринчик 751003 (HRYNCHYK USEVALAD)
 * CRUD VT 2019
 */
package DAO.TextFile_impl;

import DAO.AuthorDAO;
import DAO.DaoException;
import DAO.TextFile_impl.Serializers.AuthorSerializer;
import beans.Author;
import beans.MyPerentClass;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static Const.GlobalConstant.SourceFilePath;

/**
 * Хранит методы доступа к текстовому файлу храняшему обьекты {@link Author}
 */
public class AuthorDAOFileImpl  implements AuthorDAO {
    /** имя файла храняшего обьекты */
    private final String fileName = SourceFilePath +"Authors.txt";

    /** Кеш Обьектов  {@link Author}*/
    private ArrayList<Author> authorsBuff = null;

    /**
     * Передает копию полного массива обьектов {@link Author} за пределы класса
     * @return копия полного массива обьектов {@link Author}
     */
    @Override
    public List<Author> getAll() throws DaoException {
        ArrayList<Author> allAuthors = (ArrayList<Author>)getAllAuthors();
        return (ArrayList<Author>) allAuthors.clone();
    }

    /**
     * Обьеденят десериализованные обьект в единый список
     * @return полный массив обьектов {@link Author}
     */
    private List<Author> getAllAuthors() {
        if(authorsBuff != null)
            return authorsBuff;

        ArrayList<Author> allAuthors = new ArrayList<>();
        BufferedReader buff = null;
        FileReader myFile = null;

        try
        {
            myFile = new FileReader(fileName);
            buff = new BufferedReader(myFile);
            while (true)
            {
                String line = buff.readLine();
                if (line == null || line.equals(""))
                    break;

                allAuthors.add(AuthorSerializer.parseAuthors(line));
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
        authorsBuff = allAuthors;
        return allAuthors;
    }

    /**
     * Ищет обьект по его идентификатору
     * @param id идентификатор обьекта
     * @return найденный обьект или null
     */
    @Override
    public Author getById(Integer id) {
        ArrayList<Author> allAuthors = (ArrayList<Author>)getAllAuthors();
        for(Author author : allAuthors)
        {
            if(author.getId() == id)
                return author;
        }
        return null;
    }

    /**
     * Замещает обьект с идентификатором id на обьект author(использует {@link AuthorDAOFileImpl#saveAutorsToFile(ArrayList)})
     * @param id идентификатор замещаемого обьекта
     * @param author новаый обьект
     * @return номер обьекта в списке или 0 если обьекта с идентификатором id  не существует
     */
    @Override
    public int update(Integer id, Author author) {
        ArrayList<Author> AllAuthors = (ArrayList<Author>)getAllAuthors();
        for(int i = 0; i < AllAuthors.size();i++)
        {
            if(AllAuthors.get(i).getId() == id)
            {
                AllAuthors.set(i,author);
                saveAutorsToFile(AllAuthors);
                return i;
            }
        }
        return 0;
    }

    /**
     * Удаляет обьект с идентификатором id (использует {@link AuthorDAOFileImpl#saveAutorsToFile(ArrayList)})
     * @param id идентификатор удаляемого обьекта
     * @return true если удаление прошло успешно иначе false
     */
    @Override
    public boolean deleteById(Integer id) {
        ArrayList<Author> AllAuthors = (ArrayList<Author>)getAllAuthors();
        for(int i = 0; i < AllAuthors.size();i++)
        {
            if(AllAuthors.get(i).getId() == id)
            {
                AllAuthors.remove(i);
                saveAutorsToFile(AllAuthors);
                return true;
            }
        }
        return false;
    }

    /**
     * Добавляет новый обьект(newAuthor) в базу данных(использует {@link AuthorDAOFileImpl#saveAutorsToFile(ArrayList)})
     * @param newAuthor новый обьект
     * @return true если добавление прошло успешно иначе false
     */
    @Override
    public boolean create(Author newAuthor) {
        boolean result = false;
        ArrayList<Author> AllAuthors = (ArrayList<Author>)getAllAuthors();
        newAuthor.setId(MyPerentClass.getUniqId(new ArrayList<>(AllAuthors)));
        AllAuthors.add(newAuthor);
        saveAutorsToFile(AllAuthors);
        result = true;
        return result;
    }

    /**
     * Добавляет новые обьекты(newAuthors) в базу данных
     *
     * @param newAuthors новые обьекты
     * @return true если добавление прошло успешно иначе false
     */
    @Override
    public boolean addAuthors(List<Author> newAuthors) throws DaoException {
        return false;
    }

    /**
     * Сохраняет обьекты в базу данных
     * @param authors полный список обьектов {@link Author}
     */
    private void saveAutorsToFile(ArrayList<Author> authors)
    {
        try(FileWriter writer = new FileWriter(fileName, false))
        {
            for(Author author: authors)
            {
                writer.write(AuthorSerializer.formatAuthor(author));
                writer.append('\n');
            }
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
