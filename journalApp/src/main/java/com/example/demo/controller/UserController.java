package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Service.UserService;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private UserRepository userRepository;
    
    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user){
    Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
    	String userName=authentication.getName();
    	User userInDb = userService.findByUserName(userName);
    	if (userInDb == null) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
            userInDb.setUserName(user.getUserName());
            userInDb.setPassword(user.getPassword());
            userService.saveNewUser(userInDb);
        
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
   
    @DeleteMapping
    public ResponseEntity<?> deleteUserById() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userRepository.deleteByUserName(authentication.getName());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping
    public ResponseEntity<?> greeting() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       return new ResponseEntity<>("hi "+ authentication.getName(),HttpStatus.OK);
    }
}



//@PostMapping
//public void createUser(@RequestBody User user) {
//  userService.saveEntry(user);
//}


//@GetMapping
//public List<User> getAllUsers(){
//  return userService.getAll();
//}


// Uncomment and complete if needed
// @DeleteMapping
// public ResponseEntity<?> deleteUserById(){
//     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
// }
