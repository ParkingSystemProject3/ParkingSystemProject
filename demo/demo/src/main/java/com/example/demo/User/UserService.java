package com.example.demo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUser(String id){
        Long user_id = Long.parseLong(id);
        return userRepository.findById(user_id).orElse(null);
    }

    public User createUser(User user){
        return userRepository.save(user);

    }

    public void deleteUser(String id){
        Long user_id = Long.parseLong(id);
        userRepository.deleteById(user_id);

    }

    public void updateUser(String id, User data){
        Long user_id = Long.parseLong(id);
        User user = userRepository.findById(user_id).orElse(null);

        if (user != null){
            user.setfName(data.getfName());
            user.setlName(data.getlName());
            user.setPhone(data.getPhone());
            user.setPlatNumber(data.getPlatNumber());
            userRepository.save(user);
        }

    }

}
