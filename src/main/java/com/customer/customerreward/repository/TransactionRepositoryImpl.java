package com.customer.customerreward.repository;

import com.customer.customerreward.domain.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Component
public class TransactionRepositoryImpl {

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<Transaction> findByCustomerId(long id) {
        String hql = "SELECT t FROM Transaction t INNER JOIN t.customer customer WHERE customer.id = ?1";
        return entityManager.createQuery(hql)
                .setParameter(1, id)
                .getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Transaction> findByCustomerIdAndDate(long id, LocalDate startDate, LocalDate endDate) {
        String hql = "SELECT t FROM Transaction t INNER JOIN t.customer customer WHERE customer.id = ?1 " +
                "AND t.transactionTime BETWEEN ?2 AND ?3";
        return entityManager.createQuery(hql)
                .setParameter(1, id)
                .setParameter(2, startDate)
                .setParameter(3, endDate)
                .getResultList();
    }
}
