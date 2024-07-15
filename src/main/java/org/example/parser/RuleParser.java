package org.example.parser;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.example.model.Rule;

import java.io.IOException;
import java.util.List;

public class RuleParser implements Parser<Rule> {

    private final ObjectMapper mapper;
    private final CollectionType collectionType;

    public RuleParser(ObjectMapper mapper) {
        this.mapper = mapper;
        collectionType = mapper.getTypeFactory().constructCollectionType(List.class, Rule.class);
    }

    public List<Rule> parse(String json) {
        try {
            JsonNode rootNode = mapper.readTree(json);

            return mapper.readValue(rootNode.toString(), collectionType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
