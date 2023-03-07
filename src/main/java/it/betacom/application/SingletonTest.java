package it.betacom.application;

import it.betacom.factory.DbHandler;

public class SingletonTest {
	public static void main(String[] args) {
		DbHandler instance = DbHandler.getInstance();
		
		instance.getConnection();
		instance.closeConnection();
	}
}
