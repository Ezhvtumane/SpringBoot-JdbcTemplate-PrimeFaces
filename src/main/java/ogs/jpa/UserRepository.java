package ogs.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserModel, Long> {

    //List<UserModel> findAll();
}
