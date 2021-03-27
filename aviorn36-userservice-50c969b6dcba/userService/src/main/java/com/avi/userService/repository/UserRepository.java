package com.avi.userService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.avi.userService.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
