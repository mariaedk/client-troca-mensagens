package com.redes.chat.dtos;

public class UsuarioDTO {

	private String userId;	
	private String username;
	private String passwd;
	private Integer wins;
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPasswd() {
		return passwd;
	}
	
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	public Integer getWins() {
		return wins;
	}
	
	public void setWins(Integer wins) {
		this.wins = wins;
	}
	
	@Override
	public String toString() {
		return String.format("%s - %s", userId, username);
	}
	
}
