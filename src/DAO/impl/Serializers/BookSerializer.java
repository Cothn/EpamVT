package DAO.impl.Serializers;


import beans.Book;
import beans.LibraryObj;

/**
 * Хранит методы сериализации/десериализации {@link LibraryObj} в текстовый файл
 */
public class BookSerializer implements LibrarySerializer {
    //Book    Id#Author#title#publishngHouse#PageCount#description#  Genre#ISBN
    /**символ разделитель*/
    private String separator = "#";//

    /**
     * Генерирует класс на основе строки
     * @param libraryObjAsString строка содержащая файловое представление класса
     * @return класс сгенирированный на основе строки libraryObjAsString
     */
    @Override
    public LibraryObj ParseLibraryObj(String libraryObjAsString) {
        String[] bookInfo = libraryObjAsString.split(separator);

        if(bookInfo.length != 9)
            return null;

        LibraryObj result;
        //Book    Id#Author#title#publishngHouse#PageCount#description#  Genre#ISBN
        result = new Book(Integer.parseInt(bookInfo[1]), Integer.parseInt(bookInfo[2]), bookInfo[3], Integer.parseInt(bookInfo[4]), Integer.parseInt(bookInfo[5]),bookInfo[6], bookInfo[7], bookInfo[8]);

        return result;
    }

    /**
     * Генерирует строку на основе класса libraryObj
     * @param libraryObj обьект для сериализации
     * @return строка содержащая файловое представление класса
     */
    @Override
    public String FormatLibraryObj(LibraryObj libraryObj) {
        if(!(libraryObj instanceof Book))
            return null;

        Book book = (Book)libraryObj;
        String result;
        result = "Book" + separator + book.getId() + separator + book.getAuthorId() + separator + book.getTitle() + separator + book.getPublishingHouseId() + separator;
        result += book.getPagesNum() + separator + book.getDescription() + separator + book.getGenre() + separator + book.getISBN();
        return result;
    }    //Book    Id#Author#title#publishngHouse#PageCount#description#  Genre#ISBN
}
