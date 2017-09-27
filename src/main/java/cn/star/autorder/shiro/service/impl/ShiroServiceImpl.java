package cn.star.autorder.shiro.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.star.autorder.shiro.dao.ShiroDao;
import cn.star.autorder.shiro.entity.Permission;
import cn.star.autorder.shiro.entity.Role;
import cn.star.autorder.shiro.entity.ShiroUser;
import cn.star.autorder.shiro.service.ShiroService;

@Service
public class ShiroServiceImpl implements ShiroService {
	
	@Autowired
	private ShiroDao shiroDao;
	

	@Override
	public void createUser(ShiroUser user) {
		// TODO Auto-generated method stub
		shiroDao.createUser(user);
	}


	@Override
	public ShiroUser findByUsername(String username) {
		// TODO Auto-generated method stub
		return shiroDao.findByUsername(username);
	}


	@Override
	public ShiroUser getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return shiroDao.getUserByUsername(username);
	}


	@Override
	public void createPermission(Permission permission) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void createRole(Role role) {
		// TODO Auto-generated method stub
		
	}

}
