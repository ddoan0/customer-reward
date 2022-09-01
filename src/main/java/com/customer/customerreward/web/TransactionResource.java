package com.customer.customerreward.web;

import com.customer.customerreward.service.TransactionService;
import com.customer.customerreward.service.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionResource {
    @Autowired
    TransactionService transactionService;

    @GetMapping("/customers/{id}/rewardpoints")
    String getRewardPoints(@PathVariable Long id) {
        return transactionService.getRewardPoints(id);
    }

}
