package com.bhanu.pratap.org.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bhanu.pratap.org.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
