package pl.miteco.spring.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: Outbox
 * Date: 16.09.13
 * Time: 11:08
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.IdClass(pl.miteco.spring.example.model.CustomerOrdersDeliveryPK.class)
@javax.persistence.Table(name = "Customer_Orders_Delivery", schema = "crm", catalog = "crm")
@Entity
public class CustomerOrdersDelivery {
    private int orderId;

    @javax.persistence.Column(name = "order_id")
    @Id
    int getOrderId() {
        return orderId;
    }

    void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    private Timestamp dateReported;

    @javax.persistence.Column(name = "date_reported")
    @Id
    Timestamp getDateReported() {
        return dateReported;
    }

    void setDateReported(Timestamp dateReported) {
        this.dateReported = dateReported;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerOrdersDelivery that = (CustomerOrdersDelivery) o;

        if (orderId != that.orderId) return false;
        if (dateReported != null ? !dateReported.equals(that.dateReported) : that.dateReported != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + (dateReported != null ? dateReported.hashCode() : 0);
        return result;
    }

    private CustomerOrders customerOrdersByOrderId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "order_id", referencedColumnName = "order_id", nullable = false)
    CustomerOrders getCustomerOrdersByOrderId() {
        return customerOrdersByOrderId;
    }

    void setCustomerOrdersByOrderId(CustomerOrders customerOrdersByOrderId) {
        this.customerOrdersByOrderId = customerOrdersByOrderId;
    }

    private RefDeliveryStatusCodes refDeliveryStatusCodesByDeliveryStatusCode;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "delivery_status_code", referencedColumnName = "delivery_status_code", nullable = false)
    RefDeliveryStatusCodes getRefDeliveryStatusCodesByDeliveryStatusCode() {
        return refDeliveryStatusCodesByDeliveryStatusCode;
    }

    void setRefDeliveryStatusCodesByDeliveryStatusCode(RefDeliveryStatusCodes refDeliveryStatusCodesByDeliveryStatusCode) {
        this.refDeliveryStatusCodesByDeliveryStatusCode = refDeliveryStatusCodesByDeliveryStatusCode;
    }
}
