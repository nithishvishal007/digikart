package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="user")
public class User {
	@Id
private String username;
private String password;
private String customername;
private String mobileno;
private String emailId;
private String role;
private String enabled;
public String getCustomername() {
	return customername;
}
public void setCustomername(String customername) {
	this.customername = customername;
}

public String getMobileno() {
	return mobileno;
}
public void setMobileno(String mobileno) {
	this.mobileno = mobileno;
}


public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public String getEnabled() {
	return enabled;
}
public void setEnabled(String enabled) {
	this.enabled = enabled;
}

}
