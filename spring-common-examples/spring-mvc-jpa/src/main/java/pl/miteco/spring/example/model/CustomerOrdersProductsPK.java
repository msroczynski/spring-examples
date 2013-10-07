package pl.miteco.spring.example.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Outbox
 * Date: 16.09.13
 * Time: 11:08
 * To change this template use File | Settings | File Templates.
 */
public class CustomerOrdersProductsPK implements Serializable {
    private int orderId;

    @Id
    @Column(name = "order_id")
    int getOrderId() {
        return orderId;
    }

    void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    private int productId;

    @Id
    @Column(name = "product_id")
    int getProductId() {
        return productId;
    }

    void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerOrdersProductsPK that = (CustomerOrdersProductsPK) o;

        if (orderId != that.orderId) return false;
        if (productId != that.productId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + productId;
        return result;
    }
}
