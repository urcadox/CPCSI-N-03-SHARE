package fr.imie;

public interface IUserConnectedManagement {
	public UserDTO getUserDTO();

	public void setUserDTO(UserDTO userDTO);

	String getAimUrl();

	void setAimUrl(String aimUrl);
}
