package com.hospital.repositories;

import com.hospital.model.User;

public interface UserRespository {
	User findUser(String username, String password);
}
