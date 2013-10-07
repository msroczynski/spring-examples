package pl.miteco.spring.example.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.miteco.spring.example.model.Customers;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addCustomer(Customers customer) {
        sessionFactory.getCurrentSession().save(customer);
    }

    @Override
    public List<Customers> listCustomers() {
        return sessionFactory.getCurrentSession().createQuery("from Customers").list();
    }

    @Override
    public void removeCustomer(Integer id) {
        Customers customer = (Customers) sessionFactory.getCurrentSession().load(Customers.class, id);
        if (null != customer) {
            sessionFactory.getCurrentSession().delete(customer);
        }
    }
}