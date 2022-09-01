package com.customer.customerreward.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Customer {

    private @Id @GeneratedValue Long id;
    private String name;
    private List<Transaction> transactionsList;
}
