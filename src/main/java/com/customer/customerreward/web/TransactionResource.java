package com.customer.customerreward.web;

import com.customer.customerreward.service.TransactionService;
import com.customer.customerreward.service.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;

@RestController
public class TransactionResource {
    @Autowired
    TransactionService transactionService;

    @GetMapping("/customers/{id}/rewardpoints")
    int getTotalRewardPoints(@PathVariable Long id) {
        return transactionService.getRewardPoints(id, null, null);
    }

    @GetMapping("/customers/{id}/rewardpoints/{startMonth}/{endMonth}")
    int getRewardPointsInRange(@PathVariable Long id,
                               @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startMonth,
                               @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endMonth) {
        return transactionService.getRewardPoints(id, startMonth, endMonth);
    }

}
