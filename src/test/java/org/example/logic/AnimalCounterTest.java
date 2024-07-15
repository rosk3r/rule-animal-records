package org.example.logic;

import org.example.model.Animal;
import org.example.model.Condition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AnimalCounterTest {

    private List<Animal> animals;
    private AnimalCounter animalCounter;

    @BeforeEach
    public void setUp() {
        animals = List.of(
                new Animal(new HashSet<>(Set.of("LIGHT", "SMALL", "OMNIVORE"))),
                new Animal(new HashSet<>(Set.of("HEAVY", "SMALL", "HERBIVORE"))),
                new Animal(new HashSet<>(Set.of("HEAVY", "NOT_TALL", "HERBIVORE")))
        );

        animalCounter = new AnimalCounter();
    }

    @Test
    public void testCountHerbivoreAnimals() {
        HashSet<Condition> conditions = new HashSet<>();
        HashSet<String> values = new HashSet<>();
        values.add("HERBIVORE");
        conditions.add(new Condition("TYPE", values));

        int count = animalCounter.countAnimals(animals, conditions);

        Assertions.assertEquals(2, count);
    }

    @Test
    public void testCountHerbivoreOrCarnivoreAnimals() {
        HashSet<Condition> conditions = new HashSet<>();
        HashSet<String> values1 = new HashSet<>();
        values1.add("HERBIVORE");
        values1.add("CARNIVORE");
        conditions.add(new Condition("TYPE", values1));

        HashSet<String> values2 = new HashSet<>();
        values2.add("SMALL");
        conditions.add(new Condition("SIZE", values2));

        int count = animalCounter.countAnimals(animals, conditions);

        Assertions.assertEquals(1, count);
    }

    @Test
    public void testCountOmnivoreAnimals() {
        HashSet<Condition> conditions = new HashSet<>();
        HashSet<String> values1 = new HashSet<>();
        values1.add("OMNIVORE");
        conditions.add(new Condition("TYPE", values1));

        HashSet<String> values2 = new HashSet<>();
        values2.add("SMALL");
        values2.add("NOT_TALL");
        conditions.add(new Condition("SIZE", values2));

        int count = animalCounter.countAnimals(animals, conditions);

        Assertions.assertEquals(1, count);
    }

    @Test
    public void testCountLightSmallOmnivoreAnimals() {
        HashSet<Condition> conditions = new HashSet<>();
        HashSet<String> values1 = new HashSet<>();
        values1.add("LIGHT");
        conditions.add(new Condition("WEIGHT", values1));

        HashSet<String> values2 = new HashSet<>();
        values2.add("SMALL");
        conditions.add(new Condition("SIZE", values2));

        HashSet<String> values3 = new HashSet<>();
        values3.add("OMNIVORE");
        conditions.add(new Condition("TYPE", values3));

        int count = animalCounter.countAnimals(animals, conditions);

        Assertions.assertEquals(1, count);
    }
}
