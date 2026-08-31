package org.example.pricing_engine;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class PricingEngineTest {

    @Test
    public void test_happy_path() {
        // Given - PricingRequest and a RulesRepository

        PricingRequest request = new PricingRequest(new HashMap<>(Map.of(
                "product", "Laptop",
                "basePrice", 80000,
                "quantity", 2,
                "customerType", "GOLD",
                "country", "IN",
                "coupon", "SAVE10"
        )));

        RulesRepository rulesRepository = new RulesRepository("rules.csv");

        // When
        RuleService service = new RuleService(rulesRepository);

        //service.isValid(request);
        BigDecimal finalPrice = service.getFinalPrice(request);

        // Then
        assert finalPrice.compareTo(new BigDecimal("153353")) == 0;
    }



}