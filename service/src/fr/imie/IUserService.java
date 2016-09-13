package fr.imie;

import java.util.List;

import javax.ejb.Local;

@Local
public interface IUserService {
	public List<UserDTO> getAllUsers();

}
