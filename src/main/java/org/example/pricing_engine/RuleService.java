package org.example.pricing_engine;

import org.springframework.expression.Expression;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

public class RuleService {
    private final RulesRepository rulesRepository;

    public static Optional<BigDecimal> evaluateRule(Expression expression, Map<String, Object> contextMap) {
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setVariables(contextMap);
        return Optional.ofNullable(expression.getValue(context, BigDecimal.class));
    }

    public RuleService(RulesRepository rulesRepository) {
        this.rulesRepository = rulesRepository;
    }

    public boolean isValid(PricingRequest request) {
        //TODO: implement it
        return true;
    }

    public BigDecimal getFinalPrice(PricingRequest request) {

        Map<String, Object> context = request.getRequestProperties();

        BigDecimal price = BigDecimal.valueOf(0);
        for(Rule rule: rulesRepository.getRules()) {
            // Execute rules one by one, overwriting price everytime in context
            context.put("price", price);
            BigDecimal priceComponent = evaluateRule(rule.expression, context).orElseGet(() -> BigDecimal.ZERO);
            price = price.add(priceComponent);
        }
        // TODO: store to audit
        return price;
    }
}
