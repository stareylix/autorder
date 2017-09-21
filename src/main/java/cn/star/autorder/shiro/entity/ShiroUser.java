package cn.star.autorder.shiro.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ShiroUser implements Serializable {
	private static final long serialVersionUID = -700985306421818180L;
	private String id;
    private String username;
    private String password;
    private String salt;
    private Set<Role> roleSet=new HashSet<>();

    private Integer locked;
    
    
    public Set<Role> getRoleSet() {
		return roleSet;
	}

	public void setRoleSet(Set<Role> roleSet) {
		this.roleSet = roleSet;
	}

	public ShiroUser() {
    }

    public ShiroUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getCredentialsSalt() {
    	//此处增加证书算法
        return salt+username;
    }

    public Integer getLocked() {
        return locked;
    }

    public void setLocked(Integer locked) {
        this.locked = locked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShiroUser user = (ShiroUser) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

	@Override
	public String toString() {
		return "ShiroUser [id=" + id + ", username=" + username + ", password=" + password + ", salt=" + salt
				+ ", roleSet=" + roleSet + ", locked=" + locked + "]";
	}

}
