package com.customer.customerreward;

import com.customer.customerreward.domain.Customer;
import com.customer.customerreward.domain.Transaction;
import com.customer.customerreward.repository.CustomerRepository;
import com.customer.customerreward.repository.TransactionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class CustomerRewardApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerRewardApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(TransactionRepository transactionRepository, CustomerRepository customerRepository) {
		return (args) -> {
			customerRepository.save(new Customer("Jack"));
			customerRepository.save(new Customer("Paul"));
			Customer customer = customerRepository.findById(1L);
			Customer customer2 = customerRepository.findById(2L);

			transactionRepository.save(new Transaction(new BigDecimal("10.00"), LocalDate.now(), customer));
			transactionRepository.save(new Transaction(new BigDecimal("20.00"), LocalDate.now(), customer));
			transactionRepository.save(new Transaction(new BigDecimal("100.00"), LocalDate.now(), customer));
			transactionRepository.save(new Transaction(new BigDecimal("51"), LocalDate.parse("2022-01-01"), customer2));
			transactionRepository.save(new Transaction(new BigDecimal("51"), LocalDate.parse("2022-04-01"), customer2));
			Iterable<Transaction> transactions = transactionRepository.findAll();
			for (Transaction t : transactions) {
				System.out.println("Transaction: " + t);
			}
		};
	}
}
