package cn.star.autorder.shiro.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class Permission implements Serializable {
	private static final long serialVersionUID = -1500889681553065298L;
	private String id;
    private String permission; //权限标识 程序中判断使用,如"user:create"
    private String description; //权限描述,UI界面显示使用
    private String avaliable; //是否可用,如果不可用将不会添加给用户
    private Set<Resource> resuorceSet=new HashSet<>();

    public Permission() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvaliable() {
		return avaliable;
	}

	public void setAvaliable(String avaliable) {
		this.avaliable = avaliable;
	}

	public Set<Resource> getResuorceSet() {
		return resuorceSet;
	}

	public void setResuorceSet(Set<Resource> resuorceSet) {
		this.resuorceSet = resuorceSet;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Permission role = (Permission) o;

        if (id != null ? !id.equals(role.id) : role.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

	@Override
	public String toString() {
		return "Permission [id=" + id + ", permission=" + permission + ", description=" + description + ", avaliable="
				+ avaliable + ", resuorceSet=" + resuorceSet + "]";
	}

   
}
