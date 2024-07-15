package org.example.model;

import java.util.HashSet;

public class Rule {

    private String description;
    private HashSet<Condition> conditions;

    public Rule() {
    }

    public Rule(String description, HashSet<Condition> conditions) {
        this.description = description;
        this.conditions = conditions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public HashSet<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(HashSet<Condition> conditions) {
        this.conditions = conditions;
    }

    @Override
    public String toString() {
        return "Rule{" + "description='" + description + '\'' + ", conditions=" + conditions + '}';
    }

}