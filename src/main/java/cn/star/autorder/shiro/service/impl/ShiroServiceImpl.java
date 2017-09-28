package cn.star.autorder.shiro.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.star.autorder.shiro.dao.ShiroDao;
import cn.star.autorder.shiro.entity.Permission;
import cn.star.autorder.shiro.entity.Role;
import cn.star.autorder.shiro.entity.RolePermssion;
import cn.star.autorder.shiro.entity.ShiroUser;
import cn.star.autorder.shiro.entity.UserRole;
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
		shiroDao.createPermission(permission);
	}


	@Override
	public void createRole(Role role) {
		// TODO Auto-generated method stub
		shiroDao.createRole(role);
	}


	@Override
	public void addRelationUser2Role(List<UserRole> list) {
		// TODO Auto-generated method stub
		shiroDao.addRelationUser2Role(list);
	}


	@Override
	public void addRelationRole2Permission(List<RolePermssion> list) {
		// TODO Auto-generated method stub
		shiroDao.addRelationRole2Permission(list);
	}

}
