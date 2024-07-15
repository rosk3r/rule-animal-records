package org.example.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Animal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalParserTest {

    AnimalParser animalParser;

    @BeforeEach
    public void setUp() {
        animalParser = new AnimalParser(new ObjectMapper());
    }

    @Test
    public void testParseAnimal() {
        String json = "[{\"properties\": [\"HEAVY\", \"SMALL\", \"OMNIVORE\"]}]";

        List<Animal> animals = animalParser.parse(json);

        assertNotNull(animals);
        assertEquals(1, animals.size());

        Animal animal = animals.get(0);
        assertNotNull(animal);
        assertNotNull(animal.getProperties());
        assertEquals(3, animal.getProperties().size());
        assertTrue(animal.getProperties().contains("HEAVY"));
        assertTrue(animal.getProperties().contains("SMALL"));
        assertTrue(animal.getProperties().contains("OMNIVORE"));
    }
}
