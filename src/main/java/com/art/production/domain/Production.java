package com.art.production.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.art.user.domain.User;
@Entity
@Table(name = "t_production")
public class Production implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	
	private String title;
	
	private String image;
	
	private String size;
	@Transient
	private String typeStr;
	
	public String getTypeStr() {
		return typeStr;
	}
	public void setTypeStr(String typeStr) {
		this.typeStr = typeStr;
	}
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@Column(name="finish_time")
	private Date finishTime;
	
	private String inspiration;
	
	@Column(name="del_flg")
	private byte delFlg;
	@Column(name="type")
	private int productionType;
	@Column(name="scan_num")
	private int scanNum;
	@Column(name="love_num")
	private int loveNum;
	
	@Transient
	private int commentCount;
	
	
	
	public int getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	public int getProductionType() {
		return productionType;
	}
	public void setProductionType(int productionType) {
		this.productionType = productionType;
	}
	public int getScanNum() {
		return scanNum;
	}
	public void setScanNum(int scanNum) {
		this.scanNum = scanNum;
	}
	public int getLoveNum() {
		return loveNum;
	}
	public void setLoveNum(int loveNum) {
		this.loveNum = loveNum;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
	public String getInspiration() {
		return inspiration;
	}
	public void setInspiration(String inspiration) {
		this.inspiration = inspiration;
	}
	public byte getDelFlg() {
		return delFlg;
	}
	public void setDelFlg(byte delFlg) {
		this.delFlg = delFlg;
	}
	
	
}
