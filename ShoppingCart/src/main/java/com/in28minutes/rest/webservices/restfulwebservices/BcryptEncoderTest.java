package com.in28minutes.rest.webservices.restfulwebservices;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptEncoderTest {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		//BCryptPasswordDecoder dec=new 
		
		for(int i=1; i<=10; i++) {
			String encodedString = encoder.encode("kota");
			//String decodedString = decoder("kota");
			System.out.println(encodedString);
		}
		
		// TODO Auto-generated method stub
		//$2a$10$OPjSzU8Q59CPhnytu/D7.eUaD4d4qrf8rK/LBCE2medI3l9O9pJEm

	}

}



