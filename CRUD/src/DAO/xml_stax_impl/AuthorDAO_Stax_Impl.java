package DAO.xml_stax_impl;

import DAO.AuthorDAO;
import DAO.DaoException;
import DAO.LibraryDAO;
import DAO.xml_stax_impl.serializers.AuthorStaxParser;
import beans.Author;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import static Const.GlobalConstant.SourceFilePath;

public class AuthorDAO_Stax_Impl implements AuthorDAO {

    public static final Logger LOG = Logger.getLogger(LibraryDAO.class.getName());

    /** имя файла храняшего обьекты */
    private String fileName = SourceFilePath +"Author.xml";

    /**
     * Передает полный массив обьектов {@link Author}
     * @return полный массив обьектов {@link Author}
     */
    @Override
    public List<Author> getAll() throws DaoException {
        List<Author> authors = null;
        try {
            InputStream input = new FileInputStream(fileName);
            XMLStreamReader reader = XMLInputFactory.newInstance().createXMLStreamReader(input);
            authors = AuthorStaxParser.parse(reader);
        }catch (Exception e) {
            LOG.log(Level.ERROR,e.getMessage());
            System.out.println(e.getMessage());
            throw new DaoException();

        }
        return authors;
    }

    /**
     * Ищет обьект по его идентификатору
     *
     * @param id идентификатор обьекта
     * @return найденный обьект или null
     */
    @Override
    public Author getById(Integer id) {
        return null;
    }

    /**
     * Замещает обьект с идентификатором id на обьект author
     *
     * @param id     идентификатор замещаемого обьекта
     * @param author новаый обьект
     * @return номер обьекта в списке или 0 если обьекта с идентификатором id  не существует
     */
    @Override
    public int update(Integer id, Author author) {
        return 0;
    }

    /**
     * Удаляет обьект с идентификатором id
     *
     * @param id идентификатор удаляемого обьекта
     * @return true если удаление прошло успешно иначе false
     */
    @Override
    public boolean deleteById(Integer id) {
        return false;
    }

    /**
     * Добавляет новый обьект(newAuthor) в базу данных
     *
     * @param newAuthor новый обьект
     * @return true если добавление прошло успешно иначе false
     */
    @Override
    public boolean create(Author newAuthor) {
        return false;
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
}
