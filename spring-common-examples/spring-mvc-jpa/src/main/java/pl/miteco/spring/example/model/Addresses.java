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
@Entity
public class Addresses {
    private int addressId;

    @javax.persistence.Column(name = "address_id")
    @Id
    int getAddressId() {
        return addressId;
    }

    void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    private String line1;

    @javax.persistence.Column(name = "line_1")
    @Basic
    String getLine1() {
        return line1;
    }

    void setLine1(String line1) {
        this.line1 = line1;
    }

    private String line2;

    @javax.persistence.Column(name = "line_2")
    @Basic
    String getLine2() {
        return line2;
    }

    void setLine2(String line2) {
        this.line2 = line2;
    }

    private String line3;

    @javax.persistence.Column(name = "line_3")
    @Basic
    String getLine3() {
        return line3;
    }

    void setLine3(String line3) {
        this.line3 = line3;
    }

    private String city;

    @javax.persistence.Column(name = "city")
    @Basic
    String getCity() {
        return city;
    }

    void setCity(String city) {
        this.city = city;
    }

    private String zipPostcode;

    @javax.persistence.Column(name = "zip_postcode")
    @Basic
    String getZipPostcode() {
        return zipPostcode;
    }

    void setZipPostcode(String zipPostcode) {
        this.zipPostcode = zipPostcode;
    }

    private String stateProvinceCounty;

    @javax.persistence.Column(name = "state_province_county")
    @Basic
    String getStateProvinceCounty() {
        return stateProvinceCounty;
    }

    void setStateProvinceCounty(String stateProvinceCounty) {
        this.stateProvinceCounty = stateProvinceCounty;
    }

    private String isoCountryCode;

    @javax.persistence.Column(name = "iso_country_code")
    @Basic
    String getIsoCountryCode() {
        return isoCountryCode;
    }

    void setIsoCountryCode(String isoCountryCode) {
        this.isoCountryCode = isoCountryCode;
    }

    private String otherAddressDetails;

    @javax.persistence.Column(name = "other_address_details")
    @Basic
    String getOtherAddressDetails() {
        return otherAddressDetails;
    }

    void setOtherAddressDetails(String otherAddressDetails) {
        this.otherAddressDetails = otherAddressDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Addresses addresses = (Addresses) o;

        if (addressId != addresses.addressId) return false;
        if (city != null ? !city.equals(addresses.city) : addresses.city != null) return false;
        if (isoCountryCode != null ? !isoCountryCode.equals(addresses.isoCountryCode) : addresses.isoCountryCode != null)
            return false;
        if (line1 != null ? !line1.equals(addresses.line1) : addresses.line1 != null) return false;
        if (line2 != null ? !line2.equals(addresses.line2) : addresses.line2 != null) return false;
        if (line3 != null ? !line3.equals(addresses.line3) : addresses.line3 != null) return false;
        if (otherAddressDetails != null ? !otherAddressDetails.equals(addresses.otherAddressDetails) : addresses.otherAddressDetails != null)
            return false;
        if (stateProvinceCounty != null ? !stateProvinceCounty.equals(addresses.stateProvinceCounty) : addresses.stateProvinceCounty != null)
            return false;
        if (zipPostcode != null ? !zipPostcode.equals(addresses.zipPostcode) : addresses.zipPostcode != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = addressId;
        result = 31 * result + (line1 != null ? line1.hashCode() : 0);
        result = 31 * result + (line2 != null ? line2.hashCode() : 0);
        result = 31 * result + (line3 != null ? line3.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (zipPostcode != null ? zipPostcode.hashCode() : 0);
        result = 31 * result + (stateProvinceCounty != null ? stateProvinceCounty.hashCode() : 0);
        result = 31 * result + (isoCountryCode != null ? isoCountryCode.hashCode() : 0);
        result = 31 * result + (otherAddressDetails != null ? otherAddressDetails.hashCode() : 0);
        return result;
    }

    private Collection<CustomerAddresses> customerAddressesesByAddressId;

    @OneToMany(mappedBy = "addressesByAddressId")
    Collection<CustomerAddresses> getCustomerAddressesesByAddressId() {
        return customerAddressesesByAddressId;
    }

    void setCustomerAddressesesByAddressId(Collection<CustomerAddresses> customerAddressesesByAddressId) {
        this.customerAddressesesByAddressId = customerAddressesesByAddressId;
    }
}
