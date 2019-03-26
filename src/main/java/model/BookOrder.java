package model;

import javax.persistence.*;

@Entity
@Table
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column
    private int userId;
    @Column
    private String userEmail;

    public Order(int id, int userId, String userEmail) {
        Id = id;
        this.userId = userId;
        this.userEmail = userEmail;
    }

    @Override
    public String toString() {
        return "Order{" +
                "Id=" + Id +
                ", userId=" + userId +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
