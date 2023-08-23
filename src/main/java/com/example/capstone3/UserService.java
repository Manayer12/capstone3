package com.example.capstone3;

import com.example.capstone3.Api.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers(){

        return userRepository.findAll();
    }


    public void addUser(User user){


        userRepository.save(user);
    }



    public void updateUser(Integer id, User user){
        User oldUser=userRepository.findUserById(id);
        if(oldUser==null){
            throw new ApiException("id not found");
        }


        oldUser.setName(user.getName());
        oldUser.setBirth_date(user.getBirth_date());
        oldUser.setBalance(user.getBalance());
        oldUser.setAge(user.getAge());
        oldUser.setGender(user.getGender());
        userRepository.save(oldUser);

    }
    public void deleteUser(Integer id){
        User user=userRepository.findUserById(id);
        if(user==null){
            throw new ApiException("id not found");
        }


        userRepository.deleteById(id);
    }





}
