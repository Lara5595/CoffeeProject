package com.coffeproject.Models;


import javax.persistence.*;

@Entity
@Table(name = "coffee")
public class Coffee {

//    Instance Variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String roast;

    @Column(nullable = false, length = 100)
    private String coffeeName;

//    Getters and setters


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoast() {
        return roast;
    }

    public void setRoast(String roast) {
        this.roast = roast;
    }

    public String getCoffeeName() {
        return coffeeName;
    }

    public void setCoffeeName(String coffeeName) {
        this.coffeeName = coffeeName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    //    Constructors


    public Coffee() {
    }


    public Coffee(String roast, String coffeeName) {
        this.roast = roast;
        this.coffeeName = coffeeName;
    }

    public Coffee(long id, String roast, String coffeeName) {
        this.id = id;
        this.roast = roast;
        this.coffeeName = coffeeName;
    }


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
