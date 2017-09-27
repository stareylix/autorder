package cn.star.autorder.shiro.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import cn.star.autorder.shiro.dao.LockFlag;
import cn.star.autorder.shiro.entity.ShiroUser;
import cn.star.autorder.shiro.service.ShiroService;


public class UserRealm extends AuthorizingRealm {
	
	@Autowired
    private ShiroService shiroService;

    public void setshiroService(ShiroService shiroService) {
        this.shiroService = shiroService;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String)principals.getPrimaryPrincipal();

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        ShiroUser shiroUser = shiroService.getUserByUsername(username);
        authorizationInfo.setRoles(shiroUser.getRoles());
        authorizationInfo.setStringPermissions(shiroUser.getPermissions());
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String username = (String)token.getPrincipal();

        ShiroUser user = shiroService.findByUsername(username);

        if(user == null) {
            throw new UnknownAccountException();//没找到帐号
        }
        try {
        	if(Boolean.parseBoolean(user.getLocked())==LockFlag.LOCKED) {
        		throw new LockedAccountException(); //帐号锁定
        	}
		} catch (Exception e) {
			throw new LockedAccountException("账号状态未知。。。"); //帐号锁定
		}

        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUsername(), //用户名
                user.getPassword(), //密码
                ByteSource.Util.bytes(user.getCredentialsSalt()),
                getName()  //realm name
        );
        return authenticationInfo;
    }

    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }

}
