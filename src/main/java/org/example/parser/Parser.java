package org.example.parser;

import java.util.List;

public interface Parser<T>{

    List<T> parse(String json);

}
