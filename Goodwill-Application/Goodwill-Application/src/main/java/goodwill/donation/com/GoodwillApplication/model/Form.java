package goodwill.donation.com.GoodwillApplication.model;

import org.apache.logging.log4j.util.Strings;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Form{

//    User tempUser = new User("Adonis Cuello", "123 Walnut Street Newark, De", "456 Goodwill Drive");
//    Product tempProduct = new Product("Clothing", "lightly worn t-shirt", 0, 0);

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    private Product product;
//    private String date;
//    private String fullName;
//    private String address;
//    private String description;
//    private String donorNotes;
//    private Integer boxes;
//    private Integer bags;
    private Integer taxYear;
    private Integer receiptValue;
    private String signature;
    private String donoLocation;

    public Form(){}

    public Form(User user, Product product, Integer taxYear, Integer receiptValue, String signature, String donoLocation) {
        this.user = user;
        this.product = product;
        this.taxYear = taxYear;
        this.receiptValue = receiptValue;
        this.signature = signature;
        this.donoLocation = donoLocation;
    }

        public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

//    public String getDate() {
//        return date;
//    }
//
//    public void setDate(String date) {
//        this.date = date;
//    }
//
//    public String getFullName() {
//        return fullName;
//    }
//
//    public void setFullName(String fullName) {
//        this.fullName = fullName;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getDonorNotes() {
//        return donorNotes;
//    }
//
//    public void setDonorNotes(String donorNotes) {
//        this.donorNotes = donorNotes;
//    }
//
//    public Integer getBoxes() {
//        return boxes;
//    }
//
//    public void setBoxes(Integer boxes) {
//        this.boxes = boxes;
//    }
//
//    public Integer getBags() {
//        return bags;
//    }
//
//    public void setBags(Integer bags) {
//        this.bags = bags;
//    }

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Form)) return false;
        Form form = (Form) o;
        return getId().equals(form.getId()) && getUser().equals(form.getUser()) && getProduct().equals(form.getProduct()) && getTaxYear().equals(form.getTaxYear()) && getReceiptValue().equals(form.getReceiptValue()) && getSignature().equals(form.getSignature()) && getDonoLocation().equals(form.getDonoLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUser(), getProduct(), getTaxYear(), getReceiptValue(), getSignature(), getDonoLocation());
    }

    //    public static boolean isValidPoem(Form form) {
//        return form != null && Strings.isNotBlank(form.getFullName())
//                && Strings.isNotBlank(form.getAddress())
//                && Strings.isNotBlank(form.getDate());
//    }


    @Override
    public String toString() {
        return "Form{" +
                "id=" + id +
                ", user=" + user +
                ", product=" + product +
                ", taxYear=" + taxYear +
                ", receiptValue=" + receiptValue +
                ", signature='" + signature + '\'' +
                ", donoLocation='" + donoLocation + '\'' +
                '}';
    }
}
