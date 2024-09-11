package com.scm.services;

import java.util.List;
import java.util.Optional;

import com.scm.entity.User;

public interface UserService {
User saveUser(User user);
Optional<User> getUserById(String id);
Optional<User> updateUser(User user);
void deleteUser(String id);
boolean isUserExist(String userId);
boolean isUserExistByEmail(String email);
List<User> getAllUsers();
//if needed add more methods here related to user services
}
