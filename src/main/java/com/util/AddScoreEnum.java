package com.util;

public enum AddScoreEnum {
	COMMENT(1), FORUM(5);
	private int score;

	private AddScoreEnum(int score) {
		this.score = score;
	}

	public int getScore() {
		return score;
	}

}
