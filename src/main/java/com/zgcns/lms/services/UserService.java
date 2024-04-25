package com.zgcns.lms.services;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;

import com.zgcns.lms.exception.UserNotFoundException;
import com.zgcns.lms.model.User;
import com.zgcns.lms.repositories.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
 @Autowired
 private UserRepository userRepository;


public String authenticateUser(User user)throws UserNotFoundException
	 {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		
		 Optional<User> userOptional= userRepository.findByEmail(user.getEmail());
		 if(userOptional.isPresent()) {
			 
			 User databaseUser = userOptional.get();
			 if(bCryptPasswordEncoder.matches(user.getPassword(),databaseUser.getPassword()))
			 {
				 return "Autheticated User";
			 }
			 else {
				 return "Incorrect Password";
			 }
		 }
		 throw new UserNotFoundException("No user is not found for this email !!!");
	 }
 


 public String addUser(User user) {
	 
	 	BCryptPasswordEncoder bcrptBCryptPasswordEncoder  = new  BCryptPasswordEncoder();
	 	String encryptedPassword = bcrptBCryptPasswordEncoder.encode(user.getPassword());
	 	user.setPassword(encryptedPassword);
	 	
	 	User addUser = userRepository.save(user);
		return addUser.getEmail()+ " added to database successfully";
 }
 

 
 public User Updateuser(Long userId, User user) {
        User  updatedUser= userRepository.findById(userId).get();
        
        updatedUser.setEmail(user.getEmail());
        updatedUser.setPassword(user.getPassword());
    
        userRepository.save(updatedUser);
	
	 return updatedUser;
 }
 

 
}

