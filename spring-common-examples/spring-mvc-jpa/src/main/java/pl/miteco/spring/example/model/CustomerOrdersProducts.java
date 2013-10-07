package pl.miteco.spring.example.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created with IntelliJ IDEA.
 * User: Outbox
 * Date: 16.09.13
 * Time: 11:08
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.IdClass(pl.miteco.spring.example.model.CustomerOrdersProductsPK.class)
@javax.persistence.Table(name = "Customer_Orders_Products", schema = "crm", catalog = "crm")
@Entity
public class CustomerOrdersProducts {
    private int orderId;

    @javax.persistence.Column(name = "order_id")
    @Id
    int getOrderId() {
        return orderId;
    }

    void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    private int productId;

    @javax.persistence.Column(name = "product_id")
    @Id
    int getProductId() {
        return productId;
    }

    void setProductId(int productId) {
        this.productId = productId;
    }

    private String quantity;

    @javax.persistence.Column(name = "quantity")
    @Basic
    String getQuantity() {
        return quantity;
    }

    void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    private String comments;

    @javax.persistence.Column(name = "comments")
    @Basic
    String getComments() {
        return comments;
    }

    void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerOrdersProducts that = (CustomerOrdersProducts) o;

        if (orderId != that.orderId) return false;
        if (productId != that.productId) return false;
        if (comments != null ? !comments.equals(that.comments) : that.comments != null) return false;
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + productId;
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        return result;
    }

    private CustomerOrders customerOrdersByOrderId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "order_id", referencedColumnName = "order_id", nullable = false)
    CustomerOrders getCustomerOrdersByOrderId() {
        return customerOrdersByOrderId;
    }

    void setCustomerOrdersByOrderId(CustomerOrders customerOrdersByOrderId) {
        this.customerOrdersByOrderId = customerOrdersByOrderId;
    }

    private Products productsByProductId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
    Products getProductsByProductId() {
        return productsByProductId;
    }

    void setProductsByProductId(Products productsByProductId) {
        this.productsByProductId = productsByProductId;
    }
}
