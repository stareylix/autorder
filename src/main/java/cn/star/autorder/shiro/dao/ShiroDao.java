package cn.star.autorder.shiro.dao;

import java.util.Set;


import cn.star.autorder.shiro.entity.Permission;
import cn.star.autorder.shiro.entity.Role;
import cn.star.autorder.shiro.entity.ShiroUser;

public interface ShiroDao {
	
	ShiroUser createUser(ShiroUser user);
	
    void updateUser(ShiroUser user);
    
    void deleteUser(String userId);

    void correlationRoles(String userId, String... roleIds);
    
    void uncorrelationRoles(String userId, String... roleIds);

    ShiroUser findOne(String userId);

    ShiroUser findByUsername(String username);

    Set<String> findRoles(String username);

    Set<String> findPermissions(String username);
    
    Role createRole(Role role);
    
    void deleteRole(String roleId);

    void correlationPermissions(String roleId, String... permissionIds);
    
    void uncorrelationPermissions(String roleId, String... permissionIds);
    
    Permission createPermission(Permission permission);

    void deletePermission(String permissionId);
    
    void changePassword(String userId, String newPassword);

}
