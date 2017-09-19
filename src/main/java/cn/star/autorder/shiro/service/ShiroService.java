package cn.star.autorder.shiro.service;

import java.util.Set;

import cn.star.autorder.shiro.entity.Permission;
import cn.star.autorder.shiro.entity.Role;
import cn.star.autorder.shiro.entity.ShiroUser;

public interface ShiroService {
	
	/**
	 * 创建权限
	 * @param permission
	 * @return
	 */
	public Permission createPermission(Permission permission);
	/**
	 * 删除权限
	 * @param permissionId
	 */
    public void deletePermission(String permissionId);
    
    /**
     * 创建角色
     * @param role
     * @return
     */
    public Role createRole(Role role);
    /**
     * 删除角色
     * @param roleId
     */
    public void deleteRole(String roleId);

    /**
     * 添加角色-权限之间关系
     * @param roleId
     * @param permissionIds
     */
    public void correlationPermissions(String roleId, String... permissionIds);

    /**
     * 移除角色-权限之间关系
     * @param roleId
     * @param permissionIds
     */
    public void uncorrelationPermissions(String roleId, String... permissionIds);
    
    /**
     * 创建用户
     * @param user
     */
    public ShiroUser createUser(ShiroUser user);

    /**
     * 修改密码
     * @param userId
     * @param newPassword
     */
    public void changePassword(String userId, String newPassword);

    /**
     * 添加用户-角色关系
     * @param userId
     * @param roleIds
     */
    public void correlationRoles(String userId, String... roleIds);


    /**
     * 移除用户-角色关系
     * @param userId
     * @param roleIds
     */
    public void uncorrelationRoles(String userId, String... roleIds);

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    public ShiroUser findByUsername(String username);

    /**
     * 根据用户名查找其角色
     * @param username
     * @return
     */
    public Set<String> findRoles(String username);

    /**
     * 根据用户名查找其权限
     * @param username
     * @return
     */
    public Set<String> findPermissions(String username);
}
