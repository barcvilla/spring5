package com.bolsadeideas.springboot.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.bolsadeideas.springboot.app.models.service.IUploadService;

@SpringBootApplication
public class SpringBootDataJpaApplication implements CommandLineRunner {

	@Autowired
	private IUploadService uploadFileService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataJpaApplication.class, args);
	}
	
	/**
	 * Indicamos a la aplicacion que cree el directorio uploads cuando es iniciada.
	 */
	@Override
	public void run(String... arg0) throws Exception {
		
		uploadFileService.deleteAll();
		uploadFileService.init();
		
		String password = "12345";
		//loop que nos genera 2 password uno para andres y otra para admin
		for(int i = 0; i < 2; i++)
		{
			String bcryptPassword = passwordEncoder.encode(password);
			System.out.println(bcryptPassword);
		}
		//password 1: $2a$10$QqBtgiD9fign1RqyBWiwWeZmTnTzyFOdhCsB1t2JAr.Dl3wKF.RJe
		//password 2: $2a$10$.oIuZ5XezUVv9gmsRTnZAOzdxMWBrhQQuVE.RY6ZuwcBIkWGJyl5i
	}
}
