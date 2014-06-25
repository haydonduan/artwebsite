package com.art.comment.dto;

import java.io.Serializable;
import java.util.Date;

public class CommentDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1067740638000928410L;
	private Long id;
	private Long userId;
	private String comment;
	private String formatCreateTime;
	private Date createTime;
	private String name;
	private String image;
	private int allCount;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getAllCount() {
		return allCount;
	}
	public void setAllCount(int allCount) {
		this.allCount = allCount;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFormatCreateTime() {
		return formatCreateTime;
	}
	public void setFormatCreateTime(String formatCreateTime) {
		this.formatCreateTime = formatCreateTime;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
