package model;


import com.sun.istack.internal.NotNull;

import javax.persistence.*;

@Entity
@Table
public class User {
    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name="user_email",unique = true, nullable = false)
    private String email;
    @Column(name="user_lastname", nullable = false)
    private String lastName;
    @Column(name="user_firstname", nullable = false)
    private String firstName;
    @Column(name="user_pass",nullable = false)
    private char[] password;
    @Column(name ="user_months",nullable = false)
    private int subscrtionMonths;

    public User(){}

    public User(int id, String email, String lastName, String firstName, char[] password, int subscrtionMonths) {
        Id = id;
        this.email = email;
        this.lastName = lastName;
        this.firstName = firstName;
        this.password = password;
        this.subscrtionMonths=subscrtionMonths;
    }

    public int getId(){
        return Id;
    }

    public void setId(int id){
        Id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public int getSubscrtionMonths() {
        return subscrtionMonths;
    }

    public void setSubscrtionMonths(int subscrtionMonths) {
        this.subscrtionMonths = subscrtionMonths;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + Id +
                ", email='" + email + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                '}'+'\n';
    }
}
