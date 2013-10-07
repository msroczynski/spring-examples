package pl.miteco.spring.example.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: Outbox
 * Date: 16.09.13
 * Time: 11:08
 * To change this template use File | Settings | File Templates.
 */
public class CustomerOrdersDeliveryPK implements Serializable {
    private int orderId;

    @Id
    @Column(name = "order_id")
    int getOrderId() {
        return orderId;
    }

    void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    private Timestamp dateReported;

    @Id
    @Column(name = "date_reported")
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

        CustomerOrdersDeliveryPK that = (CustomerOrdersDeliveryPK) o;

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
}
