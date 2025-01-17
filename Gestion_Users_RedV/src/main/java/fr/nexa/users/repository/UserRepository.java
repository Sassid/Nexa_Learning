package fr.nexa.users.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import fr.nexa.users.entity.User;

public class UserRepository implements IUserRepository {

	public UserRepository() {
	}

	@Override
	public Integer addUser(User user) throws Exception {
		if (user == null) {
			throw new NullPointerException("Le user à créer doit être non NULL !");
		}
		if (user.getNom() == null || user.getNom().isBlank() || user.getPrenom() == null || user.getPrenom().isBlank()
				|| user.getEmail() == null || user.getEmail().isBlank() || user.getPassword() == null
				|| user.getPassword().isBlank()) {

			throw new IllegalArgumentException("Un ou plusieurs paramètres sont manquants !");
		}
		Connection connection = NexaDbConnector.getConnection();
		ResultSet rs = null;
		try {
			String requete = "INSERT INTO user(nom, prenom, email, password)" + " VALUES(?,?,?,?)";

			PreparedStatement ps = connection.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
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
			if (connection != null && !connection.isClosed()) {
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
		if (user.getId() == null || user.getId() <= 0 || user.getNom() == null || user.getNom().isBlank()
				|| user.getPrenom() == null || user.getPrenom().isBlank()) {

			throw new IllegalArgumentException("Un ou plusieurs paramètres sont manquants !");
		}
		Connection connection = NexaDbConnector.getConnection();
		try {
			String requete = "UPDATE user SET nom = ?, prenom = ? WHERE id = ?";
			PreparedStatement ps = connection.prepareStatement(requete);
			ps.setString(1, user.getNom());
			ps.setString(2, user.getPrenom());
			ps.setInt(3, user.getId());

			ps.executeUpdate();

		} finally {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
	}

	@Override
	public void removeUser(Integer id) throws Exception {
		if (id == null || id <= 0) {
			throw new IllegalArgumentException("l'ID doit être > 0");
		}
		Connection connection = NexaDbConnector.getConnection();
		try {
			String request = "DELETE FROM user WHERE id = ?";
			PreparedStatement ps = connection.prepareStatement(request);
			ps.setInt(1, id);
			int NumberOfDeletedLines = ps.executeUpdate();
			if (NumberOfDeletedLines == 0) {
				throw new Exception("Aucun user trouvé! (id =" + " " + id + ")");
			}

		} finally {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
	}

	@Override
	public User getUser(Integer id) throws Exception {

		if (id == null || id <= 0) {
			throw new IllegalArgumentException("L'id doit être > 0 !");
		}
		Connection connection = NexaDbConnector.getConnection();
		ResultSet rs = null;
		try {
			String requete = "SELECT * FROM user WHERE id = ?";
			PreparedStatement ps = connection.prepareStatement(requete);
			ps.setInt(1, id);

			rs = ps.executeQuery();
			if (rs != null && rs.next()) {
				User user = new User();
				user.setId(id); // user.setId(rs.getInt("id"));
				user.setNom(rs.getString("nom"));
				user.setPrenom(rs.getString("prenom"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				return user;
			}
		} finally {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
		}
		return null;
	}

	@Override
	public User getUser(String email) throws Exception {
		if (email == null || email.isBlank()) {
			throw new IllegalArgumentException("l'e-mail ne peut pas être vide");
		}
		Connection connection = NexaDbConnector.getConnection();
		ResultSet rs = null;

		try {
			String request = "SELECT * FROM user WHERE email = ?";
			PreparedStatement ps = connection.prepareStatement(request);
			ps.setString(1, email);

			rs = ps.executeQuery();
			if (rs != null && rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setNom(rs.getString("nom"));
				user.setPrenom(rs.getString("prenom"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				return user;
			}

		} finally {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
		}

		return null;
	}

	@Override
	public List<User> getUsers(String name) throws Exception {

		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException("Le nom est obligatoire !");
		}
		Connection connection = NexaDbConnector.getConnection();
		ResultSet rs = null;
		try {
			String requete = "SELECT * FROM user WHERE nom = ?";
			PreparedStatement ps = connection.prepareStatement(requete);
			ps.setString(1, name);

			rs = ps.executeQuery();
			List<User> users = new ArrayList<>();
			if (rs != null) {
				while (rs.next()) {
					User user = new User();
					user.setId(rs.getInt("id"));
					user.setNom(rs.getString("nom"));
					user.setPrenom(rs.getString("prenom"));
					user.setEmail(rs.getString("email"));
					user.setPassword(rs.getString("password"));
					users.add(user);
				}
			}
			return users;
		} finally {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
		}
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
