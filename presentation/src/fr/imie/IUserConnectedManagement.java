package fr.imie;

public interface IUserConnectedManagement {
	public UserEntity getUserDTO();

	public void setUserDTO(UserEntity userDTO);

	String getAimUrl();

	void setAimUrl(String aimUrl);
}
