package com.art.score.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.art.user.domain.User;
@Entity
@Table(name="t_score")
public class Score implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 628629855124937774L;
	@Id
	@GeneratedValue
	private int id;
	@OneToOne
	@JoinColumn(name="user_id")
	private User userId;
	private int score;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
}
