package com.avi.userService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.avi.userService.entity.Department;
import com.avi.userService.entity.ResponseUserDTO;
import com.avi.userService.entity.User;
import com.avi.userService.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	public User addUser(User user) {
		log.info("userService :: addUser");
		return userRepository.save(user);	
	}

	public ResponseUserDTO getUser(Long userId) {
		log.info("userService :: getUser");
		User user = userRepository.findById(userId).get();
		Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/"+user.getDepartmentId(), Department.class);		
		return new ResponseUserDTO(user, department);
	}

}
