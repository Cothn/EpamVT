package DAO.impl.Serializers;

import beans.LibraryObj;

public interface LibrarySerializer {
    LibraryObj ParseLibraryObj(String libraryObjAsString);
    String FormatLibraryObj(LibraryObj libraryObj);
}
