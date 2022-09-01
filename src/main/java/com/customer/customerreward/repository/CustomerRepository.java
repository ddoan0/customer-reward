package com.customer.customerreward.repository;

import com.customer.customerreward.domain.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByName(String name);

    Customer findById(long id);
}
