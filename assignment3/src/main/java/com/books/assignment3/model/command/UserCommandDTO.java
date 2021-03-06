package com.books.assignment3.model.command;

public class UserCommandDTO {
    private String email;
    private String lastName;
    private String firstName;
    private String password;
    private int subscriptionMonth;
    private String subscribed;

    public UserCommandDTO() {

    }

    public UserCommandDTO(String email, String lastName, String firstName, String password, int subscriptionMonth, String subscribed) {
        this.email = email;
        this.lastName = lastName;
        this.firstName = firstName;
        this.password = password;
        this.subscriptionMonth = subscriptionMonth;
        this.subscribed = subscribed;
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

    public int getSubscriptionMonth() {
        return subscriptionMonth;
    }

    public void setSubscriptionMonth(int subscriptionMonth) {
        this.subscriptionMonth = subscriptionMonth;
    }

    public String getSubscribed() {
        return subscribed;
    }

    public void setSubscribed(String subscribed) {
        this.subscribed = subscribed;
    }
}


