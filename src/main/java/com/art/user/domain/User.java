package com.art.user.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "t_user")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8641544064637808949L;
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String password;
	private String detail;
	private int age;
	private byte sex;
	private String address;
	private String telephone;
	@Column(name="is_painter")
	private byte isPainter;
	private String image;
	private String email;
	@Column(name="is_admin")
	private byte isAdmin;
	public byte getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(byte isAdmin) {
		this.isAdmin = isAdmin;
	}

	public User(){}
	
	public User(String name,String password){
		this.name = name;
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name="email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="image")
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public byte getSex() {
		return sex;
	}
	public void setSex(byte sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public byte getIsPainter() {
		return isPainter;
	}
	public void setIsPainter(byte isPainter) {
		this.isPainter = isPainter;
	}
	
	
	
	
}
