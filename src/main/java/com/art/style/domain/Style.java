package com.art.style.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="t_style")
public class Style implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2013025404583474507L;
	@Id
	@GeneratedValue
	private Long id;
	private String image;
	private int type;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
	
}
