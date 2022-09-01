package com.customer.customerreward.service;

import com.customer.customerreward.domain.Transaction;
import com.customer.customerreward.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    TransactionRepository transactionRepository;

    public TransactionServiceImpl() {}

    @Override
    public int getRewardPoints(long id, LocalDate startMonth, LocalDate endMonth) {
        BigDecimal total = getTransactionSum(id, startMonth, endMonth);
        int intVal = total.intValue();
        int numOfPoints = 0;
        if (intVal < 50) {
            return 0;
        } else if (intVal < 100) {
            numOfPoints += intVal - 50;
        } else {
            numOfPoints += 50;
            numOfPoints += (intVal-100) * 2;
        }
        return numOfPoints;
    }

    private BigDecimal getTransactionSum(long id, LocalDate startMonth, LocalDate endMonth) {
        List<Transaction> transactions;

        if(startMonth == null || endMonth == null) {
            transactions = transactionRepository.findByCustomerId(id);
        } else {
            transactions = transactionRepository.findByCustomerIdAndDate(id, startMonth, endMonth);
        }
        BigDecimal res = new BigDecimal("0.00");
        for (Transaction t : transactions) {
            res = res.add(t.getAmount());
        }
        return res;
    }

}
