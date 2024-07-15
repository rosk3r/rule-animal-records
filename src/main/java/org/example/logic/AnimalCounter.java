package org.example.logic;

import org.example.model.Animal;
import org.example.model.Condition;

import java.util.HashSet;
import java.util.List;

public class AnimalCounter {

    public int countAnimals(List<Animal> animals, HashSet<Condition> conditions) {
        AnimalPredicate predicate = new AnimalPredicate(conditions);

        return (int) animals.stream().filter(predicate).count();
    }

}
