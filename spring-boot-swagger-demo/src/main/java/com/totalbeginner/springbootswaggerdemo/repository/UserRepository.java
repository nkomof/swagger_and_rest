package com.totalbeginner.springbootswaggerdemo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.totalbeginner.springbootswaggerdemo.resource.User;

@Repository
public interface UserRepository extends MongoRepository<User, Integer> {
	Optional<User> findById(Integer id);
	public User findByUserName(String userName);
	public List<User> findBySalary(Long salary);
}
