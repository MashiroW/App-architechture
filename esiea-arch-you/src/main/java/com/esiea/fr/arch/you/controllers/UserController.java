package com.esiea.fr.arch.you.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esiea.fr.arch.you.dto.UserDto;
import com.esiea.fr.arch.you.entity.User;
import com.esiea.fr.arch.you.exceptions.BadCredentialsException;
import com.esiea.fr.arch.you.exceptions.ResourceNotFoundException;
import com.esiea.fr.arch.you.repository.UserRepository;
import com.esiea.fr.arch.you.service.UserService;



@Controller
public class UserController {
    
	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepository;
	
	
    //Update user
    @RequestMapping(value = "/api/v1/users/edit/{id}", method = RequestMethod.POST, consumes =MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId, @RequestBody UserDto userDetails) throws ResourceNotFoundException {
    	User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found for this id: "+userId));
    	
    	user.setFirstname(userDetails.getFirstname());
    	user.setLastname(userDetails.getLastname());
    	user.setUsername(userDetails.getUsername());
    	
    	User updatedUser = userRepository.save(user);
    	
    	
    	return ResponseEntity.ok().body(updatedUser);
    
    }
	
	//ADDING AN USER
    @RequestMapping(value = "/api/v1/users/add", method = RequestMethod.POST, consumes =MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user) 
    {
    	userService.createUser(user);
    	return new ResponseEntity<UserDto>(user, HttpStatus.OK);    
    }
    
    //GET OUR USERS LIST
    @GetMapping("/api/v1/users/list")
    public ResponseEntity<Iterable<User>> getAllUsers(){
        return  ResponseEntity.ok().body(userRepository.findAll());
    }
    
    //Get user by id
    @GetMapping("/api/v1/users/get/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId) throws ResourceNotFoundException{
    	User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found for this id: "+userId));
    	return ResponseEntity.ok().body(user);
    }
    
    //Delete user
    @DeleteMapping("/api/v1/users/delete/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteUser(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
    	User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found for this id: "+id));
    	userRepository.delete(user);
    	System.out.println("The user "+user.getFirstname()+" "+user.getLastname()+" (ID = "+user.getId()+") has been removed");
    	Map<String, Boolean> response = new HashMap<>();
    	response.put("deleted", Boolean.TRUE);
    	return ResponseEntity.ok(response);
    }
    
    //Login
    @RequestMapping(value = "/api/v1/users/login", method = RequestMethod.POST)
    public ResponseEntity<UserDto> loginUser(@RequestBody UserDto user) throws BadCredentialsException{
    	String tempUsername = user.getUsername();
    	String tempPassword = user.getPassword();
    	UserDto userObj = null;
    	if (tempUsername != null && tempPassword != null) {
    		userObj = userService.fetchUserByUsernameAndPassword(tempUsername, tempPassword);   		
    	}
    	if (userObj == null) {
    		throw new BadCredentialsException("Bad credentials");
    	}
    	return new ResponseEntity<UserDto>(userObj, HttpStatus.OK);    	
    }
        
}

