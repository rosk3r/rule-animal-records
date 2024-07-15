package org.example.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class AnimalTest {

    private Animal animal;

    @BeforeEach
    public void setUp() {
        animal = new Animal();
    }

    @Test
    public void testDefaultConstructor() {
        Assertions.assertNotNull(animal);
        Assertions.assertNull(animal.getProperties());
    }

    @Test
    public void testParameterizedConstructor() {
        HashSet<String> properties = new HashSet<>();
        properties.add("HERBIVORE");
        properties.add("HEAVY");

        Animal animal = new Animal(properties);

        Assertions.assertNotNull(animal);
        Assertions.assertEquals(properties, animal.getProperties());
    }

    @Test
    public void testGetProperties() {
        HashSet<String> properties = new HashSet<>();
        properties.add("HERBIVORE");
        properties.add("HEAVY");

        animal.setProperties(properties);

        Assertions.assertEquals(properties, animal.getProperties());
    }

    @Test
    public void testSetProperties() {
        HashSet<String> properties = new HashSet<>();
        properties.add("LIGHT");
        properties.add("SMALL");

        animal.setProperties(properties);

        Assertions.assertEquals(properties, animal.getProperties());
    }

    @Test
    public void testToString() {
        HashSet<String> properties = new HashSet<>();
        properties.add("LIGHT");
        properties.add("SMALL");

        animal.setProperties(properties);

        String expectedToString = "Animal{properties=" + properties + "}";
        Assertions.assertEquals(expectedToString, animal.toString());
    }
}
