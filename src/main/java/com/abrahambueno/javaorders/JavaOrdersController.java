package com.abrahambueno.javaorders;

import com.abrahambueno.javaorders.models.Order;
import com.abrahambueno.javaorders.repository.AgentRepository;
import com.abrahambueno.javaorders.repository.CustomerRepository;
import com.abrahambueno.javaorders.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/agents")
    public List<Object[]> getAgentCustomers() {
        var agentsCustomers = agentrepos.getAgentsAndCustomers();
        if (agentsCustomers != null) {
            return agentsCustomers;
        } else {
            return null;
        }
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

    @GetMapping("/customer/{custcode}")
    public void deleteCustomer(@PathVariable Long custcode) {
        customerrepos.deleteById(custcode);
        orderrepos.deleteAllByCustCode(custcode);

    }


    @GetMapping("/agents/{agentcode}")
    public void deleteAgentNotAssigned(@PathVariable Long agentcode) {

    }
}
