package pl.miteco.spring.example.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;


@Entity
public class Customers {
    private int customerId;

    @javax.persistence.Column(name = "customer_id")
    @Id
    int getCustomerId() {
        return customerId;
    }

    void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    private String firstName;

    @javax.persistence.Column(name = "first_name")
    @Basic
    String getFirstName() {
        return firstName;
    }

    void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private String middleName;

    @javax.persistence.Column(name = "middle_name")
    @Basic
    String getMiddleName() {
        return middleName;
    }

    void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    private String lastName;

    @javax.persistence.Column(name = "last_name")
    @Basic
    String getLastName() {
        return lastName;
    }

    void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String customerPhone;

    @javax.persistence.Column(name = "customer_phone")
    @Basic
    String getCustomerPhone() {
        return customerPhone;
    }

    void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    private String customerEmail;

    @javax.persistence.Column(name = "customer_email")
    @Basic
    String getCustomerEmail() {
        return customerEmail;
    }

    void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    private String otherCustomerDetails;

    @javax.persistence.Column(name = "other_customer_details")
    @Basic
    String getOtherCustomerDetails() {
        return otherCustomerDetails;
    }

    void setOtherCustomerDetails(String otherCustomerDetails) {
        this.otherCustomerDetails = otherCustomerDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customers customers = (Customers) o;

        if (customerId != customers.customerId) return false;
        if (customerEmail != null ? !customerEmail.equals(customers.customerEmail) : customers.customerEmail != null)
            return false;
        if (customerPhone != null ? !customerPhone.equals(customers.customerPhone) : customers.customerPhone != null)
            return false;
        if (firstName != null ? !firstName.equals(customers.firstName) : customers.firstName != null) return false;
        if (lastName != null ? !lastName.equals(customers.lastName) : customers.lastName != null) return false;
        if (middleName != null ? !middleName.equals(customers.middleName) : customers.middleName != null) return false;
        if (otherCustomerDetails != null ? !otherCustomerDetails.equals(customers.otherCustomerDetails) : customers.otherCustomerDetails != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerId;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (customerPhone != null ? customerPhone.hashCode() : 0);
        result = 31 * result + (customerEmail != null ? customerEmail.hashCode() : 0);
        result = 31 * result + (otherCustomerDetails != null ? otherCustomerDetails.hashCode() : 0);
        return result;
    }

    private Collection<CustomerAddresses> customerAddressesesByCustomerId;

    @OneToMany(mappedBy = "customersByCustomerId")
    Collection<CustomerAddresses> getCustomerAddressesesByCustomerId() {
        return customerAddressesesByCustomerId;
    }

    void setCustomerAddressesesByCustomerId(Collection<CustomerAddresses> customerAddressesesByCustomerId) {
        this.customerAddressesesByCustomerId = customerAddressesesByCustomerId;
    }

    private Collection<CustomerOrders> customerOrdersesByCustomerId;

    @OneToMany(mappedBy = "customersByCustomerId")
    Collection<CustomerOrders> getCustomerOrdersesByCustomerId() {
        return customerOrdersesByCustomerId;
    }

    void setCustomerOrdersesByCustomerId(Collection<CustomerOrders> customerOrdersesByCustomerId) {
        this.customerOrdersesByCustomerId = customerOrdersesByCustomerId;
    }

    private Collection<CustomersPaymentMethods> customersPaymentMethodsesByCustomerId;

    @OneToMany(mappedBy = "customersByCustomerId")
    Collection<CustomersPaymentMethods> getCustomersPaymentMethodsesByCustomerId() {
        return customersPaymentMethodsesByCustomerId;
    }

    void setCustomersPaymentMethodsesByCustomerId(Collection<CustomersPaymentMethods> customersPaymentMethodsesByCustomerId) {
        this.customersPaymentMethodsesByCustomerId = customersPaymentMethodsesByCustomerId;
    }
}
