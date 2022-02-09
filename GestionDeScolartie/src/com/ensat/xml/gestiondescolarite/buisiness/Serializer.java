package com.GestionDeScolarite.buisiness;

import com.GestionDeScolarite.utils.enums.Type;

import java.io.IOException;

public interface Serializer<T>
{
    void serialize() throws IOException;
}
