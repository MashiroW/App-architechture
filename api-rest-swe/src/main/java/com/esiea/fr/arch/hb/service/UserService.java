package com.esiea.fr.arch.hb.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esiea.fr.arch.hb.dto.UserDto;
import com.esiea.fr.arch.hb.entity.User;
import com.esiea.fr.arch.hb.mapper.MapperUser;
import com.esiea.fr.arch.hb.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MapperUser mapperUser;
	
	private static Logger logger = Logger.getLogger(UserService.class);
	
	public void createUser(UserDto userDto){
		User user = mapperUser.map(userDto);
		userRepository.save(user);
		
		logger.info("The user "+user.getFirstname()+" "+user.getLastname()+" (ID = "+user.getId()+") has been added");
	}
	
	public UserDto fetchUserByUsernameAndPassword(String username, String password) {
		return userRepository.findByUsernameAndPassword(username,password);
	}
}
