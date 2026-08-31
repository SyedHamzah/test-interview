**Major design decisions**
 - Keep the data points as string, so that adding new data points does not require code changes. Add a validation layer for essential inputs
 - We will use Spring Expression language to build rules, because we cannot do a code change for a new rule
 - Other option was to use drools, but I choose SpEl due to lack of complexity in a 2 hour code exercide
 - Other key data points in Rules will be priority, status, version

**Things left to implement - in order of importance**
 - Rule validation at the time of reading CSV 
 - Request validation - Lot of data type validation
 - Unit testing of corner cases
 - Used Plain Java, need to use Spring.
 - Need to use DB to store audit of rule execution.
 - Need to use a better interface (like REST) for usage of functionality
   
    
**Requirements Met/Not Met checklist**:
1. configurable - Check
2. extensible - Check
3. business users can introduce, prioritize, activate/deactivate and version pricing rules without requiring application code changes - Check
4. ensuring deterministic pricing - Check
5. correct monetary calculations - Check
6. auditability - Not done
7. high throughput - Depends on several factors including parallelism, HA and DB partitioning, cant really showcase in this codebase