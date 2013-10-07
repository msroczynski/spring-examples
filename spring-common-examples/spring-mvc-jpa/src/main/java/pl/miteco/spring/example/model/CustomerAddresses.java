package pl.miteco.spring.example.model;

import javax.persistence.Basic;
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
@javax.persistence.IdClass(pl.miteco.spring.example.model.CustomerAddressesPK.class)
@javax.persistence.Table(name = "Customer_Addresses", schema = "crm", catalog = "crm")
@Entity
public class CustomerAddresses {
    private int customerId;

    @javax.persistence.Column(name = "customer_id")
    @Id
    int getCustomerId() {
        return customerId;
    }

    void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    private int addressId;

    @javax.persistence.Column(name = "address_id")
    @Id
    int getAddressId() {
        return addressId;
    }

    void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    private Timestamp dateFrom;

    @javax.persistence.Column(name = "date_from")
    @Id
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerAddresses that = (CustomerAddresses) o;

        if (addressId != that.addressId) return false;
        if (customerId != that.customerId) return false;
        if (dateFrom != null ? !dateFrom.equals(that.dateFrom) : that.dateFrom != null) return false;
        if (dateTo != null ? !dateTo.equals(that.dateTo) : that.dateTo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerId;
        result = 31 * result + addressId;
        result = 31 * result + (dateFrom != null ? dateFrom.hashCode() : 0);
        result = 31 * result + (dateTo != null ? dateTo.hashCode() : 0);
        return result;
    }

    private Addresses addressesByAddressId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "address_id", referencedColumnName = "address_id", nullable = false)
    Addresses getAddressesByAddressId() {
        return addressesByAddressId;
    }

    void setAddressesByAddressId(Addresses addressesByAddressId) {
        this.addressesByAddressId = addressesByAddressId;
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

    private RefAddressTypes refAddressTypesByAddressTypeCode;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "address_type_code", referencedColumnName = "address_type_code", nullable = false)
    RefAddressTypes getRefAddressTypesByAddressTypeCode() {
        return refAddressTypesByAddressTypeCode;
    }

    void setRefAddressTypesByAddressTypeCode(RefAddressTypes refAddressTypesByAddressTypeCode) {
        this.refAddressTypesByAddressTypeCode = refAddressTypesByAddressTypeCode;
    }
}
