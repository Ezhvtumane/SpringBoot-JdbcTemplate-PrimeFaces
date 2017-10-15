package ogs.display;

import ogs.jpa.UserModel;
import ogs.jpa.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.List;
import java.util.Random;

@Controller
@Scope("session")
public class UserSimpleView implements Serializable{

    private List<UserModel> userModels;

    private List<UserModel> filteredUserModels;

    @Autowired
    private UserService userService;

    @PostConstruct
    public void initUsers(){

        userModels = userService.findAll();

    }

    public List<UserModel> getUsers() {

        int max = 10000, min = 1;
        double num = Math.round(Math.random()*(max-min));

        UserModel userModel =
                new UserModel("gosha" + num
                        ,"gogaopel" + num);
        System.out.println(userModel);
        userService.addUserModel(userModel);


        for(UserModel userModel_ : userModels) {
            System.out.println(userModel_);
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
