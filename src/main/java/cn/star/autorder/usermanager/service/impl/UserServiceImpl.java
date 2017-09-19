package cn.star.autorder.usermanager.service.impl;

import java.util.Set;

import org.springframework.stereotype.Service;

import cn.star.autorder.usermanager.entity.User;
import cn.star.autorder.usermanager.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Override
	public User findByUsername(String username) {
		return null;
	}

	@Override
	public Set<String> findRoles(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> findPermissions(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
