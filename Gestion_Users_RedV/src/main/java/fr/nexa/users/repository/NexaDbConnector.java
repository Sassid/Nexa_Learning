package fr.nexa.users.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class NexaDbConnector {

	public static Connection getConnection() throws Exception {
		
		String url = "jdbc:mysql://localhost:3306/nexa_bach_db?useSSL=false&ServerTimezone=UTC";
		String user = "root";
		String password = "root";
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		return DriverManager.getConnection(url, user, password);
	}
}
