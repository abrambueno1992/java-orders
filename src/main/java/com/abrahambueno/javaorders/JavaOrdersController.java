package com.abrahambueno.javaorders;

import com.abrahambueno.javaorders.models.Agent;
import com.abrahambueno.javaorders.models.Customer;
import com.abrahambueno.javaorders.models.Order;
import com.abrahambueno.javaorders.repository.AgentRepository;
import com.abrahambueno.javaorders.repository.CustomerRepository;
import com.abrahambueno.javaorders.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = {}, produces = MediaType.APPLICATION_JSON_VALUE)
public class JavaOrdersController {
    @Autowired
    AgentRepository agentrepos;

    @Autowired
    CustomerRepository customerrepos;

    @Autowired
    OrderRepository orderrepos;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerrepos.findAll();
    }
    @PostMapping("/customers")
    public Customer createCustomer(@RequestBody Customer customer) throws URISyntaxException {
        return customerrepos.save(customer);
    }

    @GetMapping("/customer/order")
    public List<Object[]> getCustomerWithOrders() {
        var foundCustList = customerrepos.findAllOrders();
        if (foundCustList != null) {
            return foundCustList;
        } else {
            return null;
        }
    }

    @GetMapping("/customer/name/{custname}")
    public List<Order> getCustomerOrders(@PathVariable String custname) {
        var foundCustList = customerrepos.findByCustName(custname);
        if (foundCustList != null) {
            return foundCustList;
        } else {
            return null;
        }
    }


    @GetMapping("/customer/order/{custcode}")
    public List<Order> getOrdersByCustcode(@PathVariable Long custcode) throws URISyntaxException {
        var foundOrders = customerrepos.findOrdersByCustCode(custcode);
        if (foundOrders != null) {
            return foundOrders;
        } else {
            return null;
        }
    }

    @DeleteMapping("/customers/custcode/{custcode}")
    public Customer deleteCustomer(@PathVariable Long custcode) throws URISyntaxException  {
        var deleteCust = customerrepos.findById(custcode);
        if (deleteCust.isPresent()) {
            customerrepos.deleteById(custcode);
            orderrepos.deleteAllByCustCode(custcode);
            return deleteCust.get();
        } else {
            return null;
        }
    }
    @GetMapping("/agents")
    public List<Object[]> getAgentCustomers() {
        var agentsCustomers = agentrepos.getAgentsAndCustomers();
        if (agentsCustomers != null) {
            return agentsCustomers;
        } else {
            return null;
        }
    }

    @PostMapping("/agents")
    public Agent addAgent(@RequestBody Agent agent) {
        return agentrepos.save(agent);
    }

    @GetMapping("/agents/orders")
    public List<Object[]> getAgentOrders() {
        var agentOrders = agentrepos.getAgentsAndOrders();
        if (agentOrders != null) {
            return agentOrders;
        } else {
            return null;
        }

    }

    @PutMapping("/agents/agentcode/{agentcode}")
    public Agent updateAgent(@RequestBody Agent newagent, @PathVariable Long agentcode) throws URISyntaxException {
        Optional<Agent> updateAgent = agentrepos.findById(agentcode);
        if (updateAgent.isPresent()) {
            newagent.setAgentCode(agentcode);
            agentrepos.save(newagent);
            return newagent;
        } else {
            return null;
        }
    }
    @GetMapping("/agents/agentcode/{agentcode}")
    public void deleteAgentNotAssigned(@PathVariable Long agentcode) {

    }

    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return orderrepos.findAll();
    }
    @PostMapping("/orders")
    public Order createOrder(@RequestBody Order order) {
        return orderrepos.save(order);
    }
    @GetMapping("/orders/ordnum/{ordnum}")
    public Order getOrderByOrdnum(@PathVariable Long ordnum) {
        var orderReturned = orderrepos.findById(ordnum);
        if (orderReturned.isPresent()) {
            return orderReturned.get();
        } else {
            return null;
        }
    }

    @PutMapping("/orders/ordnum/{ordnum}")
    public Order updateOrder(@RequestBody Order neworder, @PathVariable Long ordnum) throws URISyntaxException {
        Optional<Order> updateOrder = orderrepos.findById(ordnum);
        if (updateOrder.isPresent()) {
            neworder.setOrdNum(ordnum);
            orderrepos.save(neworder);
            return neworder;
        } else {
            return null;
        }
    }

}
