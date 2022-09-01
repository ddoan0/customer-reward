# Customer Rewards Calculator
### Scenario:
This application aims to provide a restful endpoint that allows clients to access customer reward points.
Reward points are earned 1 point per dollar spent above $50 and 2 points per dollar
spent above $100.

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
