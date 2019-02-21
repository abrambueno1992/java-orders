package com.abrahambueno.javaorders.repository;

import com.abrahambueno.javaorders.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(value = "delete from orders where oders.custcode = :custcode", nativeQuery = true)
    void deleteAllByCustCode(Long custcode);
}