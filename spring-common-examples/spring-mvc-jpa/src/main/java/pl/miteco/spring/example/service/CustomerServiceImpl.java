package pl.miteco.spring.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.miteco.spring.example.dao.CustomerDAO;
import pl.miteco.spring.example.model.Customers;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    public void addCustomer(Customers customer) {
        customerDAO.addCustomer(customer);
    }

    @Override
    public List<Customers> listCustomers() {
        return customerDAO.listCustomers();
    }

    @Override
    public void removeCustomer(Integer id) {
        customerDAO.removeCustomer(id);
    }
}
