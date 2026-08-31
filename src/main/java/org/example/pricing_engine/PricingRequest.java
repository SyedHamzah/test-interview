package org.example.pricing_engine;

import java.util.Map;

public class PricingRequest {
    private Map<String, Object> requestProperties;

    public PricingRequest(Map<String, Object> requestProperties) {
        this.requestProperties = requestProperties;
    }

    public Map<String, Object> getRequestProperties() {
        return requestProperties;
    }

    public void setRequestProperties(Map<String, Object> requestProperties) {
        this.requestProperties = requestProperties;
    }
}
