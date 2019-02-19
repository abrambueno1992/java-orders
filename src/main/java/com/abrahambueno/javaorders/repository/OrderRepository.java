package com.abrahambueno.javaorders.repository;

import com.abrahambueno.javaorders.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
