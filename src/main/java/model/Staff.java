package model;

import javax.persistence.*;

@Entity
@Table
public class Staff {
    @Id
    @Column(name="staff_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name="staff_email")
    private String email;
    @Column(name="staff_pass")
    private String password;

    public Staff(){}

    public Staff(int id, String email, String password) {
        Id = id;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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
        return "Staff{" +
                "Id=" + Id +
                ", email='" + email + '\'' +
                '}'+'\n';
    }
}
