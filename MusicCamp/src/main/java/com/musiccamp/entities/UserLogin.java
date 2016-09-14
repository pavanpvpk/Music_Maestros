package com.musiccamp.entities;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Pavan Kumar Pedda Vakkalam
 *
 *Creates a table user_login in MYSQL without any need of writing a create table query
 */

@Entity
@Table(name="user_login") 
public class UserLogin implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="role")
	private Integer role;

	public Integer getUsername() {
		return username;
	}

	public void setUsername(Integer username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}
	
	
	
	
}
