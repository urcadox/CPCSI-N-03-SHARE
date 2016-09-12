package fr.imie;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@SessionScoped
public class UserConnectedManagement implements Serializable, IUserConnectedManagement{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1382068007857245664L;
	UserDTO userDTO = null;
	String aimUrl =null;

	@Override
	public UserDTO getUserDTO() {
		return userDTO;
	}

	@Override
	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	@Override
	public String getAimUrl() {
		return aimUrl;
	}

	@Override
	public void setAimUrl(String aimUrl) {
		this.aimUrl = aimUrl;
	}
	
	
}
