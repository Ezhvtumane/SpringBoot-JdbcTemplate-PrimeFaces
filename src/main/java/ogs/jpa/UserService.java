package ogs.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService { //maybe create an interface and make its implementation?

    @Autowired
    UserRepository userRepository;

    public List<UserModel> findAll(){
     return   userRepository.findAll();
    }

    public UserModel addUserModel(UserModel userModel) {
        UserModel savedUserModel = userRepository.saveAndFlush(userModel);

        return savedUserModel;
    }


}
