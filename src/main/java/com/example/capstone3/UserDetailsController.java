package com.example.capstone3;

import com.example.capstone3.Api.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/userdetails")
public class UserDetailsController {
private final UserService userService;
private final UserDetailsService userDetailsService;

    @PostMapping("/add")
    public ResponseEntity addUserDetails(@RequestBody @Valid UserDto userDto){


        userDetailsService.addUserDetails(userDto);
        return ResponseEntity.status(200).body(new ApiResponse("User Details added"));
    }

    @GetMapping("/get")
    public ResponseEntity getAllUsersDetails(){

        return ResponseEntity.status(200).body(userDetailsService.getAllUsersDetails());
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateUserDetails(@PathVariable  Integer id,@RequestBody @Valid UserDto userDto){
        userDetailsService.updateUserDetails(id,userDto);
        return ResponseEntity.status(200).body(new ApiResponse("User Details Updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUserDetails(@PathVariable Integer id){
        userDetailsService.deleteUserDetails(id);
        return ResponseEntity.status(200).body(new ApiResponse("User Details deleted"));
    }

}
