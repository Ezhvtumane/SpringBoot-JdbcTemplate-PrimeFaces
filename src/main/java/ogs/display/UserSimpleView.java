package ogs.display;

import ogs.jpa.UserModel;
import ogs.jpa.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.List;

@Controller
@Scope("session")
public class UserSimpleView implements Serializable{

    private List<UserModel> userModels;

    private List<UserModel> filteredUserModels;

    UserModel userModel = new UserModel("gosha","gogaopel");

    @Autowired
    private UserService userService;

    @PostConstruct
    public void initUsers(){
        userModels = userService.findAll();
        System.out.println(userModel);
        userService.addUserModel(userModel);

    }

    public List<UserModel> getUsers() {
        for(UserModel userModel : userModels) {
            System.out.println(userModel);
        }
        return userModels;
    }

    public List<UserModel> getFilteredUsers() {
        return filteredUserModels;
    }

    public void setFilteredUsers(List<UserModel> filteredUsers) {
        this.filteredUserModels = filteredUsers;
    }
}
