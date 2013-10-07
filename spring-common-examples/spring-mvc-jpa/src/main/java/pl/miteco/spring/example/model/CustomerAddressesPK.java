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
public class CustomerAddressesPK implements Serializable {
    private int customerId;

    @Id
    @Column(name = "customer_id")
    int getCustomerId() {
        return customerId;
    }

    void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    private int addressId;

    @Id
    @Column(name = "address_id")
    int getAddressId() {
        return addressId;
    }

    void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    private Timestamp dateFrom;

    @Id
    @Column(name = "date_from")
    Timestamp getDateFrom() {
        return dateFrom;
    }

    void setDateFrom(Timestamp dateFrom) {
        this.dateFrom = dateFrom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerAddressesPK that = (CustomerAddressesPK) o;

        if (addressId != that.addressId) return false;
        if (customerId != that.customerId) return false;
        if (dateFrom != null ? !dateFrom.equals(that.dateFrom) : that.dateFrom != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerId;
        result = 31 * result + addressId;
        result = 31 * result + (dateFrom != null ? dateFrom.hashCode() : 0);
        return result;
    }
}
