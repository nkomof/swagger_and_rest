package com.mondia.swagger.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mondia.swagger.entity.User;
import com.mondia.swagger.repository.UserRepository;

@EnableMongoRepositories(basePackageClasses = UserRepository.class)
@Configuration
public class MongoDBConfiguration {
	@Bean
	CommandLineRunner commandLineRuner(UserRepository userRepository) {
		return new CommandLineRunner() {
			Integer currentId = 120;

			@Override
			public void run(String... strings) throws Exception {
				userRepository.save(User.builder().id(++currentId).userName("Luke").salary(300L).build());
				userRepository.save(User.builder().id(++currentId).userName("Aluwani").salary(350L).build());
				userRepository.save(User.builder().id(++currentId).userName("Sylvester").salary(380L).build());
			}
		};
	}
	
}
