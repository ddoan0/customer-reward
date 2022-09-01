# Customer Rewards Calculator
### Scenario:
A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.

A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent over $50 in each transaction

(e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).

Given a record of every transaction during a three month period, calculate the reward points earned for each customer per month and total.

This project contains 2 restful endpoints



```
/customers/{id}/rewardpoints
This endpoint calculates total reward points for a customer
```

```
/customers/{id}/rewardpoints/{startMonth}/{endMonth}
This endpoint calculates reward points for a customer in a specified
time period with the startMonth and endMonth parameters in 
'YYYY-MM-DD' format
```


### Software Requirements
Java Development Kit 11+

### To run
```
./mvnw clean install
./mvnw spring-boot:run
```
This will start up a spring boot application on localhost:8080
