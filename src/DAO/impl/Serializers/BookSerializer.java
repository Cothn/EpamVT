package DAO.impl.Serializers;


import beans.Book;
import beans.LibraryObj;

public class BookSerializer implements LibrarySerializer {
    //Book    Id#Author#title#publishngHouse#PageCount#description#  Genre#ISBN
    private String separator = "#";
    @Override
    public LibraryObj ParseLibraryObj(String libraryObjAsString) {
        String[] bookInfo = libraryObjAsString.split(separator);

        if(bookInfo.length != 9)
            return null;

        LibraryObj result = null;
        //Book    Id#Author#title#publishngHouse#PageCount#description#  Genre#ISBN
        result = new Book(Integer.parseInt(bookInfo[1]), Integer.parseInt(bookInfo[2]), bookInfo[3], Integer.parseInt(bookInfo[4]), Integer.parseInt(bookInfo[5]),bookInfo[6], bookInfo[7], bookInfo[8]);

        return result;
    }

    @Override
    public String FormatLibraryObj(LibraryObj libraryObj) {
        if(!(libraryObj instanceof Book))
            return null;

        Book book = (Book)libraryObj;

        String result = null;
        result = "Book" + separator + book.getId() + separator + book.getAuthorId() + separator + book.getTitle() + separator + book.getPublishingHouseId() + separator;
        result += book.getPagesNum() + separator + book.getDescription() + separator + book.getGenre() + separator + book.getISBN();
        return result;
    }    //Book    Id#Author#title#publishngHouse#PageCount#description#  Genre#ISBN
}
