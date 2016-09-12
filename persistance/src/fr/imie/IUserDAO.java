package fr.imie;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
	public List<UserDTO> getUsers() throws SQLException;

	UserDTO addUser(UserDTO user) throws SQLException ;
}
