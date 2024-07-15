package org.example.model;

import java.util.HashSet;

public class Animal {

    private HashSet<String> properties;

    public Animal() {
    }

    public Animal(HashSet<String> properties) {
        this.properties = properties;
    }

    public HashSet<String> getProperties() {
        return properties;
    }

    public void setProperties(HashSet<String> properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "Animal{" + "properties=" + properties + '}';
    }

}
