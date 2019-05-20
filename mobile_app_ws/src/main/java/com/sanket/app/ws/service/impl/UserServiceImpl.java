package com.sanket.app.ws.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.sanket.app.ws.UserRepository;
import com.sanket.app.ws.io.entity.UserEntity;
import com.sanket.app.ws.service.UserService;
import com.sanket.app.ws.shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

	UserRepository userRepository;
	
	@Override
	public UserDto createUser(UserDto user) {
		
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		
		userEntity.setEncryptedPassword("test");
		userEntity.setUserId("test@test.com");
		
		UserEntity storedUserDetails = userRepository.save(userEntity);
		
		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(storedUserDetails, returnValue);
				
		return returnValue;
	}

}
