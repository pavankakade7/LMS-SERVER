package com.zgcns.lms.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zgcns.lms.model.User;



@Repository
public interface UserRepository extends JpaRepository<User,Long> {
 Optional<User> findByEmail(String email);
 
 
 
 @Override
	default long count() {
		// TODO Auto-generated method stub
		return 0;
	}
}
