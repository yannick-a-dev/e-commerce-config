package com.ecommerce.ecommerce.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.ecommerce.ecommerce.dto.SignupDTO;
import com.ecommerce.ecommerce.dto.UserDTO;
import com.ecommerce.ecommerce.entities.User;
import com.ecommerce.ecommerce.enums.UserRole;
import com.ecommerce.ecommerce.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDTO createUser(SignupDTO signupDTO) {
		User user = new User();
		user.setName(signupDTO.getName());
		user.setEmail(signupDTO.getEmail());
		user.setUserRole(UserRole.USER);
		user.setPassword(new BCryptPasswordEncoder().encode(signupDTO.getPassword()));
		User createdUser = userRepo.save(user);
		UserDTO userDTO = new UserDTO();
		userDTO.setId(createdUser.getId());
		userDTO.setName(createdUser.getName());
		userDTO.setEmail(createdUser.getEmail());
		userDTO.setUserRole(createdUser.getUserRole());
		return userDTO;
	}

	@Override
	public boolean hasUserWithEmail(String email) {
		return userRepo.findFirstByEmail(email) != null;
	}

}
