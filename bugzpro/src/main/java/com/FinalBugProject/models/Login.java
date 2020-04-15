package com.FinalBugProject.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Login {
private long User_ID_FK;
public long getUser_ID_FK() {
	return User_ID_FK;
}
public void setUser_ID_FK(long user_ID_FK) {
	this.User_ID_FK = user_ID_FK;
}
@Id
private long Id;
@Column(name="Email")
private String email;

public long getId() {
	return Id;
}
public void setId(long id) {
	this.Id = id;
}
@Column(name="Password")
private String pwd;

public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return pwd;
}
public void setPassword(String password) {
	this.pwd = password;
}
@Column(name="Designation")
private String desig;
public String getDesig() {
	return desig;
}

public void setDesig(String desig) {
	this.desig = desig;

}

}


