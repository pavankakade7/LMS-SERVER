package com.zgcns.lms.services;

import org.springframework.stereotype.Service;

import com.zgcns.lms.model.Role;
import com.zgcns.lms.repositories.RoleRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RoleService {
	
	private RoleRepository roleRepository;
	
	 public Role saveRole(Role role) {
	        return roleRepository.save(role);
	    }
	 
	 
	
	
}
