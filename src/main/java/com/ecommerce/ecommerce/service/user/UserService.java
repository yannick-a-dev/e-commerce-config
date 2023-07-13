package com.ecommerce.ecommerce.service.user;

import com.ecommerce.ecommerce.dto.SignupDTO;
import com.ecommerce.ecommerce.dto.UserDTO;

public interface UserService {

	UserDTO createUser(SignupDTO signupDTO);

	boolean hasUserWithEmail(String email);

}
