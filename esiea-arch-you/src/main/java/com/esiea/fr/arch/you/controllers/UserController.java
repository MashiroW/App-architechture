package com.esiea.fr.arch.you.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esiea.fr.arch.you.dto.UserDto;
import com.esiea.fr.arch.you.entity.User;
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
    @RequestMapping(value = "/api/v1/adduser", method = RequestMethod.POST, consumes =MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user) 
    {
    	userService.createOrUpdateUser(user);
    	return new ResponseEntity<UserDto>(user, HttpStatus.OK);    
    }
    
    //GET OUR USERS LIST
    @GetMapping("/api/v1/users/list")
    public ResponseEntity<Iterable<User>> getAllUsers(){
        return  ResponseEntity.ok().body(userRepository.findAll());
    }
        
}
