package cn.star.autorder.usermanager.service;

import java.util.Set;

import cn.star.autorder.usermanager.entity.User;

public interface UserService {
	
	User findByUsername(String username);

	Set<String> findRoles(String username);

	Set<String> findPermissions(String username);
	
}
