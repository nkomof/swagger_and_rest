package com.mondia.swagger.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mondia.swagger.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, Integer> {
	public User findByUserName(String userName);
	public List<User> findBySalary(Long salary);
}
