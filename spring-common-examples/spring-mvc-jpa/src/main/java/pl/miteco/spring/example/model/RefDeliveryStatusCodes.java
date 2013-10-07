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
@javax.persistence.Table(name = "Ref_Delivery_Status_Codes", schema = "crm", catalog = "crm")
@Entity
public class RefDeliveryStatusCodes {
    private String deliveryStatusCode;

    @javax.persistence.Column(name = "delivery_status_code")
    @Id
    String getDeliveryStatusCode() {
        return deliveryStatusCode;
    }

    void setDeliveryStatusCode(String deliveryStatusCode) {
        this.deliveryStatusCode = deliveryStatusCode;
    }

    private String deliveryStatusDescription;

    @javax.persistence.Column(name = "delivery_status_description")
    @Basic
    String getDeliveryStatusDescription() {
        return deliveryStatusDescription;
    }

    void setDeliveryStatusDescription(String deliveryStatusDescription) {
        this.deliveryStatusDescription = deliveryStatusDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RefDeliveryStatusCodes that = (RefDeliveryStatusCodes) o;

        if (deliveryStatusCode != null ? !deliveryStatusCode.equals(that.deliveryStatusCode) : that.deliveryStatusCode != null)
            return false;
        if (deliveryStatusDescription != null ? !deliveryStatusDescription.equals(that.deliveryStatusDescription) : that.deliveryStatusDescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = deliveryStatusCode != null ? deliveryStatusCode.hashCode() : 0;
        result = 31 * result + (deliveryStatusDescription != null ? deliveryStatusDescription.hashCode() : 0);
        return result;
    }

    private Collection<CustomerOrdersDelivery> customerOrdersDeliveriesByDeliveryStatusCode;

    @OneToMany(mappedBy = "refDeliveryStatusCodesByDeliveryStatusCode")
    Collection<CustomerOrdersDelivery> getCustomerOrdersDeliveriesByDeliveryStatusCode() {
        return customerOrdersDeliveriesByDeliveryStatusCode;
    }

    void setCustomerOrdersDeliveriesByDeliveryStatusCode(Collection<CustomerOrdersDelivery> customerOrdersDeliveriesByDeliveryStatusCode) {
        this.customerOrdersDeliveriesByDeliveryStatusCode = customerOrdersDeliveriesByDeliveryStatusCode;
    }
}
