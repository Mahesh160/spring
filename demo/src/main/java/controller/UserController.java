package controller;

import com.project.demo.dao.User;
import com.project.demo.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
public UserRepository userRepo;


//return all the users
    @GetMapping
public List <User> getAllUsers(){
    return userRepo.findAll();
}
//return the user by userID
    @GetMapping("/{userId}")
    public User getUserById(String user_id){
        return userRepo.findById(user_id).orElse(null);
    }

    @DeleteMapping
    public void deleteUseById(String userid){
        userRepo.deleteById(userid);
    }
}
