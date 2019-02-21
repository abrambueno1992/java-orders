package com.abrahambueno.javaorders.repository;

import com.abrahambueno.javaorders.models.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AgentRepository extends JpaRepository<Agent, Long> {

    @Query(value = "select Concat('Agent Name: ', a.agentname), Concat('Customer Name: ', c.custname) from agents a, customers c WHERE a.agentcode = c.agentcode ORDER BY a.agentname", nativeQuery = true )
    List<Object[]> getAgentsAndCustomers();

    @Query(value = "select Concat('Agent Name: ', a.agentname), Concat('Order number:  ', o.ordnum ) from agents a, orders o WHERE a.agentcode = o.agentcode ORDER BY a.agentname", nativeQuery = true)
    List<Object[]> getAgentsAndOrders();

}