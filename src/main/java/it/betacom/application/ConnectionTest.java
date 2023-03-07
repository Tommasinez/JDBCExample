package it.betacom.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/test_db";
		String user = "root";
		String password = "";

		try (Connection connection = DriverManager.getConnection(url, user, password)) {
			if (connection != null) {
				System.out.println("Connected to the database!");
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}
}
