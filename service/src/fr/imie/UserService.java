package fr.imie;

import java.sql.SQLException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Regular
public class UserService implements IUserService {

	@Inject IUserDAO userDAO;
	
	@Override
	public List<UserDTO> getAllUsers() {
		List<UserDTO> retour= null;
		try {
			retour= userDAO.getUsers();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
		return retour;
	}


}
