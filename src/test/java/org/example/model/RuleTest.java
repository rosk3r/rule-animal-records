package org.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class RuleTest {

    private Rule rule;

    @BeforeEach
    public void setUp() {
        rule = new Rule();
    }

    @Test
    public void testDefaultConstructor() {
        assertNotNull(rule);
        assertNull(rule.getDescription());
        assertNull(rule.getConditions());
    }

    @Test
    public void testParameterizedConstructor() {
        String description = "How many animals – OMNIVORE";
        HashSet<Condition> conditions = new HashSet<>();
        conditions.add(new Condition("TYPE", new HashSet<>(Set.of("OMNIVORE"))));

        Rule rule = new Rule(description, conditions);

        assertNotNull(rule);
        assertEquals(description, rule.getDescription());
        assertEquals(conditions, rule.getConditions());
    }

    @Test
    public void testGetDescription() {
        String description = "How many animals – OMNIVORE";
        rule.setDescription(description);

        assertEquals(description, rule.getDescription());
    }

    @Test
    public void testSetDescription() {
        String description = "How many animals – OMNIVORE";
        rule.setDescription(description);

        assertEquals(description, rule.getDescription());
    }

    @Test
    public void testGetConditions() {
        HashSet<Condition> conditions = new HashSet<>();
        conditions.add(new Condition("WEIGHT", new HashSet<>(Set.of("HEAVY", "LIGHT"))));
        rule.setConditions(conditions);

        assertEquals(conditions, rule.getConditions());
    }

    @Test
    public void testSetConditions() {
        HashSet<Condition> conditions = new HashSet<>();
        conditions.add(new Condition("WEIGHT", new HashSet<>(Set.of("HEAVY", "LIGHT"))));
        rule.setConditions(conditions);

        assertEquals(conditions, rule.getConditions());
    }

    @Test
    public void testToString() {
        String description = "How many animals – OMNIVORE or HERBIVORE";
        HashSet<Condition> conditions = new HashSet<>();
        conditions.add(new Condition("TYPE", new HashSet<>(Set.of("OMNIVORE", "HERBIVORE"))));

        rule.setDescription(description);
        rule.setConditions(conditions);

        String expectedToString = "Rule{description='" + description + "', conditions=" + conditions + "}";
        assertEquals(expectedToString, rule.toString());
    }
}
