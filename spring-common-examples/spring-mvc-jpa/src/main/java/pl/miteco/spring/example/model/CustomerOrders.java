package pl.miteco.spring.example.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: Outbox
 * Date: 16.09.13
 * Time: 11:08
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "Customer_Orders", schema = "crm", catalog = "crm")
@Entity
public class CustomerOrders {
    private int orderId;

    @javax.persistence.Column(name = "order_id")
    @Id
    int getOrderId() {
        return orderId;
    }

    void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    private Timestamp dateOrderPlaced;

    @javax.persistence.Column(name = "date_order_placed")
    @Basic
    Timestamp getDateOrderPlaced() {
        return dateOrderPlaced;
    }

    void setDateOrderPlaced(Timestamp dateOrderPlaced) {
        this.dateOrderPlaced = dateOrderPlaced;
    }

    private Timestamp dateOrderPaid;

    @javax.persistence.Column(name = "date_order_paid")
    @Basic
    Timestamp getDateOrderPaid() {
        return dateOrderPaid;
    }

    void setDateOrderPaid(Timestamp dateOrderPaid) {
        this.dateOrderPaid = dateOrderPaid;
    }

    private BigDecimal derTotalOrderPrice;

    @javax.persistence.Column(name = "der_total_order_price")
    @Basic
    BigDecimal getDerTotalOrderPrice() {
        return derTotalOrderPrice;
    }

    void setDerTotalOrderPrice(BigDecimal derTotalOrderPrice) {
        this.derTotalOrderPrice = derTotalOrderPrice;
    }

    private String otherOrderDetails;

    @javax.persistence.Column(name = "other_order_details")
    @Basic
    String getOtherOrderDetails() {
        return otherOrderDetails;
    }

    void setOtherOrderDetails(String otherOrderDetails) {
        this.otherOrderDetails = otherOrderDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerOrders that = (CustomerOrders) o;

        if (orderId != that.orderId) return false;
        if (dateOrderPaid != null ? !dateOrderPaid.equals(that.dateOrderPaid) : that.dateOrderPaid != null)
            return false;
        if (dateOrderPlaced != null ? !dateOrderPlaced.equals(that.dateOrderPlaced) : that.dateOrderPlaced != null)
            return false;
        if (derTotalOrderPrice != null ? !derTotalOrderPrice.equals(that.derTotalOrderPrice) : that.derTotalOrderPrice != null)
            return false;
        if (otherOrderDetails != null ? !otherOrderDetails.equals(that.otherOrderDetails) : that.otherOrderDetails != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + (dateOrderPlaced != null ? dateOrderPlaced.hashCode() : 0);
        result = 31 * result + (dateOrderPaid != null ? dateOrderPaid.hashCode() : 0);
        result = 31 * result + (derTotalOrderPrice != null ? derTotalOrderPrice.hashCode() : 0);
        result = 31 * result + (otherOrderDetails != null ? otherOrderDetails.hashCode() : 0);
        return result;
    }

    private Customers customersByCustomerId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
    Customers getCustomersByCustomerId() {
        return customersByCustomerId;
    }

    void setCustomersByCustomerId(Customers customersByCustomerId) {
        this.customersByCustomerId = customersByCustomerId;
    }

    private CustomersPaymentMethods customersPaymentMethodsByCustomerPaymentMethodId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "customer_payment_method_id", referencedColumnName = "customer_payment_method_id", nullable = false)
    CustomersPaymentMethods getCustomersPaymentMethodsByCustomerPaymentMethodId() {
        return customersPaymentMethodsByCustomerPaymentMethodId;
    }

    void setCustomersPaymentMethodsByCustomerPaymentMethodId(CustomersPaymentMethods customersPaymentMethodsByCustomerPaymentMethodId) {
        this.customersPaymentMethodsByCustomerPaymentMethodId = customersPaymentMethodsByCustomerPaymentMethodId;
    }

    private RefOrderStatusCodes refOrderStatusCodesByOrderStatusCode;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "order_status_code", referencedColumnName = "order_status_code", nullable = false)
    RefOrderStatusCodes getRefOrderStatusCodesByOrderStatusCode() {
        return refOrderStatusCodesByOrderStatusCode;
    }

    void setRefOrderStatusCodesByOrderStatusCode(RefOrderStatusCodes refOrderStatusCodesByOrderStatusCode) {
        this.refOrderStatusCodesByOrderStatusCode = refOrderStatusCodesByOrderStatusCode;
    }

    private Collection<CustomerOrdersDelivery> customerOrdersDeliveriesByOrderId;

    @OneToMany(mappedBy = "customerOrdersByOrderId")
    Collection<CustomerOrdersDelivery> getCustomerOrdersDeliveriesByOrderId() {
        return customerOrdersDeliveriesByOrderId;
    }

    void setCustomerOrdersDeliveriesByOrderId(Collection<CustomerOrdersDelivery> customerOrdersDeliveriesByOrderId) {
        this.customerOrdersDeliveriesByOrderId = customerOrdersDeliveriesByOrderId;
    }

    private Collection<CustomerOrdersProducts> customerOrdersProductsesByOrderId;

    @OneToMany(mappedBy = "customerOrdersByOrderId")
    Collection<CustomerOrdersProducts> getCustomerOrdersProductsesByOrderId() {
        return customerOrdersProductsesByOrderId;
    }

    void setCustomerOrdersProductsesByOrderId(Collection<CustomerOrdersProducts> customerOrdersProductsesByOrderId) {
        this.customerOrdersProductsesByOrderId = customerOrdersProductsesByOrderId;
    }
}
