package com.FinalBugProject.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class EditProfile {
	private long User_ID_FK;
	public long getUser_ID_FK() {
		return User_ID_FK;
	}
	public void setUser_ID_FK(long user_ID_FK) {
		this.User_ID_FK = user_ID_FK;
	}
	@Column(name="ImageName")
	private String imageName;

	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	@Id
	@Column
	private long Id;
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		this.Id = id;
	}
	
	public String getFullName() {
		return FullName;
	}
	public void setFullName(String fullName) {
		FullName = fullName;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getWebsiteURL() {
		return WebsiteURL;
	}
	public void setWebsiteURL(String websiteURL) {
		WebsiteURL = websiteURL;
	}
	public String getLinkedInURL() {
		return LinkedInURL;
	}
	public void setLinkedInURL(String linkedInURL) {
		LinkedInURL = linkedInURL;
	}
	public String getFacebookURL() {
		return FacebookURL;
	}
	public void setFacebookURL(String facebookURL) {
		FacebookURL = facebookURL;
	}
	public String getPrimaryProf() {
		return PrimaryProf;
	}
	public void setPrimaryProf(String primaryProf) {
		PrimaryProf = primaryProf;
	}
	public String getSecondaryProf() {
		return SecondaryProf;
	}
	public void setSecondaryProf(String secondaryProf) {
		SecondaryProf = secondaryProf;
	}
	public String getTertiaryProf() {
		return TertiaryProf;
	}
	public void setTertiaryProf(String tertiaryProf) {
		TertiaryProf = tertiaryProf;
	}
	private String FullName;
	private String DOB;
	@Column(name="PhoneNumber")
	private String Phno;
	public String getPhno() {
		return Phno;
	}
	public void setPhno(String phno) {
		Phno = phno;
	}

	private String WebsiteURL;
	private String LinkedInURL;
	private String FacebookURL;
	private String PrimaryProf;
	private String SecondaryProf;
	private String TertiaryProf;
}
