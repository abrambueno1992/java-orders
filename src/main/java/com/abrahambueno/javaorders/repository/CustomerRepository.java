package com.abrahambueno.javaorders.repository;

import com.abrahambueno.javaorders.models.Customer;
import com.abrahambueno.javaorders.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "select * from order where custname = :name ", nativeQuery = true)
    List<Order> findByCustName(@Param("name") String name);

    @Query(value = "select c.custname, o from customer c, order o where c.custcode = o.custcode order by c.custname", nativeQuery = true)
        List<Object[]> findAllOrders();

    @Query(value = "select * from order where custcode = :custcode", nativeQuery = true)
    List<Order> findOrdersByCustCode(@Param("custcode") Long custcode);

//    public Customer findByCustName(String name);
}