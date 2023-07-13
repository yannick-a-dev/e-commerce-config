package com.ecommerce.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.ecommerce.entities.User;

public interface UserRepo extends JpaRepository<User, Long> {

	User findFirstByEmail(String email);
}
