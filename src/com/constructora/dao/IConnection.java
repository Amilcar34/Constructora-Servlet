package com.constructora.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public interface IConnection {

	public default Connection getConnection() {
		
		final String user = "root";
		final String password = "";

		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/constructora", user, password);

			if (con != null)
				System.out.println("Funca la conexion");
			else
				System.out.println("No funciono la conexion");

		} catch (Exception error) {
			System.out.println("El error esta en el try and catch");
			error.printStackTrace();
			System.out.println(error.getMessage());
		}
		return con;
	}

}
