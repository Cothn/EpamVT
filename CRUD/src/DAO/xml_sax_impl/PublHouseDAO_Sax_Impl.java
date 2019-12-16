package DAO.xml_sax_impl;

import DAO.DaoException;
import DAO.PublishingHouseDAO;
import DAO.xml_sax_impl.Serializers.PublHouseSaxHandler;
import beans.PublishingHouse;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.util.List;

import static Const.GlobalConstant.SourceFilePath;

public class PublHouseDAO_Sax_Impl implements PublishingHouseDAO {

    public static final Logger LOG = Logger.getLogger(PublishingHouseDAO.class.getName());

    /** имя файла храняшего обьекты */
    private String fileName = SourceFilePath +"PublHouses.xml";

    /**
     * Передает полный массив обьектов {@link PublishingHouse}
     *
     * @return полный массив обьектов {@link PublishingHouse}
     */
    @Override
    public List<PublishingHouse> getAll() throws DaoException {
        List<PublishingHouse> publHouses= null;
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            PublHouseSaxHandler handler = new PublHouseSaxHandler();
            reader.setContentHandler(handler);
            reader.parse(fileName);
            reader.setFeature("http://xml.org/sax/features/validation",true);
            reader.setFeature("http://xml.org/sax/features/namespaces",true);
            reader.setFeature("http://xml.org/sax/features/string-interning",true);
            reader.setFeature("http://apache.org/xml/features/validation/schema",false);
            publHouses = handler.getPublishingHousesList();
        }catch (Exception e) {
            LOG.log(Level.ERROR,e.getMessage());
            System.out.println(e.getStackTrace());
            System.out.println(e.getMessage());
            throw new DaoException();

        }
        return publHouses;
    }

    /**
     * Ищет обьект по его идентификатору
     *
     * @param id идентификатор обьекта
     * @return найденный обьект или null
     */
    @Override
    public PublishingHouse getById(Integer id) {
        return null;
    }

    /**
     * Замещает обьект с идентификатором id на обьект publishingHouse
     *
     * @param id              идентификатор замещаемого обьекта
     * @param publishingHouse новаый обьект
     * @return номер обьекта в списке или 0 если обьекта с идентификатором id  не существует
     */
    @Override
    public int update(Integer id, PublishingHouse publishingHouse) {
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
     * Добавляет новый обьект(newPublishingHouse) в базу данных
     *
     * @param newPublishingHouse новый обьект
     * @return true если добавление прошло успешно иначе false
     */
    @Override
    public boolean create(PublishingHouse newPublishingHouse) {
        return false;
    }

    /**
     * Добавляет новые обьекты(newPublishingHouses) в базу данных
     *
     * @param newPublishingHouses новые обьекты
     * @return true если добавление прошло успешно иначе false
     */
    @Override
    public boolean addPublishingHouses(List<PublishingHouse> newPublishingHouses) throws DaoException {
        return false;
    }
}
