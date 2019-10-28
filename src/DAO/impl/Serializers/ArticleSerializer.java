package DAO.impl.Serializers;

import beans.Article;
import beans.LibraryObj;

public class ArticleSerializer implements LibrarySerializer {
    //Article    Id#Author#title#publishngHouse#PageCount#description#  Topic#Subject
    private String separator = "#";
    @Override
    public LibraryObj ParseLibraryObj(String libraryObjAsString) {
        String[] articleInfo = libraryObjAsString.split(separator);

        if(articleInfo.length != 9)
            return null;

        LibraryObj result = null;
        //Article     Id#Author#title#publishngHouse#PageCount#description#  Topic#Subject
        result = new Article(Integer.parseInt(articleInfo[1]), Integer.parseInt(articleInfo[2]), articleInfo[3], Integer.parseInt(articleInfo[4]), Integer.parseInt(articleInfo[5]),articleInfo[6], articleInfo[7], articleInfo[8]);

        return result;
    }

    @Override
    public String FormatLibraryObj(LibraryObj libraryObj) {

        if(!(libraryObj instanceof Article))
            return null;

        Article article = (Article)libraryObj;

        String result = null;
        result = "Article" + separator + article.getId() + separator + article.getAuthorId() + separator + article.getTitle() + separator + article.getPublishingHouseId();
        result += separator + article.getPagesNum() + separator + article.getDescription() + separator + article.getTopic() + separator + article.getSubject();
        return result;
    }
}