package ogs.jpa;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Audited
@AuditTable(value = "users_aud_perf", schema = "pref") //, catalog = "pref"
@Entity
@Table(name="users")
public class UserModel {

    @Id
    @SequenceGenerator(name = "users_seq_gen", sequenceName = "hibernate_sequence")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "users_seq_gen")
    @Column(name="id")
    long id;

    @Column(name="name")
    String name;

    @Column(name="email")
    String email;

    @ManyToMany(cascade = CascadeType.ALL)
            @JoinTable(name = "user_group",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
            )
    List<GroupModel> groupModels = new ArrayList<GroupModel>();

    public UserModel() {
    }

    public UserModel(String name, String email) {
        //this.id=id;
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", groupModels=" + groupModels +
                '}';
    }

    public List<GroupModel> getGroupModels() {
        return groupModels;
    }

    public void setGroupModels(List<GroupModel> groupModels) {
        this.groupModels = groupModels;
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
