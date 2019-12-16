package DAO.xml_sax_impl;

import DAO.DaoException;
import DAO.EmployerDAO;
import DAO.LibraryDAO;
import DAO.xml_sax_impl.Serializers.EmployerSaxHandler;
import beans.Employer;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.util.List;

import static Const.GlobalConstant.SourceFilePath;

public class EmployerDAO_Sax_Impl implements EmployerDAO{

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
            XMLReader reader = XMLReaderFactory.createXMLReader();
            EmployerSaxHandler handler = new EmployerSaxHandler();
            reader.setContentHandler(handler);
            reader.parse(fileName);
            reader.setFeature("http://xml.org/sax/features/validation",true);
            reader.setFeature("http://xml.org/sax/features/namespaces",true);
            reader.setFeature("http://xml.org/sax/features/string-interning",true);
            reader.setFeature("http://apache.org/xml/features/validation/schema",false);
            employers = handler.getEmployersList();
        }catch (Exception e) {
            LOG.log(Level.ERROR,e.getMessage());
            System.out.println(e.getStackTrace());
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
