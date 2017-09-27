package cn.star.autorder.shiro.dao;

import java.util.List;


import cn.star.autorder.shiro.entity.Permission;
import cn.star.autorder.shiro.entity.Role;
import cn.star.autorder.shiro.entity.RolePermssion;
import cn.star.autorder.shiro.entity.ShiroUser;
import cn.star.autorder.shiro.entity.UserRole;

public interface ShiroDao {
	
	/**
	 * 创建登陆账号
	 * @param user
	 */
	void createUser(ShiroUser user);
	

    /**
     * 根据用户名获取账号
     * @param username
     * @return
     */
    ShiroUser findByUsername(String username);

    /**
     * 创建角色
     * @param role
     * @return
     */
    void createRole(Role role);
    
    /**
     * 创建权限
     * @param permission
     * @return
     */
    void createPermission(Permission permission);

    /**
     * 根据用户名获取全登陆属性用户
     * @param username
     * @return
     */
    ShiroUser getUserByUsername(String username);
    
    /**
     * 获取所有角色
     * @return
     */
    List<Role> getAllRoles();
    
    /**
     * 获取所有权限
     * @return
     */
    List<Permission> getAllPermissions();
    
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
