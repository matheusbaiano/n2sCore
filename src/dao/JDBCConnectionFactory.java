package dao;

import java.sql.Connection;
import java.sql.DriverManager;

import util.Facade;

public class JDBCConnectionFactory {

	private JDBCConnectionFactory() {
		//
	}

	public static Connection getConnection() {
		try {
			String[] bd = Facade.lerArquivoBancoDeDados();
			Class.forName("org.postgresql.Driver");			
			return DriverManager.getConnection(bd[0], bd[1], bd[2]);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

}