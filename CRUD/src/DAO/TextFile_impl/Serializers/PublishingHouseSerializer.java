package DAO.TextFile_impl.Serializers;

import beans.PublishingHouse;

/**
 * Хранит методы сериализации/десериализации {@link PublishingHouse} в текстовый файл
 */
public class PublishingHouseSerializer {
    //PublishingHouse    Id#Title#Addres#phone#birthDate#description
    /**символ разделитель*/
    private static String separator = "#";

    /**
     * Генерирует класс на основе строки
     * @param publishingHouseAsString строка содержащая файловое представление класса
     * @return класс сгенирированный на основе строки libraryObjAsString
     */
    public static PublishingHouse parsePublishingHouse(String publishingHouseAsString) {
        String[] publishingHouseInfo = publishingHouseAsString.split(separator);

        if(publishingHouseInfo.length != 7)
            return null;

        PublishingHouse result;
        result = new PublishingHouse(Integer.parseInt(publishingHouseInfo[1]),  publishingHouseInfo[2], publishingHouseInfo[3], publishingHouseInfo[4], publishingHouseInfo[5], publishingHouseInfo[6]);
        return result;
    }

    /**
     * Генерирует строку на основе класса libraryObj
     * @param publishingHouse обьект для сериализации
     * @return строка содержащая файловое представление класса
     */
    public static String formatPublishingHouse(PublishingHouse publishingHouse) {

        String result;
        result = "PublishingHouse" + separator + publishingHouse.getId() + separator + publishingHouse.getTitle() + separator + publishingHouse.getAddress() + separator;
        result += publishingHouse.getPhone() + separator + publishingHouse.getFoundationDate()+ separator + publishingHouse.getDescription();
        return result;
    }
}
