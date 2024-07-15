package org.example.model;

import java.util.HashSet;

public class Condition {

    private String name;
    private HashSet<String> values;

    public Condition() {
    }

    public Condition(String name, HashSet<String> values) {
        this.name = name;
        this.values = values;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashSet<String> getValues() {
        return values;
    }

    public void setValues(HashSet<String> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "Condition{" + "name='" + name + '\'' + ", values=" + values + '}';
    }

}
