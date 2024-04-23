package com.zgcns.lms.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class passwordEncoderImpl {

	public static void main(String args) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		System.out.println(passwordEncoder.encode("pavan"));
		System.out.println(passwordEncoder.encode("admin"));
	}
}
