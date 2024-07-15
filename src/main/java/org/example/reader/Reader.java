package org.example.reader;

import java.io.IOException;

public interface Reader {

    String read(String filePath) throws IOException;

}
