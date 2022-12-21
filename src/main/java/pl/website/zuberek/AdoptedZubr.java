package pl.website.zuberek;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AdoptedZubr {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    private String email;

    private String zubrName;

    private String yourCharity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}