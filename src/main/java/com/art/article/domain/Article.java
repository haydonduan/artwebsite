package com.art.article.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.art.user.domain.User;
@Entity
@Table(name = "t_article")
public class Article implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2662245083173278370L;
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String content;
	@Column(name="create_time")
	private Date createTime;
	@Column(name="click_number")
	private int clickNumber;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	@Column(name="is_view")
	private int isView;
	
	
	public int getIsView() {
		return isView;
	}
	public void setIsView(int isView) {
		this.isView = isView;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getClickNumber() {
		return clickNumber;
	}
	public void setClickNumber(int clickNumber) {
		this.clickNumber = clickNumber;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
