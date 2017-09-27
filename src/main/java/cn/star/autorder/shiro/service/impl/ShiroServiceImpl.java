package cn.star.autorder.shiro.service.impl;

import java.util.Set;

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
	public Permission createPermission(Permission permission) {
		// TODO Auto-generated method stub
		return shiroDao.createPermission(permission);
	}

	@Override
	public void deletePermission(String permissionId) {
		// TODO Auto-generated method stub
		shiroDao.deletePermission(permissionId);
	}

	@Override
	public Role createRole(Role role) {
		// TODO Auto-generated method stub
		return shiroDao.createRole(role);
	}

	@Override
	public void deleteRole(String roleId) {
		// TODO Auto-generated method stub
		shiroDao.deleteRole(roleId);
	}

	@Override
	public void correlationPermissions(String roleId, String... permissionIds) {
		// TODO Auto-generated method stub
		shiroDao.correlationPermissions(roleId, permissionIds);
	}

	@Override
	public void uncorrelationPermissions(String roleId, String... permissionIds) {
		// TODO Auto-generated method stub
		shiroDao.uncorrelationPermissions(roleId, permissionIds);
	}

	@Override
	public void createUser(ShiroUser user) {
		// TODO Auto-generated method stub
		shiroDao.createUser(user);
	}

	@Override
	public void changePassword(String userId, String newPassword) {
		// TODO Auto-generated method stub
		shiroDao.changePassword(userId, newPassword);
	}

	@Override
	public void correlationRoles(String userId, String... roleIds) {
		// TODO Auto-generated method stub
		shiroDao.correlationRoles(userId, roleIds);
	}

	@Override
	public void uncorrelationRoles(String userId, String... roleIds) {
		// TODO Auto-generated method stub
		shiroDao.uncorrelationRoles(userId, roleIds);
	}

	@Override
	public ShiroUser findByUsername(String username) {
		// TODO Auto-generated method stub
		return shiroDao.findByUsername(username);
	}

	@Override
	public Set<String> findRoles(String username) {
		// TODO Auto-generated method stub
		return shiroDao.findRoles(username);
	}

	@Override
	public Set<String> findPermissions(String username) {
		// TODO Auto-generated method stub
		return shiroDao.findPermissions(username);
	}

	@Override
	public ShiroUser getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return shiroDao.getUserByUsername(username);
	}

}
