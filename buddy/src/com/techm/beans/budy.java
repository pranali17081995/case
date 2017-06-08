package com.techm.beans;

public class budy {
	
	private int j_code;
	private String name;
	private String skill;
	private int yoe;
	private String location;
	private String mail;
	private String status;
	
	
	public int getJ_code() {
		return j_code;
	}


	public void setJ_code(int j_code) {
		this.j_code = j_code;
	}
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = "new";
	}

	public budy() {
		super();
	}
	
	
	


	public budy(int j_code, String name, String skill, int yoe,
			String location, String mail, String status) {
		super();
		this.j_code = j_code;
		this.name = name;
		this.skill = skill;
		this.yoe = yoe;
		this.location = location;
		this.mail = mail;
		this.status = status;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public int getYoe() {
		return yoe;
	}
	public void setYoe(int yoe) {
		this.yoe = yoe;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
	
}


