package pl.miteco.spring.example.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: Outbox
 * Date: 16.09.13
 * Time: 11:08
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "Customers_Payment_Methods", schema = "crm", catalog = "crm")
@Entity
public class CustomersPaymentMethods {
    private int customerPaymentMethodId;

    @javax.persistence.Column(name = "customer_payment_method_id")
    @Id
    int getCustomerPaymentMethodId() {
        return customerPaymentMethodId;
    }

    void setCustomerPaymentMethodId(int customerPaymentMethodId) {
        this.customerPaymentMethodId = customerPaymentMethodId;
    }

    private String cardNumber;

    @javax.persistence.Column(name = "card_number")
    @Basic
    String getCardNumber() {
        return cardNumber;
    }

    void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    private Timestamp dateFrom;

    @javax.persistence.Column(name = "date_from")
    @Basic
    Timestamp getDateFrom() {
        return dateFrom;
    }

    void setDateFrom(Timestamp dateFrom) {
        this.dateFrom = dateFrom;
    }

    private Timestamp dateTo;

    @javax.persistence.Column(name = "date_to")
    @Basic
    Timestamp getDateTo() {
        return dateTo;
    }

    void setDateTo(Timestamp dateTo) {
        this.dateTo = dateTo;
    }

    private String otherDetails;

    @javax.persistence.Column(name = "other_details")
    @Basic
    String getOtherDetails() {
        return otherDetails;
    }

    void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomersPaymentMethods that = (CustomersPaymentMethods) o;

        if (customerPaymentMethodId != that.customerPaymentMethodId) return false;
        if (cardNumber != null ? !cardNumber.equals(that.cardNumber) : that.cardNumber != null) return false;
        if (dateFrom != null ? !dateFrom.equals(that.dateFrom) : that.dateFrom != null) return false;
        if (dateTo != null ? !dateTo.equals(that.dateTo) : that.dateTo != null) return false;
        if (otherDetails != null ? !otherDetails.equals(that.otherDetails) : that.otherDetails != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerPaymentMethodId;
        result = 31 * result + (cardNumber != null ? cardNumber.hashCode() : 0);
        result = 31 * result + (dateFrom != null ? dateFrom.hashCode() : 0);
        result = 31 * result + (dateTo != null ? dateTo.hashCode() : 0);
        result = 31 * result + (otherDetails != null ? otherDetails.hashCode() : 0);
        return result;
    }

    private Collection<CustomerOrders> customerOrdersesByCustomerPaymentMethodId;

    @OneToMany(mappedBy = "customersPaymentMethodsByCustomerPaymentMethodId")
    Collection<CustomerOrders> getCustomerOrdersesByCustomerPaymentMethodId() {
        return customerOrdersesByCustomerPaymentMethodId;
    }

    void setCustomerOrdersesByCustomerPaymentMethodId(Collection<CustomerOrders> customerOrdersesByCustomerPaymentMethodId) {
        this.customerOrdersesByCustomerPaymentMethodId = customerOrdersesByCustomerPaymentMethodId;
    }

    private Customers customersByCustomerId;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
    Customers getCustomersByCustomerId() {
        return customersByCustomerId;
    }

    void setCustomersByCustomerId(Customers customersByCustomerId) {
        this.customersByCustomerId = customersByCustomerId;
    }

    private RefPaymentMethods refPaymentMethodsByPaymentMethodCode;

    @ManyToOne
    @JoinColumn(name = "payment_method_code", referencedColumnName = "payment_method_code", nullable = false)
    RefPaymentMethods getRefPaymentMethodsByPaymentMethodCode() {
        return refPaymentMethodsByPaymentMethodCode;
    }

    void setRefPaymentMethodsByPaymentMethodCode(RefPaymentMethods refPaymentMethodsByPaymentMethodCode) {
        this.refPaymentMethodsByPaymentMethodCode = refPaymentMethodsByPaymentMethodCode;
    }
}
