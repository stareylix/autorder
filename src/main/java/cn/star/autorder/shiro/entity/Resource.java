package cn.star.autorder.shiro.entity;

import java.io.Serializable;

public class Resource implements Serializable{
	
	private static final long serialVersionUID = -3765951995272685754L;
	private String id;
	private String resource;
	private String description;
	private Integer avaliable;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getAvaliable() {
		return avaliable;
	}
	public void setAvaliable(Integer avaliable) {
		this.avaliable = avaliable;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resource role = (Resource) o;

        if (id != null ? !id.equals(role.id) : role.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
	@Override
	public String toString() {
		return "Resource [id=" + id + ", resource=" + resource + ", description=" + description + ", avaliable="
				+ avaliable + "]";
	}
	
}
