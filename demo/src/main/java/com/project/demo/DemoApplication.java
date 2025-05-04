package com.project.demo;

import com.project.demo.dao.User;
import com.project.demo.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class DemoApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepo;


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	public void run(String ... args){
		System.out.println("Total users in the database " + userRepo.count());


		if(userRepo.count() == 0){
			userRepo.save(new User("101","Larry","123456"));
			System.out.println("Inserted the sample users");
		}

		User foundUser = userRepo.findByUserName("Larry");
		if(foundUser!=null){
			System.out.println("User Found "+foundUser.getUserName());
			System.out.println("Total users in the database " + userRepo.count());
		}
		else{
			System.out.println("User not found");
		}

	}

}
