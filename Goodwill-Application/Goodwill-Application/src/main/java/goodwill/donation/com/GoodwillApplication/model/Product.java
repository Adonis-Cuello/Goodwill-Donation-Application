package goodwill.donation.com.GoodwillApplication.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String description;
    private String donorNotes;
    private Integer boxes;
    private Integer bags;

    public Product(){}

    public Product(String description, String donorNotes, Integer boxes, Integer bags) {
        this.description = description;
        this.donorNotes = donorNotes;
        this.boxes = boxes;
        this.bags = bags;
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



    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", donorNotes='" + donorNotes + '\'' +
                ", boxes=" + boxes +
                ", bags=" + bags +
                '}';
    }
}
