package DAO.TextFile_impl.Serializers;

import beans.Article;
import beans.LibraryObj;

/**
 * Хранит методы сериализации/десериализации {@link LibraryObj} в текстовый файл
 */
public class ArticleSerializer implements LibrarySerializer {
    //Article    Id#Author#title#publishngHouse#PageCount#description#  Topic#Subject
    /**символ разделитель*/
    private String separator = "#";

    /**
     * Генерирует класс на основе строки
     * @param libraryObjAsString строка содержащая файловое представление класса
     * @return класс сгенирированный на основе строки libraryObjAsString
     */
    @Override
    public LibraryObj parseLibraryObj(String libraryObjAsString) {
        String[] articleInfo = libraryObjAsString.split(separator);

        if(articleInfo.length != 9)
            return null;

        LibraryObj result;
        //Article     Id#Author#title#publishngHouse#PageCount#description#  Topic#Subject
        result = new Article(Integer.parseInt(articleInfo[1]), Integer.parseInt(articleInfo[2]), articleInfo[3], Integer.parseInt(articleInfo[4]), Integer.parseInt(articleInfo[5]),articleInfo[6], articleInfo[7], articleInfo[8]);

        return result;
    }

    /**
     * Генерирует строку на основе обьекта libraryObj
     * @param libraryObj обьект для сериализации
     * @return строка содержащая файловое представление класса
     */
    @Override
    public String formatLibraryObj(LibraryObj libraryObj) {

        if(!(libraryObj instanceof Article))
            return null;

        Article article = (Article)libraryObj;

        String result;
        result = "Article" + separator + article.getId() + separator + article.getAuthorId() + separator + article.getTitle() + separator + article.getPublishingHouseId();
        result += separator + article.getPagesNum() + separator + article.getDescription() + separator + article.getTopic() + separator + article.getSubject();
        return result;
    }
}
