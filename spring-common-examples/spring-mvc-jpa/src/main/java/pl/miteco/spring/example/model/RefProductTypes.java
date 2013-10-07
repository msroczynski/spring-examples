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
@javax.persistence.Table(name = "Ref_Product_Types", schema = "crm", catalog = "crm")
@Entity
public class RefProductTypes {
    private String productTypeCode;

    @javax.persistence.Column(name = "product_type_code")
    @Id
    String getProductTypeCode() {
        return productTypeCode;
    }

    void setProductTypeCode(String productTypeCode) {
        this.productTypeCode = productTypeCode;
    }

    private Integer levelNumber;

    @javax.persistence.Column(name = "level_number")
    @Basic
    Integer getLevelNumber() {
        return levelNumber;
    }

    void setLevelNumber(Integer levelNumber) {
        this.levelNumber = levelNumber;
    }

    private String parentProductTypeCode;

    @javax.persistence.Column(name = "parent_product_type_code")
    @Basic
    String getParentProductTypeCode() {
        return parentProductTypeCode;
    }

    void setParentProductTypeCode(String parentProductTypeCode) {
        this.parentProductTypeCode = parentProductTypeCode;
    }

    private String productTypeDescription;

    @javax.persistence.Column(name = "product_type_description")
    @Basic
    String getProductTypeDescription() {
        return productTypeDescription;
    }

    void setProductTypeDescription(String productTypeDescription) {
        this.productTypeDescription = productTypeDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RefProductTypes that = (RefProductTypes) o;

        if (levelNumber != null ? !levelNumber.equals(that.levelNumber) : that.levelNumber != null) return false;
        if (parentProductTypeCode != null ? !parentProductTypeCode.equals(that.parentProductTypeCode) : that.parentProductTypeCode != null)
            return false;
        if (productTypeCode != null ? !productTypeCode.equals(that.productTypeCode) : that.productTypeCode != null)
            return false;
        if (productTypeDescription != null ? !productTypeDescription.equals(that.productTypeDescription) : that.productTypeDescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productTypeCode != null ? productTypeCode.hashCode() : 0;
        result = 31 * result + (levelNumber != null ? levelNumber.hashCode() : 0);
        result = 31 * result + (parentProductTypeCode != null ? parentProductTypeCode.hashCode() : 0);
        result = 31 * result + (productTypeDescription != null ? productTypeDescription.hashCode() : 0);
        return result;
    }

    private Collection<Products> productsesByProductTypeCode;

    @OneToMany(mappedBy = "refProductTypesByProductTypeCode")
    Collection<Products> getProductsesByProductTypeCode() {
        return productsesByProductTypeCode;
    }

    void setProductsesByProductTypeCode(Collection<Products> productsesByProductTypeCode) {
        this.productsesByProductTypeCode = productsesByProductTypeCode;
    }
}
