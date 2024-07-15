package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Animal;
import org.example.model.Rule;
import org.example.logic.AnimalCounter;
import org.example.parser.AnimalParser;
import org.example.reader.JsonReader;
import org.example.parser.RuleParser;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        JsonReader reader = new JsonReader();

        AnimalParser animalParser = new AnimalParser(mapper);
        RuleParser ruleParser = new RuleParser(mapper);
        AnimalCounter animalCounter = new AnimalCounter();

        String rulesJson = reader.read("data/rules.json");
        String animalsJson = reader.read("data/animals.json");

        for (Rule rule : ruleParser.parse(rulesJson)) {
            List<Animal> parsed = animalParser.parse(animalsJson);
            int count = animalCounter.countAnimals(parsed, rule.getConditions());
            System.out.println(rule.getDescription() + ": " + count);
        }
    }

}