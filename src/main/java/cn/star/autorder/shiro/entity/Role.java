package cn.star.autorder.shiro.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class Role implements Serializable {
	private static final long serialVersionUID = 5919050832825353012L;
	private String id;
    private String role; //角色标识 程序中判断使用,如"admin"
    private String description; //角色描述,UI界面显示使用
    private Integer available; //是否可用,如果不可用将不会添加给用户
    
    private Set<Permission> permissionSet=new HashSet<>();

    public Role() {
    }

    public Role(String role, String description, Integer available) {
        this.role = role;
        this.description = description;
        this.available = available;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    
    public Set<Permission> getPermissionSet() {
		return permissionSet;
	}

	public void setPermissionSet(Set<Permission> permissionSet) {
		this.permissionSet = permissionSet;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (id != null ? !id.equals(role.id) : role.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

	@Override
	public String toString() {
		return "Role [id=" + id + ", role=" + role + ", description=" + description + ", available=" + available
				+ ", permissionSet=" + permissionSet + "]";
	}
    
   
}
