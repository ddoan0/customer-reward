package com.customer.customerreward.service;

import com.customer.customerreward.domain.Customer;
import com.customer.customerreward.domain.Transaction;
import com.customer.customerreward.repository.CustomerRepository;
import com.customer.customerreward.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    TransactionRepository transactionRepository;

    public TransactionServiceImpl() {}

    @Override
    public String getRewardPoints(long id) {
        Customer customer = customerRepository.findById(id);
        List<Transaction> transactions = transactionRepository.findByCustomerId(customer.getId());
        BigDecimal res = new BigDecimal("0.00");
        if (transactions.size() < 1) {
            return "No Transactions found";
        }
        for (Transaction t : transactions) {
            System.out.println(t.getAmount());
            res = res.add(t.getAmount());
        }
        return res.toString();
    }

}
