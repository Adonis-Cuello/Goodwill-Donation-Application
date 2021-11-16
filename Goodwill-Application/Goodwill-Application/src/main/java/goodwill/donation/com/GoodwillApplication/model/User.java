package goodwill.donation.com.GoodwillApplication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String fullName;
    private String address;
    private String donoLocation;

    public User(){}

    public User(String fullName, String address, String donoLocation){
        this.fullName = fullName;
        this.address = address;
        this.donoLocation = donoLocation;
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

    public String getDonoLocation() {
        return donoLocation;
    }

    public void setDonoLocation(String donoLocation) {
        this.donoLocation = donoLocation;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", donoLocation='" + donoLocation + '\'' +
                '}';
    }
}




