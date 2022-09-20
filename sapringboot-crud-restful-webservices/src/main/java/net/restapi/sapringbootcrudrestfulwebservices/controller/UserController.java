package net.restapi.sapringbootcrudrestfulwebservices.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.restapi.sapringbootcrudrestfulwebservices.entity.User;
import net.restapi.sapringbootcrudrestfulwebservices.exception.ResourceNotFoundException;
import net.restapi.sapringbootcrudrestfulwebservices.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserRepository userRepository;
// getting all the users
	@GetMapping
	public List<User> getAllUsers(){
		return this.userRepository.findAll();
	}
	//getting user id's
	@GetMapping("/{id}")
	public User getUserById(@PathVariable (value="id") long userId) {
		return this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user not found with id :"+userId));
	}
	//creating users
	@PostMapping
	public User createUser(@RequestBody User user){
		return this.userRepository.save(user);
	}
	//updating users
	@PutMapping("/{id}")
	public User updateUser(@RequestBody User user, @PathVariable ("id") long  userId) {
		User existingUser = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user not found with id :"+userId));
	existingUser.setFirstname(user.getFirstname());
	existingUser.setLastname(user.getLastname());
	existingUser.setEmail(user.getEmail());
	return this.userRepository.save(existingUser);
	}
	//deleting users
	@DeleteMapping("/{id}")
	 public ResponseEntity<User> deleteUser(@PathVariable ("id") long userId){
		User existingUser = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user not found with id :"+userId));
		this.userRepository.delete(existingUser);
		return ResponseEntity.ok().build();		 
	 }
}
