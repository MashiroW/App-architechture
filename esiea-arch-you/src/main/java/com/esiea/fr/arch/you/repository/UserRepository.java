package com.esiea.fr.arch.you.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.esiea.fr.arch.you.dto.UserDto;
import com.esiea.fr.arch.you.entity.User;

public interface UserRepository extends CrudRepository<User,Long>{

	public UserDto findByUsernameAndPassword(String username, String password);
	
	@Query("SELECT u from User u Where u.username = : username")
	public UserDto getUserByUsername(@Param("username") String username);
	
}