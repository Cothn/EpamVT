package DAO.impl.Serializers;

import beans.PublishingHouse;

public class PublishingHouseSerializer {
    //PublishingHouse    Id#Title#Addres#phone#birthDate#description
    private static String separator = "#";

    public static PublishingHouse ParsePublishingHouse(String publishingHouseAsString) {
        String[] publishingHouseInfo = publishingHouseAsString.split(separator);

        if(publishingHouseInfo.length != 7)
            return null;

        PublishingHouse result = null;

        result = new PublishingHouse(Integer.parseInt(publishingHouseInfo[1]),  publishingHouseInfo[2], publishingHouseInfo[3], publishingHouseInfo[4], publishingHouseInfo[5], publishingHouseInfo[6]);

        return result;
    }

    public static String FormatPublishingHouse(PublishingHouse publishingHouse) {

        String result = null;
        result = "PublishingHouse" + separator + publishingHouse.getId() + separator + publishingHouse.getTitle() + separator + publishingHouse.getAddress() + separator;
        result += publishingHouse.getPhone() + separator + publishingHouse.getFoundationDate()+ separator + publishingHouse.getDescription();
        return result;
    }
}
