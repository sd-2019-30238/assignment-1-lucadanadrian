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
    @Column(name="user_email")
    private String email;
    @Column(name="user_lastname")
    private String lastName;
    @Column(name="user_firstname")
    private String firstName;
    @NotNull
    @Column(name="user_pass")
    private String password;

    public User(){}

    public User(int id, String email, String lastName, String firstName, String password) {
        Id = id;
        this.email = email;
        this.lastName = lastName;
        this.firstName = firstName;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
