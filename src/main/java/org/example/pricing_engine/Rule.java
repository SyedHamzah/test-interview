package org.example.pricing_engine;


import org.springframework.expression.Expression;

public class Rule {
    String ruleName;
    Integer version;
    Integer priority;
    RuleStatus status;
    Expression expression;

    public Rule(String ruleName, Integer version, Integer priority, RuleStatus status, Expression expression) {
        this.ruleName = ruleName;
        this.version = version;
        this.priority = priority;
        this.status = status;
        this.expression = expression;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public RuleStatus getStatus() {
        return status;
    }

    public void setStatus(RuleStatus status) {
        this.status = status;
    }
}
