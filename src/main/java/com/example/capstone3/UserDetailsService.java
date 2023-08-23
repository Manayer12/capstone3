package com.example.capstone3;

import com.example.capstone3.Api.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserDetailsService {
    private final UserRepository userRepository;
    private final UserDetailsRepository userDetailsRepository;


    public void addUserDetails(UserDto userDto){
        User user=userRepository.findUserById(userDto.getUser_id());
        if (user == null){
            throw new ApiException("id is null");
        }

        if (Objects.equals(user.getGender(), "m")) {
            userDto.setPregnantOrNot(false);
        }

        if(userDto.getIsIllness().equals(false)){
            userDto.setIllness_type(null);
        }

        UserDetails userDetails =new UserDetails(null,userDto.getBlood_type(),userDto.getPregnantOrNot(),userDto.getIsIllness(),userDto.getIllness_type(),user);
        userDetailsRepository.save(userDetails);
    }

    public List<UserDetails> getAllUsersDetails(){

        return userDetailsRepository.findAll();
    }


    public void updateUserDetails(Integer id,UserDto userDto){
        UserDetails userDetails =userDetailsRepository.findUserDetailsById(id);
        if(userDetails ==null){
            throw new ApiException("id not found");
        }

        userDetails.setBlood_type(userDto.getBlood_type());
        userDetails.setPregnantOrNot(userDto.getPregnantOrNot());
        userDetails.setIsIllness(userDto.getIsIllness());
        userDetails.setIllness_type(userDto.getIllness_type());
        userDetailsRepository.save(userDetails);

    }
    public void deleteUserDetails(Integer id){

        UserDetails userDetails =userDetailsRepository.findUserDetailsById(id);
        User user=userRepository.findUserById(id);

        if(userDetails == null || user == null){
            throw new ApiException("id not found");
        }
        userDetailsRepository.deleteAllByIdInBatch(Collections.singleton(id));
    }





}
