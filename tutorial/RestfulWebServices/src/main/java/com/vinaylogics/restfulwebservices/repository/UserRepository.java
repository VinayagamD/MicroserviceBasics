package com.vinaylogics.restfulwebservices.repository;

import com.vinaylogics.restfulwebservices.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}