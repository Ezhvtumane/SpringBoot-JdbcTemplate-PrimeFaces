package sprBoot;

import org.springframework.stereotype.Component;

@Component
public class User {

    private String id;
    private String name;
    private String email;

    @Override
    public String toString(){
        return String.format("User id: %s, user name: %s, user email: %s", this.id, this.name, this.email);
    }

    public User() {
    }

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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