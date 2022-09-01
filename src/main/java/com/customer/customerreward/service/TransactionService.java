package com.customer.customerreward.service;

import java.time.LocalDate;
import java.util.Date;

public interface TransactionService {
    public int getRewardPoints(long id, LocalDate startDate, LocalDate endDate);
}
