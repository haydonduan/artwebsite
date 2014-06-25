package com.art.comment.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.art.production.domain.Production;
import com.art.user.domain.User;
@Entity
@Table(name = "t_comment")
public class Comment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5282080834301745076L;
	@Id
	@GeneratedValue
	private Long id;
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	@OneToOne
	@JoinColumn(name="production_id")
	private Production production;
	private String comment;
	@Column(name="is_review")
	private byte isReview;
	@Column(name="create_time")
	private Date createTime;
	@Column(name="del_flg")
	private byte delFlg;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Production getProduction() {
		return production;
	}
	public void setProduction(Production production) {
		this.production = production;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public byte getIsReview() {
		return isReview;
	}
	public void setIsReview(byte isReview) {
		this.isReview = isReview;
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
