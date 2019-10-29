package DAO.impl.Serializers;

import beans.LibraryObj;

/**
 * Интерфейс сериализации/десериализации {@link LibraryObj} в текстовый файл
 */
public interface LibrarySerializer {

    /**
     * Генерирует класс на основе строки
     * @param libraryObjAsString строка содержащая файловое представление класса
     * @return класс сгенирированный на основе строки libraryObjAsString
     */
    LibraryObj ParseLibraryObj(String libraryObjAsString);

    /**
     * Генерирует строку на основе класса libraryObj
     * @param libraryObj обьект для сериализации
     * @return строка содержащая файловое представление класса
     */
    String FormatLibraryObj(LibraryObj libraryObj);
}
