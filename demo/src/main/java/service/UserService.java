package service;

import com.project.demo.dao.User;
import com.project.demo.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserService {

    @Autowired
    private UserRepository userRepo;

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public Optional<User> getUserById(String user_id){
        return userRepo.findById(user_id);

    }
}
