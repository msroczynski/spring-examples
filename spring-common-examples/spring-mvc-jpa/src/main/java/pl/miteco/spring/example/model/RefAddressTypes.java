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
@javax.persistence.Table(name = "Ref_Address_Types", schema = "crm", catalog = "crm")
@Entity
public class RefAddressTypes {
    private String addressTypeCode;

    @javax.persistence.Column(name = "address_type_code")
    @Id
    String getAddressTypeCode() {
        return addressTypeCode;
    }

    void setAddressTypeCode(String addressTypeCode) {
        this.addressTypeCode = addressTypeCode;
    }

    private String addressTypeDescription;

    @javax.persistence.Column(name = "address_type_description")
    @Basic
    String getAddressTypeDescription() {
        return addressTypeDescription;
    }

    void setAddressTypeDescription(String addressTypeDescription) {
        this.addressTypeDescription = addressTypeDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RefAddressTypes that = (RefAddressTypes) o;

        if (addressTypeCode != null ? !addressTypeCode.equals(that.addressTypeCode) : that.addressTypeCode != null)
            return false;
        if (addressTypeDescription != null ? !addressTypeDescription.equals(that.addressTypeDescription) : that.addressTypeDescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = addressTypeCode != null ? addressTypeCode.hashCode() : 0;
        result = 31 * result + (addressTypeDescription != null ? addressTypeDescription.hashCode() : 0);
        return result;
    }

    private Collection<CustomerAddresses> customerAddressesesByAddressTypeCode;

    @OneToMany(mappedBy = "refAddressTypesByAddressTypeCode")
    Collection<CustomerAddresses> getCustomerAddressesesByAddressTypeCode() {
        return customerAddressesesByAddressTypeCode;
    }

    void setCustomerAddressesesByAddressTypeCode(Collection<CustomerAddresses> customerAddressesesByAddressTypeCode) {
        this.customerAddressesesByAddressTypeCode = customerAddressesesByAddressTypeCode;
    }
}
