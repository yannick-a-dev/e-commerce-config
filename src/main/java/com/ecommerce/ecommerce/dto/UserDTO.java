package com.ecommerce.ecommerce.dto;

import com.ecommerce.ecommerce.enums.UserRole;
import lombok.Data;

@Data
public class UserDTO {



	private Long id;

	private String name;

	private String password;

	private String email;

	private UserRole userRole;
	
}
