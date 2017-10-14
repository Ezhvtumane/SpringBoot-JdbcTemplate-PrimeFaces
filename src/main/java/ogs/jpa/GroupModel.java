package ogs.jpa;

import ogs.jdbc.User;
import org.hibernate.envers.Audited;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Audited
@Entity
@Table(name="groups")
public class GroupModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name="id")
    long id;

    @Column(name="name")
    String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_group",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    List<UserModel> userModels = new ArrayList<UserModel>();

    public GroupModel() {
    }

    public List<UserModel> getUserModels() {
        return userModels;
    }

    public void setUserModels(List<UserModel> userModels) {
        this.userModels = userModels;
    }

    @Override
    public String toString() {
        return "GroupModel{" +
                "name='" + name + '\'' +
                '}';
    }
}
