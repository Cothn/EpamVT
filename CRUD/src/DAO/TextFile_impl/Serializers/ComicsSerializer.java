package DAO.TextFile_impl.Serializers;

import beans.Comics;
import beans.LibraryObj;

/**
 * Хранит методы сериализации/десериализации {@link LibraryObj} в текстовый файл
 */
public class ComicsSerializer implements LibrarySerializer{
    //Comics    Id#Author#title#publishngHouse#PageCount#description#  drawing#universe
    /**символ разделитель*/
    private String separator = "#";

    /**
     * Генерирует класс на основе строки
     * @param libraryObjAsString строка содержащая файловое представление класса
     * @return класс сгенирированный на основе строки libraryObjAsString
     */
    @Override
    public LibraryObj parseLibraryObj(String libraryObjAsString) {
        String[] comicsInfo = libraryObjAsString.split(separator);

        if(comicsInfo.length != 9)
            return null;

        LibraryObj result;
        //Comics    Id#Author#title#publishngHouse#PageCount#description#  drawing#universe
        result = new Comics(Integer.parseInt(comicsInfo[1]), Integer.parseInt(comicsInfo[2]), comicsInfo[3], Integer.parseInt(comicsInfo[4]), Integer.parseInt(comicsInfo[5]),comicsInfo[6], comicsInfo[7], comicsInfo[8]);
        return result;
    }

    /**
     * Генерирует строку на основе класса libraryObj
     * @param libraryObj обьект для сериализации
     * @return строка содержащая файловое представление класса
     */
    @Override
    public String formatLibraryObj(LibraryObj libraryObj) {
        if(!(libraryObj instanceof Comics))
            return null;

        Comics comics = (Comics)libraryObj;
        String result;
        result = "Comics" + separator + comics.getId() + separator + comics.getAuthorId() + separator + comics.getTitle() + separator + comics.getPublishingHouseId() + separator;
        result += comics.getPagesNum() + separator + comics.getDescription() + separator + comics.getDrawing() + separator + comics.getUniverse();
        return result;
    }   //Comics    Id#Author#title#publishngHouse#PageCount#description#  drawing#universe
}
