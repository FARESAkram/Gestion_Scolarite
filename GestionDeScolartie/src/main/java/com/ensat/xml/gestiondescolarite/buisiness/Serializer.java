package com.ensat.xml.gestiondescolarite.buisiness;

import java.io.IOException;

public interface Serializer<T>
{
    void serialize() throws IOException;
    String getFullPath();
}