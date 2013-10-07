package pl.miteco.spring.example.service;

import pl.miteco.spring.example.model.Customers;

import java.util.List;

public interface CustomerService {

    public void addCustomer(Customers customer);
    public List<Customers> listCustomers();
    public void removeCustomer(Integer id);

}
