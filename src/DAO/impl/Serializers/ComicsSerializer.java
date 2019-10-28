package DAO.impl.Serializers;

import beans.Comics;
import beans.LibraryObj;

public class ComicsSerializer implements LibrarySerializer{
    //Comics    Id#Author#title#publishngHouse#PageCount#description#  drawing#universe
    private String separator = "#";
    @Override
    public LibraryObj ParseLibraryObj(String libraryObjAsString) {
        String[] comicsInfo = libraryObjAsString.split(separator);

        if(comicsInfo.length != 9)
            return null;

        LibraryObj result;
        //Comics    Id#Author#title#publishngHouse#PageCount#description#  drawing#universe
        result = new Comics(Integer.parseInt(comicsInfo[1]), Integer.parseInt(comicsInfo[2]), comicsInfo[3], Integer.parseInt(comicsInfo[4]), Integer.parseInt(comicsInfo[5]),comicsInfo[6], comicsInfo[7], comicsInfo[8]);
        return result;
    }

    @Override
    public String FormatLibraryObj(LibraryObj libraryObj) {
        if(!(libraryObj instanceof Comics))
            return null;

        Comics comics = (Comics)libraryObj;
        String result;
        result = "Comics" + separator + comics.getId() + separator + comics.getAuthorId() + separator + comics.getTitle() + separator + comics.getPublishingHouseId() + separator;
        result += comics.getPagesNum() + separator + comics.getDescription() + separator + comics.getDrawing() + separator + comics.getUniverse();
        return result;
    }   //Comics    Id#Author#title#publishngHouse#PageCount#description#  drawing#universe
}
