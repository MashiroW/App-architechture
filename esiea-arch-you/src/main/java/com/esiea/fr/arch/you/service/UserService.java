package com.esiea.fr.arch.you.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esiea.fr.arch.you.dto.UserDto;
import com.esiea.fr.arch.you.entity.User;
import com.esiea.fr.arch.you.mapper.MapperUser;
import com.esiea.fr.arch.you.repository.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MapperUser mapperUser;
	
	
	public void createUser(UserDto userDto){
		User user = mapperUser.map(userDto);
		userRepository.save(user);
		
		System.out.println("The user "+user.getFirstname()+" "+user.getLastname()+" (ID = "+user.getId()+") has been added");
	}
	
	public UserDto fetchUserByUsernameAndPassword(String username, String password) {
		return userRepository.findByUsernameAndPassword(username,password);
	}
	
}
