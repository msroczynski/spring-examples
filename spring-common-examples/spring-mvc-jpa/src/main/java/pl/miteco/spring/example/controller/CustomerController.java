package pl.miteco.spring.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.miteco.spring.example.model.Customers;
import pl.miteco.spring.example.service.CustomerService;

import java.util.Map;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/index")
    public String listCustomers(Map<String, Object> map) {

        map.put("customer", new Customers());
        map.put("customerList", customerService.listCustomers());

        return "customer";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addCustomer(@ModelAttribute("customer")
                              Customers customer, BindingResult result) {

        customerService.addCustomer(customer);

        return "redirect:/index";
    }

    @RequestMapping("/delete/{customerId}")
    public String deleteCustomer(@PathVariable("customerId")
                                 Integer CustomerId) {

        customerService.removeCustomer(CustomerId);

        return "redirect:/index";
    }


}