package org.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class ConditionTest {

    private Condition condition;

    @BeforeEach
    public void setUp() {
        condition = new Condition();
    }

    @Test
    public void testDefaultConstructor() {
        assertNotNull(condition);
        assertNull(condition.getName());
        assertNull(condition.getValues());
    }

    @Test
    public void testParameterizedConstructor() {
        String name = "TYPE";
        HashSet<String> values = new HashSet<>();
        values.add("OMNIVORE");
        values.add("HERBIVORE");

        Condition condition = new Condition(name, values);

        assertNotNull(condition);
        assertEquals(name, condition.getName());
        assertEquals(values, condition.getValues());
    }

    @Test
    public void testGetName() {
        String name = "TYPE";
        condition.setName(name);

        assertEquals(name, condition.getName());
    }

    @Test
    public void testSetName() {
        String name = "HEIGHT";
        condition.setName(name);

        assertEquals(name, condition.getName());
    }

    @Test
    public void testGetValues() {
        HashSet<String> values = new HashSet<>();
        values.add("LIGHT");
        values.add("HEAVY");
        condition.setValues(values);

        assertEquals(values, condition.getValues());
    }

    @Test
    public void testSetValues() {
        HashSet<String> values = new HashSet<>();
        values.add("SMALL");
        values.add("NOT_TALL");
        condition.setValues(values);

        assertEquals(values, condition.getValues());
    }

    @Test
    public void testToString() {
        String name = "WEIGHT";
        HashSet<String> values = new HashSet<>();
        values.add("LIGHT");
        values.add("HEAVY");

        condition.setName(name);
        condition.setValues(values);

        String expectedToString = "Condition{name='" + name + "', values=" + values + "}";
        assertEquals(expectedToString, condition.toString());
    }
}
