package com.scm.implementation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.scm.entity.User;
import com.scm.helper.AppConstants;
import com.scm.helper.ResourceNotFoundException;
import com.scm.repositories.UserRepository;
import com.scm.services.UserService;

@Service 
public class UserServiceImpl implements UserService 
{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());

	@Override
	public User saveUser(User user) {
		//user id have to generate
		String userId=UUID.randomUUID().toString();
		user.setUserId(userId);
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		//set user role
		user.setRoleList(List.of(AppConstants.ROLE_USER));
		return userRepository.save(user);
	}

	@Override
	public Optional<User> getUserById(String id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Override
	public Optional<User> updateUser(User user) {
		// TODO Auto-generated method stub
		User user2=userRepository.findById(user.getUserId()).orElseThrow(()-> new ResourceNotFoundException("user not found"));
	// update karnege user 2 ko new user se
		user2.setName(user.getName());
		user2.setEmail(user.getEmail());
		user2.setPassword(user.getPassword());
		user2.setAbout(user.getAbout());
		user2.setPhoneNumber(user.getPhoneNumber());
		user2.setProfilePic(user.getProfilePic());
		user2.setEnabled(user.isEnabled());
		user2.setEmailVerified(user.isEmailVerified());
		user2.setPhoneVerified(user.isPhoneVerified());
	user2.setProviders(user.getProviders());
	user2.setProviderUserId(user.getProviderUserId());
	//save the user in data base
	User save=userRepository.save(user2);
	return Optional.ofNullable(save);
	}

	@Override
	public void deleteUser(String id) {
		User user2=userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("user not found"));
		 userRepository.delete(user2);
	}

	@Override
	public boolean isUserExist(String userId) {
		User user2=userRepository.findById(userId).orElse(null);
		
		return user2!=null ? true : false;
	}

	@Override
	public boolean isUserExistByEmail(String email) {
		User user=userRepository.findByEmail(email).orElse(null);
	  return user!=null ? true:false;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
   
}
