package fr.nexa.users.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.Set;

import fr.nexa.users.entity.User;

public class UserRepository implements IUsersRepository {

	public UserRepository() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Integer addUser(User user) throws Exception {
		if (user == null) {
			throw new NullPointerException("Le user à créer doit être non NULL !");
		}

		if (user.getNom() == null || user.getNom().isBlank() || user.getPrenom() == null || user.getPrenom().isBlank()
				|| user.getEmail() == null || user.getEmail().isBlank() || user.getPassword() == null
				|| user.getPassword().isBlank()) {
			throw new IllegalArgumentException("Un ou plusieurs paramètres sont manquants");

		}

		Connection connection = NexaDbConnector.getConnection();
		ResultSet rs = null;

		try {
			String request = "INSERT INTO user(nom, prenom, email, password) VALUES(?,?,?,?)";

			PreparedStatement ps = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, user.getNom());
			ps.setString(2, user.getPrenom());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());

			ps.executeUpdate();

			rs = ps.getGeneratedKeys();
			
			if (rs != null && rs.next()) {
				return rs.getInt(1);
			}

		} finally {
			if (connection != null && !connection.isClosed() ) {
				connection.close();
			}
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
		}
		return null;
	}

	@Override
	public void updateUser(User user) throws Exception {
		if (user == null) {
			throw new NullPointerException("Le user à créer doit être non NULL !");
		}

		if (user.getNom() == null || user.getNom().isBlank() || user.getPrenom() == null || user.getPrenom().isBlank()
				|| user.getEmail() == null || user.getEmail().isBlank() || user.getPassword() == null
				|| user.getPassword().isBlank()) {
			throw new IllegalArgumentException("Un ou plusieurs paramètres sont manquants");

		}

		Connection connection = NexaDbConnector.getConnection();
		ResultSet rs = null;
		
		try {
			
		} finally {
			// TODO: handle finally clause
		}

	}

	@Override
	public void removeUser(Integer id) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public User getUser(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(String email) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsers(String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<User> findUsersOfVille(String ville) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Set<User>> findUsersByVille() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
