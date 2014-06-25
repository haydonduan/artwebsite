package com.art.user.dto;

public class UploadUserDto {
	private String name;
	private String psw;
	private String repsw;
	private String oldpsw;
	private byte sex;
	
	
	public byte getSex() {
		return sex;
	}
	public void setSex(byte sex) {
		this.sex = sex;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	public String getRepsw() {
		return repsw;
	}
	public void setRepsw(String repsw) {
		this.repsw = repsw;
	}
	public String getOldpsw() {
		return oldpsw;
	}
	public void setOldpsw(String oldpsw) {
		this.oldpsw = oldpsw;
	}
	
}
