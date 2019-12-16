package DAO.xml_stax_impl;

import DAO.DaoException;
import DAO.EmployerDAO;
import DAO.LibraryDAO;
import DAO.xml_stax_impl.serializers.EmployerStaxParser;
import beans.Employer;
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

public class EmployerDAO_Stax_Impl implements EmployerDAO{

    public static final Logger LOG = Logger.getLogger(LibraryDAO.class.getName());

    /** имя файла храняшего обьекты */
    private String fileName = SourceFilePath +"Employers.xml";

    /**
     * Передает полный массив обьектов {@link Employer}
     *
     * @return полный массив обьектов {@link Employer}
     */
    @Override
    public List<Employer> getAll() throws DaoException {
        List<Employer> employers = null;
        try {
            InputStream input = new FileInputStream(fileName);
            XMLStreamReader reader = XMLInputFactory.newInstance().createXMLStreamReader(input);
            employers = EmployerStaxParser.parse(reader);
        }catch (Exception e) {
            LOG.log(Level.ERROR,e.getMessage());
            System.out.println(e.getMessage());
            throw new DaoException();

        }
        return employers;
    }

    /**
     * Ищет обьект по его идентификатору
     *
     * @param id идентификатор обьекта
     * @return найденный обьект или null
     */
    @Override
    public Employer getById(Integer id) {
        return null;
    }

    /**
     * Замещает обьект с идентификатором id на обьект employer
     *
     * @param id       идентификатор замещаемого обьекта
     * @param employer новаый обьект
     * @return номер обьекта в списке или 0 если обьекта с идентификатором id  не существует
     */
    @Override
    public int update(Integer id, Employer employer) {
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
     * Добавляет новый обьект(employer) в базу данных
     *
     * @param employer новый обьект
     * @return true если добавление прошло успешно иначе false
     */
    @Override
    public boolean create(Employer employer) {
        return false;
    }

    /**
     * Добавляет новые обьекты(newEmployers) в базу данных
     *
     * @param newEmployers новые обьекты
     * @return true если добавление прошло успешно иначе false
     */
    @Override
    public boolean addEmployers(List<Employer> newEmployers) throws DaoException {
        return false;
    }
}
