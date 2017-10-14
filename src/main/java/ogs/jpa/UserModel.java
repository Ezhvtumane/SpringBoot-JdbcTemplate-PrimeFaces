package ogs.jpa;

import javax.persistence.*;

@Entity
@Table(name="ogst")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    long id;

    @Column(name="name")
    String name;

    @Column(name="email")
    String email;

    public UserModel() {
    }

    public UserModel(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
