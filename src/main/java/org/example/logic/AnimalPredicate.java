package org.example.logic;

import org.example.model.Animal;
import org.example.model.Condition;

import java.util.HashSet;
import java.util.function.Predicate;

public class AnimalPredicate implements Predicate<Animal> {

    private final HashSet<Condition> conditions;

    public AnimalPredicate(HashSet<Condition> conditions) {
        this.conditions = conditions;
    }

    @Override
    public boolean test(Animal animal) {
        for (Condition condition : conditions) {
            boolean matches = false;
            for (String value : condition.getValues()) {
                if (animal.getProperties().contains(value)) {
                    matches = true;
                    break;
                }
            }
            if (!matches) {
                return false;
            }
        }
        return true;
    }
}
