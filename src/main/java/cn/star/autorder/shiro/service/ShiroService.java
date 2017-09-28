package cn.star.autorder.shiro.service;


import java.util.List;

import cn.star.autorder.shiro.entity.Permission;
import cn.star.autorder.shiro.entity.Role;
import cn.star.autorder.shiro.entity.RolePermssion;
import cn.star.autorder.shiro.entity.ShiroUser;
import cn.star.autorder.shiro.entity.UserRole;

public interface ShiroService {
	
	/**
	 * 创建权限
	 * @param permission
	 * @return
	 */
	public void createPermission(Permission permission);
    
    /**
     * 创建角色
     * @param role
     * @return
     */
    public void createRole(Role role);
    
    /**
     * 创建用户
     * @param user
     */
    public void createUser(ShiroUser user);

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    public ShiroUser findByUsername(String username);

    
    /**
     * 根据用户名查找用户信息
     * @param username
     * @return
     */
    ShiroUser getUserByUsername(String username);
    
    /**
     * 增加用户-角色
     * @param list
     */
    void addRelationUser2Role(List<UserRole> list);
    
    /**
     * 增加角色-权限
     * @param list
     */
    void addRelationRole2Permission(List<RolePermssion> list);
}
