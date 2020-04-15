package com.FinalBugProject.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Signup {
	@Id
	@Column(name="User_ID_PK")
	private long id;
	@Column(name="Username")
	private String Uname;
	@Column(name="Password")
	private String Pwd;
	@Column(name="Email")
	private String mailid;
	@Column(name="Designation")
	private String desig;
	public String getDesig() {
		return desig;
	}

	public void setDesig(String desig) {
		this.desig = desig;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
		
	}
	public String getUname() {
		return Uname;
	}
	public void setUsername(String Uname) {
		this.Uname = Uname;
	}
	public String getPwd() {
		return Pwd;
	}
	public void setPwd(String Pwd) {
		this.Pwd = Pwd;
	}
	public String getEmail() {
		return mailid;
	}
	public void setEmail(String email) {
		this.mailid = email;
	}
	

}
