package cn.star.autorder.usermanager.entity;

import java.io.Serializable;


public class User implements Serializable{

	private static final long serialVersionUID = 5306085003927673156L;
	
	private String userid;
	private String username;
	private String password;
	private String salt;
	private String enabaled;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
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
	public String getEnabaled() {
		return enabaled;
	}
	public void setEnabaled(String enabaled) {
		this.enabaled = enabaled;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public boolean equals(Object o) {
		 if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	
	        User user = (User) o;
	
	        if (userid != null ? !userid.equals(user.userid) : user.userid != null) return false;
	
	        return true;
	}
	
	@Override
	public int hashCode() {
		return userid != null ? userid.hashCode() : 0;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", password=" + password + ", salt=" + salt
				+ ", enabaled=" + enabaled + "]";
	}

}
