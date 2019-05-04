package com.assignment2.demo.model;

import javax.persistence.*;

@Entity
@Table
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "user_email", unique = true, nullable = false)
    private String email;
    @Column(name = "user_lastname", nullable = false)
    private String lastName;
    @Column(name = "user_firstname", nullable = false)
    private String firstName;
    @Column(name = "user_pass", nullable = false)
    private String password;
    @Column(name = "user_months", nullable = false)
    private int subscriptionMonths;
    @Column(name= "user_accept")
    private String subscribed;

    public User() {
    }

    public User(String email, String lastName, String firstName, String password, int subscriptionMonths, String subscribed) {
        this.email = email;
        this.lastName = lastName;
        this.firstName = firstName;
        this.password = password;
        this.subscriptionMonths = subscriptionMonths;
        this.subscribed = subscribed;
    }

    public void setSubscribed(String subscribed) {
        this.subscribed = subscribed;
    }

    public String getSubscribed() {
        return subscribed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSubscriptionMonths() {
        return subscriptionMonths;
    }

    public void setSubscriptionMonths(int subscriptionMonths) {
        this.subscriptionMonths = subscriptionMonths;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", subscriptionMonths=" + subscriptionMonths +
                '}';
    }
}
