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
@javax.persistence.Table(name = "Ref_Payment_Methods", schema = "crm", catalog = "crm")
@Entity
public class RefPaymentMethods {
    private String paymentMethodCode;

    @javax.persistence.Column(name = "payment_method_code")
    @Id
    String getPaymentMethodCode() {
        return paymentMethodCode;
    }

    void setPaymentMethodCode(String paymentMethodCode) {
        this.paymentMethodCode = paymentMethodCode;
    }

    private String paymentMethodDescription;

    @javax.persistence.Column(name = "payment_method_description")
    @Basic
    String getPaymentMethodDescription() {
        return paymentMethodDescription;
    }

    void setPaymentMethodDescription(String paymentMethodDescription) {
        this.paymentMethodDescription = paymentMethodDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RefPaymentMethods that = (RefPaymentMethods) o;

        if (paymentMethodCode != null ? !paymentMethodCode.equals(that.paymentMethodCode) : that.paymentMethodCode != null)
            return false;
        if (paymentMethodDescription != null ? !paymentMethodDescription.equals(that.paymentMethodDescription) : that.paymentMethodDescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = paymentMethodCode != null ? paymentMethodCode.hashCode() : 0;
        result = 31 * result + (paymentMethodDescription != null ? paymentMethodDescription.hashCode() : 0);
        return result;
    }

    private Collection<CustomersPaymentMethods> customersPaymentMethodsesByPaymentMethodCode;

    @OneToMany(mappedBy = "refPaymentMethodsByPaymentMethodCode")
    Collection<CustomersPaymentMethods> getCustomersPaymentMethodsesByPaymentMethodCode() {
        return customersPaymentMethodsesByPaymentMethodCode;
    }

    void setCustomersPaymentMethodsesByPaymentMethodCode(Collection<CustomersPaymentMethods> customersPaymentMethodsesByPaymentMethodCode) {
        this.customersPaymentMethodsesByPaymentMethodCode = customersPaymentMethodsesByPaymentMethodCode;
    }
}
