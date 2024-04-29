package com.zgcns.lms.services;



import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


public ResponseEntity<Map<String, String>> authenticateUser(User user)throws UserNotFoundException
	 {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		
		 Optional<User> userOptional= userRepository.findByEmail(user.getEmail());
		 if(userOptional.isPresent()) {
			 
			 User databaseUser = userOptional.get();
			 if(bCryptPasswordEncoder.matches(user.getPassword(),databaseUser.getPassword()))
			 {
				 return ResponseEntity.ok(Map.of(
		                    "email", databaseUser.getEmail(),
		                    "role", databaseUser.getRole()
		                    
		                ));
		            } else {
		                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
		                    Map.of("error", "Invalid password") // Consistent JSON error message
		                );
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
 

 public User getUserByEmail(String email) throws UserNotFoundException {
     return userRepository.findByEmail(email).orElseThrow(
         () -> new UserNotFoundException("No user found with email: " + email)
     );
 }
 
 
 public User getUserByUserId(Long userId, User user) {
	 return userRepository.findById(userId).orElseThrow(
	         () -> new UserNotFoundException("No user found with userId: " + userId));
 }


 public User getUserByFirstName(String firstName) {
     return userRepository.findByFirstName(firstName);
 }
 
}

