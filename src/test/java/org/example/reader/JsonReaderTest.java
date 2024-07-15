package org.example.reader;

import org.junit.jupiter.api.Test;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class JsonReaderTest {

    @Test
    public void testRead() throws IOException {
        File tempFile = createTempJsonFile("{\"name\": \"TYPE\", \"values\": [\"OMNIVORE\"]}");
        JsonReader jsonReader = new JsonReader();

        String json = jsonReader.read(tempFile.getAbsolutePath());

        assertEquals("{\"name\": \"TYPE\", \"values\": [\"OMNIVORE\"]}", json);
    }

    @Test
    public void testReadIOException() {
        JsonReader jsonReader = new JsonReader();

        String nonExistentFilePath = "non_existent_file.json";

        assertThrows(RuntimeException.class, () -> {
            jsonReader.read(nonExistentFilePath);
        });
    }

    private File createTempJsonFile(String jsonContent) throws IOException {
        File tempFile = File.createTempFile("temp", ".json");
        FileWriter writer = new FileWriter(tempFile);
        writer.write(jsonContent);
        writer.close();
        return tempFile;
    }
}
