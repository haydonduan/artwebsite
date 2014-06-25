package com.art.newsnotice.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "t_notes_news")
public class NewsNotice implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -446150335286151854L;
	@Id
	@GeneratedValue
	private Long id;
	
	private String title;
	
	private String text;
	
	@Column(name="create_time")
	private Date createTime;
	
	@Column(name="del_flg")
	private byte delFlg;
	
	private byte type;
	public byte getType() {
		return type;
	}
	public void setType(byte type) {
		this.type = type;
	}
	@Column(name="is_own")
	private byte isOwn;
	
	private String image;
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public byte getIsOwn() {
		return isOwn;
	}
	public void setIsOwn(byte isOwn) {
		this.isOwn = isOwn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public byte getDelFlg() {
		return delFlg;
	}
	public void setDelFlg(byte delFlg) {
		this.delFlg = delFlg;
	}
	
}
