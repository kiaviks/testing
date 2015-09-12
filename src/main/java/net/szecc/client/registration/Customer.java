package net.szecc.client.registration;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Customer {
	
	private Long id;
	
	@NotBlank @Size(min=6, max=20) private String nickName;
	@NotBlank @Email private String email;
	@NotBlank @Size(min=6, max=20) private String pwd;
	
	private UserType userType;
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Long getId() {
		return id;
	}

	public String getNickName() {
		return nickName;
	}

	public String getEmail() {
		return email;
	}

	public String getPwd() {
		return pwd;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

}
