package com.art.menu.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "t_menu")
public class Menu implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4444670699306691448L;
	@Id
	private Long id;
	private String text;
	@Column(name="parent_id")
	private Long parentId;
	@Column(name="del_flg")
	private byte delFlg;
	
	private int sequence;
	
	
	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public byte getDelFlg() {
		return delFlg;
	}
	public void setDelFlg(byte delFlg) {
		this.delFlg = delFlg;
	}
	
}
