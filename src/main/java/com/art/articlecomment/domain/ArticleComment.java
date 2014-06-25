package com.art.articlecomment.domain;

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
@Table(name = "t_article_comment")
public class ArticleComment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4083898125690389832L;
	@Id
	@GeneratedValue
	private Long id;
	@Column(name="article_id")
	private Long article;
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	private String comment;
	@Column(name="create_time")
	private Date createTime;
	@Column(name="del_flg")
	private byte delFlg;
	@Column(name="is_reply")
	private byte isReply;
	
	
	public byte getIsReply() {
		return isReply;
	}
	public void setIsReply(byte isReply) {
		this.isReply = isReply;
	}
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
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
	public Long getArticle() {
		return article;
	}
	public void setArticle(Long article) {
		this.article = article;
	}
	
}
