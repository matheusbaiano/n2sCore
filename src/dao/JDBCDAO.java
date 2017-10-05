package dao;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class JDBCDAO {
	
	private Connection connection;
	
	

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	protected void open() {
		this.connection = dao.JDBCConnectionFactory.getConnection();
	}
	
	protected void close() {
		try {
			getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
