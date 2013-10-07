package pl.miteco.spring.example.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: Outbox
 * Date: 16.09.13
 * Time: 11:08
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "Ref_Order_Status_Codes", schema = "crm", catalog = "crm")
@Entity
public class RefOrderStatusCodes {
    private String orderStatusCode;

    @javax.persistence.Column(name = "order_status_code")
    @Id
    String getOrderStatusCode() {
        return orderStatusCode;
    }

    void setOrderStatusCode(String orderStatusCode) {
        this.orderStatusCode = orderStatusCode;
    }

    private String orderStatusDescription;

    @javax.persistence.Column(name = "order_status_description")
    @Basic
    String getOrderStatusDescription() {
        return orderStatusDescription;
    }

    void setOrderStatusDescription(String orderStatusDescription) {
        this.orderStatusDescription = orderStatusDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RefOrderStatusCodes that = (RefOrderStatusCodes) o;

        if (orderStatusCode != null ? !orderStatusCode.equals(that.orderStatusCode) : that.orderStatusCode != null)
            return false;
        if (orderStatusDescription != null ? !orderStatusDescription.equals(that.orderStatusDescription) : that.orderStatusDescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderStatusCode != null ? orderStatusCode.hashCode() : 0;
        result = 31 * result + (orderStatusDescription != null ? orderStatusDescription.hashCode() : 0);
        return result;
    }

    private Collection<CustomerOrders> customerOrdersesByOrderStatusCode;

    @OneToMany(mappedBy = "refOrderStatusCodesByOrderStatusCode")
    Collection<CustomerOrders> getCustomerOrdersesByOrderStatusCode() {
        return customerOrdersesByOrderStatusCode;
    }

    void setCustomerOrdersesByOrderStatusCode(Collection<CustomerOrders> customerOrdersesByOrderStatusCode) {
        this.customerOrdersesByOrderStatusCode = customerOrdersesByOrderStatusCode;
    }
}
