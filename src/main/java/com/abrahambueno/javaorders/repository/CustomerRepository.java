package com.abrahambueno.javaorders.repository;

import com.abrahambueno.javaorders.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
