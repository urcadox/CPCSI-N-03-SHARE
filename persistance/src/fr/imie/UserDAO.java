package fr.imie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;


@Dependent
@ConnetionManagement
public class UserDAO implements IUserDAO, ConnectionSupport {

	private @Inject ConnectionProvider connectionProvider;
	private Connection connection;

	@Override
	public List<UserDTO> getUsers() throws SQLException {

		Statement statement = null;
		ResultSet resultSet = null;
		List<UserDTO> retour = new ArrayList<UserDTO>();

		statement = connection.createStatement();
		resultSet = statement.executeQuery("SELECT id,login,mdp FROM personne");

		while (resultSet.next()) {
			UserDTO personneDTO = buildDTOFromResultset(resultSet);
			retour.add(personneDTO);
		}

		return retour;
	}

	@Override
	public UserDTO addUser(UserDTO userToInsert) throws SQLException {

		PreparedStatement statement = null;
		ResultSet resultSet = null;
		UserDTO retour = null;

		List<ParamJDBC> paramsList = new ArrayList<ParamJDBC>();
		if (userToInsert.getLogin() != null) {
			paramsList.add(new ParamJDBC("login", userToInsert.getLogin()));
		}
		if (userToInsert.getPassw() != null) {
			paramsList.add(new ParamJDBC("mdp", userToInsert.getPassw()));
		}
	

		String fields = "";
		String params = "";
		Boolean firstField = true;
		for (ParamJDBC paramJDBC : paramsList) {
			fields = fields.concat(firstField ? "" : ",").concat(paramJDBC.getNom());
			params = params.concat(firstField ? "" : ",").concat("?");
			firstField = false;
		}

		String query = "INSERT into personne (".concat(fields).concat(") values (").concat(params)
				.concat(") returning id, nom, prenom, datenaiss");

		statement = connection.prepareStatement(query);

		Integer paraNumber = 1;
		for (ParamJDBC paramJDBC : paramsList) {
			statement.setObject(paraNumber++, paramJDBC.getValue());
		}

		resultSet = statement.executeQuery();
		resultSet.next();
		retour = buildDTOFromResultset(resultSet);

		return retour;

	}

	private UserDTO buildDTOFromResultset(ResultSet resultSet) throws SQLException {
		UserDTO retour;
		retour = new UserDTO();

		retour.setLogin(resultSet.getString("login"));
		retour.setPassw(resultSet.getString("mdp"));

		return retour;
	}

	@Override
	public void setConnection(Connection conn) {
		this.connection = conn;

	}

	@Override
	public Connection getConnection() {
		return connection;
	}

}
