package pl.website.zuberek;


import jakarta.persistence.*;

@Entity
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;

    private String token;

    @ManyToOne(cascade = {CascadeType.ALL})
    private Register user;

    public Token() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Token(Register user, String token) {
        this.user = user;
        this.token = token;
    }

    public Register getUser() {
        return user;
    }

    public void setUser(Register user) {
        this.user = user;
    }
}
