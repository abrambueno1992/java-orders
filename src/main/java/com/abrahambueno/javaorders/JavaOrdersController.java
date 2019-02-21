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

    @GetMapping("/customer/custcode/{custcode}")
    public Customer deleteCustomer(@PathVariable Long custcode) {
        customerrepos.deleteById(custcode);
        orderrepos.deleteAllByCustCode(custcode);
        return customerrepos.findByCustCode(custcode);

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

//    @PutMapping("/agents/agentcode/{agentcode}")

    @GetMapping("/agents/agentcode/{agentcode}")
    public void deleteAgentNotAssigned(@PathVariable Long agentcode) {

    }

//    @GetMapping("/orders")
//    @PostMapping("/orders")
//    @GetMapping("/orders/ordnum/{ordnum}")
//    @PutMapping("/orders/ordnum/{ordnum}")
//    @DeleteMapping("/customers/custcode/{custcode}")
}
