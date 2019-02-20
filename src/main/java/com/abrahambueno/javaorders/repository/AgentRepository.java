package com.abrahambueno.javaorders.repository;

import com.abrahambueno.javaorders.models.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<Agent, Long> {

}
