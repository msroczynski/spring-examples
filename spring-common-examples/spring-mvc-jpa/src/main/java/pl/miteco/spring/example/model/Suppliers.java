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
public class Suppliers {
    private String supplierCode;

    @javax.persistence.Column(name = "supplier_code")
    @Id
    String getSupplierCode() {
        return supplierCode;
    }

    void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    private String supplierName;

    @javax.persistence.Column(name = "supplier_name")
    @Basic
    String getSupplierName() {
        return supplierName;
    }

    void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    private String otherSupplierDetails;

    @javax.persistence.Column(name = "other_supplier_details")
    @Basic
    String getOtherSupplierDetails() {
        return otherSupplierDetails;
    }

    void setOtherSupplierDetails(String otherSupplierDetails) {
        this.otherSupplierDetails = otherSupplierDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Suppliers suppliers = (Suppliers) o;

        if (otherSupplierDetails != null ? !otherSupplierDetails.equals(suppliers.otherSupplierDetails) : suppliers.otherSupplierDetails != null)
            return false;
        if (supplierCode != null ? !supplierCode.equals(suppliers.supplierCode) : suppliers.supplierCode != null)
            return false;
        if (supplierName != null ? !supplierName.equals(suppliers.supplierName) : suppliers.supplierName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = supplierCode != null ? supplierCode.hashCode() : 0;
        result = 31 * result + (supplierName != null ? supplierName.hashCode() : 0);
        result = 31 * result + (otherSupplierDetails != null ? otherSupplierDetails.hashCode() : 0);
        return result;
    }

    private Collection<Products> productsesBySupplierCode;

    @OneToMany(mappedBy = "suppliersBySupplierCode")
    Collection<Products> getProductsesBySupplierCode() {
        return productsesBySupplierCode;
    }

    void setProductsesBySupplierCode(Collection<Products> productsesBySupplierCode) {
        this.productsesBySupplierCode = productsesBySupplierCode;
    }
}
