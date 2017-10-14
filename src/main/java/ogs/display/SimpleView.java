package ogs.display;

import ogs.jdbc.User;
import ogs.jdbc.JdbcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.List;

@Controller
@Scope("request") //session
public class SimpleView implements Serializable {


    private List<User> users;

    private List<User> filteredUsers;

    @Autowired
    private JdbcService jdbcService;

    @PostConstruct
    public void initUsers(){
        users = jdbcService.getUsers();
    }

    public List<User> getUsers() {
        for(User user : users) {
            System.out.println(user);
        }
        return users;
    }

    public List<User> getFilteredUsers() {
        return filteredUsers;
    }

    public void setFilteredUsers(List<User> filteredUsers) {
        this.filteredUsers = filteredUsers;
    }
}
