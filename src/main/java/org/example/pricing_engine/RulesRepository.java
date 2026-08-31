package org.example.pricing_engine;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RulesRepository {
    private List<Rule> rules = new LinkedList<>();

    public RulesRepository(List<Rule> rules) {
        this.rules = rules;
    }

    public RulesRepository(String localCsvPath) {
        List<Map<String, String>> records = CsvUtils.readCsvIntoMap(localCsvPath);
        ExpressionParser parser = new SpelExpressionParser();
        for(Map<String, String> record: records) {
            this.rules.add(new Rule(
                    record.get("Name"),
                    Integer.parseInt(record.get("Version")),
                    Integer.parseInt(record.get("Priority")),
                    RuleStatus.valueOf(record.get("Status")),
                    parser.parseExpression(record.get("Expression"))
            ));
        }
        // TODO:Sort rules by priority, unique by version and store
        // TODO: validate rules and fail fast if invalid
    }

    public List<Rule> getRules() {
        return rules;
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }
}
