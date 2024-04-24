package com.zgcns.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zgcns.lms.model.Role;
import com.zgcns.lms.services.RoleService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/roles")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	
	@PostMapping("/addrole")
	public Role saveRole(@RequestBody Role role) {
		return roleService.saveRole(role);
	}
}
