package DAO.xml_sax_impl;

import DAO.DaoException;
import DAO.LibraryDAO;
import DAO.xml_sax_impl.Serializers.LibrarySaxHandler;
import beans.LibraryObj;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.util.List;

import static Const.GlobalConstant.SourceFilePath;

public class LibraryDAO_Sax_Impl implements LibraryDAO {

    public static final Logger LOG = Logger.getLogger(LibraryDAO.class.getName());

    /** имя файла храняшего обьекты */
    private String fileName = SourceFilePath +"library.xml";

    /**
     * Передает полный массив обьектов {@link LibraryObj}
     * @return полный массив обьектов {@link LibraryObj}
     */
    @Override
    public List<LibraryObj> getAll() throws DaoException {
        List<LibraryObj> libraryObjs = null;
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            LibrarySaxHandler handler = new LibrarySaxHandler();
            reader.setContentHandler(handler);
            reader.parse(fileName);
            reader.setFeature("http://xml.org/sax/features/validation",true);
            reader.setFeature("http://xml.org/sax/features/namespaces",true);
            reader.setFeature("http://xml.org/sax/features/string-interning",true);
            reader.setFeature("http://apache.org/xml/features/validation/schema",false);
            libraryObjs = handler.getLibraryObjsList();
        }catch (Exception e) {
            LOG.log(Level.ERROR,e.getMessage());
            System.out.println(e.getStackTrace());
            System.out.println(e.getMessage());
            throw new DaoException();

        }
        return libraryObjs;
    }

    /**
     * Ищет обьект по его идентификатору
     *
     * @param id идентификатор обьекта
     * @return найденный обьект или null
     */
    @Override
    public LibraryObj getById(Integer id) {
        return null;
    }

    /**
     * Замещает обьект с идентификатором id на обьект libraryObj
     *
     * @param id         идентификатор замещаемого обьекта
     * @param LibraryObj новаый обьект
     * @return номер обьекта в списке или 0 если обьекта с идентификатором id  не существует
     */
    @Override
    public int update(Integer id, LibraryObj LibraryObj) {
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
     * Добавляет новый обьект(newLibraryObj) в базу данных
     *
     * @param newLibraryObj новый обьект
     * @return true если добавление прошло успешно иначе false
     */
    @Override
    public boolean create(LibraryObj newLibraryObj) {
        return false;
    }

    /**
     * Добавляет новые обьекты(newLibraryObjs) в базу данных
     *
     * @param newLibraryObjs новые обьекты
     * @return true если добавление прошло успешно иначе false
     */
    @Override
    public boolean addLibraryObjs(List<LibraryObj> newLibraryObjs) throws DaoException {
        return false;
    }
}
