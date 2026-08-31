1. Major design decisions
   2. Keep the data points as string, so that adding new data points does not require code changes. Add a validation layer for essential inputs
   3. We will use Spring Expression language to build rules, because we cannot do a code change for a new rule
   4. Other option was to use drools, but I choose SpEl due to lack of complexity in a 2 hour code exercide
   5. Other key data points in Rules will be priority, status, version


2. Things left to implement - in order of importance
   3. Rule validation at the time of reading CSV
   4. Request validation - Lot of data type validation
   5. Unit testing of corner cases
   6. Used Plain Java, need to use Spring.
   7. Need to use DB to store audit of rule execution.
   8. Need to use a better interface (like REST) for usage of functionality
   
    
Requirements Met:
1. configurable - Check
2. extensible - Check
3. business users can introduce, prioritize, activate/deactivate and version pricing rules without requiring application code changes - Check
4. ensuring deterministic pricing - Check
5. correct monetary calculations - Check
6. auditability - Not done
7. high throughput - Depends on several factors including parallelism, HA and DB partitioning, cant really showcase in this codebase