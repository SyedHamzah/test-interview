*PROBLEM*

You are building a Pricing Engine for an e-commerce/payment platform.

The platform sells products and services to customers. The final price of an order is not simply the sum of product prices. It can depend on:

- Product/category 
- Customer type
- Quantity
- Country/region
- Promotional campaigns
- Coupons
- Discounts
- Membership
- Time/date
- Tax
- Shipping
- Pricing rules

*Functional Requirements*:

- The exact pricing rules should be configurable and should not require rewriting the pricing engine whenever a new pricing rule is introduced. 
- Design and implement a configurable, extensible pricing engine where business users can introduce, prioritize, activate/deactivate and version pricing rules without requiring application code changes, while ensuring deterministic pricing, correct monetary calculations, auditability and high throughput. Additional requirements. 
- The pricing engine must determine the final payable amount for an order.

*Example*

A customer purchases:

Product: Laptop
Base Price: ₹80,000
Quantity: 2
Customer: GOLD
Country: IN
Coupon: SAVE10

The pricing engine might calculate:

- Base Amount             ₹160,000
- Quantity Discount          ₹8,000
- Gold Customer Discount     ₹7,600
- Coupon Discount           ₹14,440
- Tax                       ₹23,392
--------------------------------
- Final Price              ₹173,352
