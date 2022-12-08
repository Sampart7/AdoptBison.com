package pl.website.zuberek;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String name;
    private String email;

    private String zubr_name;

    private String your_charity;

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
        return zubr_name;
    }

    public void setZubrName(String zubr_name) {
        this.zubr_name = zubr_name;
    }

    public String getYourCharity() {
        return your_charity;
    }
    public void setYourCharity(String your_charity) {
        this.your_charity = your_charity;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}