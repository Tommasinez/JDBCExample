package it.betacom.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbHandler {
	private static DbHandler instance;
	private static Connection connection;
	
	private DbHandler() {
	}

	public static DbHandler getInstance() {
		if (instance == null) {
			instance = new DbHandler();
		}

		return instance;
	}

	public Connection getConnection() {
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream("db.properties"));
			String url = properties.getProperty("jdbc.url");
			String user = properties.getProperty("jdbc.username");
			String password = properties.getProperty("jdbc.password");
			
			connection = DriverManager.getConnection(url, user, password);
			if (connection != null) {
				System.out.println("Connected to the database!");
			}
		} catch (SQLException | IOException exception) {
			exception.printStackTrace();
		}

		return connection;
	}

	public void closeConnection() {
		try {
			if (connection != null) {
				connection.close();
				System.out.println("Connection close");
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}
}
