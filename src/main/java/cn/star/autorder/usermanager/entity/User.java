package cn.star.autorder.usermanager.entity;

import java.io.Serializable;


public class User implements Serializable{

	private static final long serialVersionUID = -4094937441319342413L;
	private String id;
	private String name;
	private String sex;
	private int age;
	private String phone;
	private String address;
	private String dutycode;
	private String enable;
	private String enDriver;
	private String carnumber;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDutycode() {
		return dutycode;
	}
	public void setDutycode(String dutycode) {
		this.dutycode = dutycode;
	}
	public String getEnable() {
		return enable;
	}
	public void setEnable(String enable) {
		this.enable = enable;
	}
	public String getEnDriver() {
		return enDriver;
	}
	public void setEnDriver(String enDriver) {
		this.enDriver = enDriver;
	}
	public String getCarnumber() {
		return carnumber;
	}
	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj==null)
			return false;
		if(this==obj) {
			return true;
		}else {
			if(obj instanceof User) {
				User uo=(User)obj;
				if(id != null) {
					if(id.equals(uo.id)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return id != null ? id.hashCode() : 0;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", sex=" + sex + ", age=" + age + ", phone=" + phone + ", address="
				+ address + ", dutycode=" + dutycode + ", enable=" + enable + ", enDriver=" + enDriver + ", carnumber="
				+ carnumber + "]";
	}
	

}
