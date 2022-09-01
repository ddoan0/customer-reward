package com.customer.customerreward.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="transaction")
public class Transaction {
    @Id
    @GeneratedValue
    private Long id;

    private BigDecimal amount;

    private LocalDate transactionTime;

    @ManyToOne
    @JoinColumn(name="customer", nullable = false)
    private Customer customer;

    public Transaction() {}
    public Transaction(BigDecimal amount, LocalDate transactionTime, Customer customer) {
        this.amount = amount;
        this.transactionTime = transactionTime;
        this.customer = customer;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(LocalDate transactionTime) {
        this.transactionTime = transactionTime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                '}';
    }
}
