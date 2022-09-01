package com.customer.customerreward.repository;

import com.customer.customerreward.domain.Transaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    Transaction findById(long id);
    List<Transaction> findByCustomerId(long id);
}
