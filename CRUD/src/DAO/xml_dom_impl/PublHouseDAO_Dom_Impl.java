package DAO.xml_dom_impl;

import DAO.DaoException;
import DAO.PublishingHouseDAO;
import beans.PublishingHouse;
import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

import static Const.GlobalConstant.SourceFilePath;

public class PublHouseDAO_Dom_Impl implements PublishingHouseDAO {

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
        List<PublishingHouse> publhouses = new ArrayList<PublishingHouse>();
        try {
            DOMParser parser = new DOMParser();
            parser.parse(fileName);
            Document document = parser.getDocument();
            Element root = document.getDocumentElement();
            NodeList publhouseNodes = root.getElementsByTagName("Publhouse");
            PublishingHouse publhouse = null;
            for(int i = 0; i < publhouseNodes.getLength();i++)
            {
                publhouse = new PublishingHouse();
                Element publhouseElement = (Element) publhouseNodes.item(i);
                publhouse.setId(Integer.parseInt(getChild(publhouseElement,"id").getTextContent().trim()));
                publhouse.setTitle(getChild(publhouseElement,"title").getTextContent().trim());
                publhouse.setAddress(getChild(publhouseElement,"address").getTextContent().trim());
                publhouse.setPhone((getChild(publhouseElement,"phone").getTextContent().trim()));
                publhouse.setFoundationDate((getChild(publhouseElement,"foundationdate").getTextContent().trim()));
                publhouse.setDescription(getChild(publhouseElement,"description").getTextContent().trim());
                publhouses.add(publhouse);
            }

        }catch (Exception e) {
            LOG.log(Level.ERROR,e.getMessage());
            System.out.println(e.getMessage());
            throw new DaoException();
        }
        return publhouses;

    }

    private static Element getChild(Element element, String childName)
    {
        NodeList nlist = element.getElementsByTagName(childName);
        Element child = (Element) nlist.item(0);
        return child;
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
