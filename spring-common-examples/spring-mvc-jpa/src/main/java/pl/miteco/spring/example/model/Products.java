package pl.miteco.spring.example.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: Outbox
 * Date: 16.09.13
 * Time: 11:08
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Products {
    private int productId;

    @javax.persistence.Column(name = "product_id")
    @Id
    int getProductId() {
        return productId;
    }

    void setProductId(int productId) {
        this.productId = productId;
    }

    private BigDecimal productPrice;

    @javax.persistence.Column(name = "product_price")
    @Basic
    BigDecimal getProductPrice() {
        return productPrice;
    }

    void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    private String bookIsbn;

    @javax.persistence.Column(name = "book_isbn")
    @Basic
    String getBookIsbn() {
        return bookIsbn;
    }

    void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    private String bookAuthor;

    @javax.persistence.Column(name = "book_author")
    @Basic
    String getBookAuthor() {
        return bookAuthor;
    }

    void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    private Timestamp bookPublicationDate;

    @javax.persistence.Column(name = "book_publication_date")
    @Basic
    Timestamp getBookPublicationDate() {
        return bookPublicationDate;
    }

    void setBookPublicationDate(Timestamp bookPublicationDate) {
        this.bookPublicationDate = bookPublicationDate;
    }

    private String bookTitle;

    @javax.persistence.Column(name = "book_title")
    @Basic
    String getBookTitle() {
        return bookTitle;
    }

    void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    private BigDecimal bookPrice;

    @javax.persistence.Column(name = "book_price")
    @Basic
    BigDecimal getBookPrice() {
        return bookPrice;
    }

    void setBookPrice(BigDecimal bookPrice) {
        this.bookPrice = bookPrice;
    }

    private String foodContainsYn;

    @javax.persistence.Column(name = "food_contains_yn")
    @Basic
    String getFoodContainsYn() {
        return foodContainsYn;
    }

    void setFoodContainsYn(String foodContainsYn) {
        this.foodContainsYn = foodContainsYn;
    }

    private String foodName;

    @javax.persistence.Column(name = "food_name")
    @Basic
    String getFoodName() {
        return foodName;
    }

    void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    private String foodDescription;

    @javax.persistence.Column(name = "food_description")
    @Basic
    String getFoodDescription() {
        return foodDescription;
    }

    void setFoodDescription(String foodDescription) {
        this.foodDescription = foodDescription;
    }

    private String foodFlavor;

    @javax.persistence.Column(name = "food_flavor")
    @Basic
    String getFoodFlavor() {
        return foodFlavor;
    }

    void setFoodFlavor(String foodFlavor) {
        this.foodFlavor = foodFlavor;
    }

    private String foodIngredients;

    @javax.persistence.Column(name = "food_ingredients")
    @Basic
    String getFoodIngredients() {
        return foodIngredients;
    }

    void setFoodIngredients(String foodIngredients) {
        this.foodIngredients = foodIngredients;
    }

    private String otherProductDetails;

    @javax.persistence.Column(name = "other_product_details")
    @Basic
    String getOtherProductDetails() {
        return otherProductDetails;
    }

    void setOtherProductDetails(String otherProductDetails) {
        this.otherProductDetails = otherProductDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Products products = (Products) o;

        if (productId != products.productId) return false;
        if (bookAuthor != null ? !bookAuthor.equals(products.bookAuthor) : products.bookAuthor != null) return false;
        if (bookIsbn != null ? !bookIsbn.equals(products.bookIsbn) : products.bookIsbn != null) return false;
        if (bookPrice != null ? !bookPrice.equals(products.bookPrice) : products.bookPrice != null) return false;
        if (bookPublicationDate != null ? !bookPublicationDate.equals(products.bookPublicationDate) : products.bookPublicationDate != null)
            return false;
        if (bookTitle != null ? !bookTitle.equals(products.bookTitle) : products.bookTitle != null) return false;
        if (foodContainsYn != null ? !foodContainsYn.equals(products.foodContainsYn) : products.foodContainsYn != null)
            return false;
        if (foodDescription != null ? !foodDescription.equals(products.foodDescription) : products.foodDescription != null)
            return false;
        if (foodFlavor != null ? !foodFlavor.equals(products.foodFlavor) : products.foodFlavor != null) return false;
        if (foodIngredients != null ? !foodIngredients.equals(products.foodIngredients) : products.foodIngredients != null)
            return false;
        if (foodName != null ? !foodName.equals(products.foodName) : products.foodName != null) return false;
        if (otherProductDetails != null ? !otherProductDetails.equals(products.otherProductDetails) : products.otherProductDetails != null)
            return false;
        if (productPrice != null ? !productPrice.equals(products.productPrice) : products.productPrice != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productId;
        result = 31 * result + (productPrice != null ? productPrice.hashCode() : 0);
        result = 31 * result + (bookIsbn != null ? bookIsbn.hashCode() : 0);
        result = 31 * result + (bookAuthor != null ? bookAuthor.hashCode() : 0);
        result = 31 * result + (bookPublicationDate != null ? bookPublicationDate.hashCode() : 0);
        result = 31 * result + (bookTitle != null ? bookTitle.hashCode() : 0);
        result = 31 * result + (bookPrice != null ? bookPrice.hashCode() : 0);
        result = 31 * result + (foodContainsYn != null ? foodContainsYn.hashCode() : 0);
        result = 31 * result + (foodName != null ? foodName.hashCode() : 0);
        result = 31 * result + (foodDescription != null ? foodDescription.hashCode() : 0);
        result = 31 * result + (foodFlavor != null ? foodFlavor.hashCode() : 0);
        result = 31 * result + (foodIngredients != null ? foodIngredients.hashCode() : 0);
        result = 31 * result + (otherProductDetails != null ? otherProductDetails.hashCode() : 0);
        return result;
    }

    private Collection<CustomerOrdersProducts> customerOrdersProductsesByProductId;

    @OneToMany(mappedBy = "productsByProductId")
    Collection<CustomerOrdersProducts> getCustomerOrdersProductsesByProductId() {
        return customerOrdersProductsesByProductId;
    }

    void setCustomerOrdersProductsesByProductId(Collection<CustomerOrdersProducts> customerOrdersProductsesByProductId) {
        this.customerOrdersProductsesByProductId = customerOrdersProductsesByProductId;
    }

    private RefProductTypes refProductTypesByProductTypeCode;

    @ManyToOne
    @JoinColumn(name = "product_type_code", referencedColumnName = "product_type_code", nullable = false)
    RefProductTypes getRefProductTypesByProductTypeCode() {
        return refProductTypesByProductTypeCode;
    }

    void setRefProductTypesByProductTypeCode(RefProductTypes refProductTypesByProductTypeCode) {
        this.refProductTypesByProductTypeCode = refProductTypesByProductTypeCode;
    }

    private Suppliers suppliersBySupplierCode;

    @ManyToOne
    @JoinColumn(name = "supplier_code", referencedColumnName = "supplier_code", nullable = false)
    Suppliers getSuppliersBySupplierCode() {
        return suppliersBySupplierCode;
    }

    void setSuppliersBySupplierCode(Suppliers suppliersBySupplierCode) {
        this.suppliersBySupplierCode = suppliersBySupplierCode;
    }
}
