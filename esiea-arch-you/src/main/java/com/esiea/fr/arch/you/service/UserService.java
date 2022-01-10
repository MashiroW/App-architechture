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
	
	public void createOrUpdateUser(UserDto userDto){
		User user = mapperUser.map(userDto);
		userRepository.save(user);
	}
	
}
