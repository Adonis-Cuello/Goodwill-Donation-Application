package goodwill.donation.com.GoodwillApplication.model;

import org.apache.logging.log4j.util.Strings;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Form {

//    User tempUser = new User("Adonis Cuello", "123 Walnut Street Newark, De", "456 Goodwill Drive");
//    Product tempProduct = new Product("Clothing", "lightly worn t-shirt", 0, 0);

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

//    @OneToOne(cascade = CascadeType.ALL)
//    private User user;
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    private Product product;

    private String date;
    private String fullName;
    private String address;
    private String description;
    private String donorNotes;
    private Integer boxes;
    private Integer bags;
    private Integer taxYear;
    private Integer receiptValue;
    private String signature;
    private String donoLocation;

    public Form(){}

    public Form(String date, String fullName, String address, String description, String donorNotes, Integer boxes, Integer bags, Integer taxYear, Integer receiptValue, String signature, String donoLocation) {
        this.date = date;
        this.fullName = fullName;
        this.address = address;
        this.description = description;
        this.donorNotes = donorNotes;
        this.boxes = boxes;
        this.bags = bags;
        this.taxYear = taxYear;
        this.receiptValue = receiptValue;
        this.signature = signature;
        this.donoLocation = donoLocation;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDonorNotes() {
        return donorNotes;
    }

    public void setDonorNotes(String donorNotes) {
        this.donorNotes = donorNotes;
    }

    public Integer getBoxes() {
        return boxes;
    }

    public void setBoxes(Integer boxes) {
        this.boxes = boxes;
    }

    public Integer getBags() {
        return bags;
    }

    public void setBags(Integer bags) {
        this.bags = bags;
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
        if (!(o instanceof Form)) return false;
        Form form = (Form) o;
        return getTaxYear() == form.getTaxYear() && getReceiptValue() == form.getReceiptValue() && getDate().equals(form.getDate()) && signature.equals(form.signature);
    }

    public static boolean isValidPoem(Form form) {
        return form != null && Strings.isNotBlank(form.getFullName())
                && Strings.isNotBlank(form.getAddress())
                && Strings.isNotBlank(form.getDate());
    }

    @Override
    public String toString() {
        return "Form{" +
                ", date='" + date + '\'' +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", donorNotes='" + donorNotes + '\'' +
                ", boxes=" + boxes +
                ", bags=" + bags +
                ", taxYear=" + taxYear +
                ", receipt value=" + receiptValue +
                ", signature='" + signature + '\'' +
                ", donoLocation='" + donoLocation + '\'' +
                '}';
    }
}
