package com.customer.customerreward.repository;

import com.customer.customerreward.domain.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
}
