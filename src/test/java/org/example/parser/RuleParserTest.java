package org.example.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RuleParserTest {

    RuleParser ruleParser;

    @BeforeEach
    public void setUp() {
        ruleParser = new RuleParser(new ObjectMapper());
    }

    @Test
    public void testParseAnimal() {
        String json = "[{\"description\": \"How many animals – OMNIVORE\"," +
                "\"conditions\": [{" +
                "\"name\": \"TYPE\"," +
                "\"values\": [\"OMNIVORE\"]" +
                "}]}]";

        List<Rule> rules = ruleParser.parse(json);

        assertNotNull(rules);
        assertEquals(1, rules.size());

        Rule rule = rules.get(0);
        assertNotNull(rule);
        assertNotNull(rule.getConditions());
        assertEquals(1, rule.getConditions().size());
        assertTrue(rule.getDescription().contains("OMNIVORE"));
    }

}
