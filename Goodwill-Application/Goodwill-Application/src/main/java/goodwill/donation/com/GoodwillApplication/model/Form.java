package goodwill.donation.com.GoodwillApplication.model;

import org.apache.logging.log4j.util.Strings;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Form{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> products;

    private Integer taxYear;
    private Integer receiptValue;
    private String signature;
    private String donoLocation;

    public Form() {
    }

    public Form(User user, List<Product> products, Integer taxYear, Integer receiptValue, String signature, String donoLocation) {
        this.user = user;
        this.products = products;
        this.taxYear = taxYear;
        this.receiptValue = receiptValue;
        this.signature = signature;
        this.donoLocation = donoLocation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Integer getTaxYear() {
        return taxYear;
    }

    public void setTaxYear(Integer taxYear) {
        this.taxYear = taxYear;
    }

    public Integer getReceiptValue() {
        return receiptValue;
    }

    public void setReceiptValue(Integer receiptValue) {
        this.receiptValue = receiptValue;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getDonoLocation() {
        return donoLocation;
    }

    public void setDonoLocation(String donoLocation) {
        this.donoLocation = donoLocation;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Form form = (Form) o;
        return Objects.equals(id, form.id) && Objects.equals(user, form.user) && Objects.equals(products, form.products) && Objects.equals(taxYear, form.taxYear) && Objects.equals(receiptValue, form.receiptValue) && Objects.equals(signature, form.signature) && Objects.equals(donoLocation, form.donoLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, products, taxYear, receiptValue, signature, donoLocation);
    }

    @Override
    public String toString() {
        return "Form{" +
                "id=" + id +
                ", user=" + user +
                ", products=" + products +
                ", taxYear=" + taxYear +
                ", receiptValue=" + receiptValue +
                ", signature='" + signature + '\'' +
                ", donoLocation='" + donoLocation + '\'' +
                '}';
    }
}

