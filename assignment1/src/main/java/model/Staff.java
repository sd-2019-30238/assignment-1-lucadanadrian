package model;

import javax.persistence.*;

@Entity
@Table
public class Staff {
    @Id
    @Column(name="staff_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name="staff_email", unique = true, nullable = false)
    private String email;
    @Column(name="staff_pass", nullable = false)
    private char[] password;

    public Staff(){}

    public Staff(int id, String email, char[] password) {
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

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
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
