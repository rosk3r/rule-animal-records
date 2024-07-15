package org.example.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JsonReader implements Reader {

    @Override
    public String read(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            StringBuilder json = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
            reader.close();
            return json.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
