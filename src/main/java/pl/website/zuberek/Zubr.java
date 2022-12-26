package pl.website.zuberek;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Zubr {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String zubrName;

    private String yourCharity;

    private String image;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getZubrName() {
        return zubrName;
    }

    public void setZubrName(String zubrName) {
        this.zubrName = zubrName;
    }

    public String getYourCharity() {
        return yourCharity;
    }
    public void setYourCharity(String yourCharity) {
        this.yourCharity = yourCharity;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

}