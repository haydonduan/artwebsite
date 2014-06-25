package com.art.article.dto;

import java.util.Date;

public class ArticleDto {
	private Long id;
	private String name;
	private String title;
	private String content;
	private Integer clickNum;
	private Integer artComment;
	private Integer artCount;
	private Date createTime;
	private int isView;
	private String image;
	
	
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getIsView() {
		return isView;
	}
	public void setIsView(int isView) {
		this.isView = isView;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getClickNum() {
		return clickNum;
	}
	public void setClickNum(Integer clickNum) {
		this.clickNum = clickNum;
	}
	public Integer getArtComment() {
		return artComment;
	}
	public void setArtComment(Integer artComment) {
		this.artComment = artComment;
	}
	public Integer getArtCount() {
		return artCount;
	}
	public void setArtCount(Integer artCount) {
		this.artCount = artCount;
	}

	
	
}
