package pl.miteco.spring.example.dao;

import pl.miteco.spring.example.model.Customers;

import java.util.List;

public interface CustomerDAO {
    public void addCustomer(Customers customer);
    public List<Customers> listCustomers();
    public void removeCustomer(Integer id);
}
