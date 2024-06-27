package it.univaq.disim.sose.service.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.univaq.disim.sose.utils.Utils;

public class SQLiteDAOFactory extends DAOFactory {
	
	public static final String DRIVER = "org.sqlite.JDBC";
	public static final String DATABASE = "jdbc:sqlite::resource:review.db";
	

	public static Connection createConnection() {
		Connection conn = null;
		
		try {
			Class.forName(DRIVER);
			Utils.consoleLog(DATABASE);
			conn = DriverManager.getConnection(DATABASE);
			
			//System.out.println("Connected to database");
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} 
		return conn;
	}
	
	public static void closeDbConnection(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if(rs !=null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(conn!= null) {
				conn.close();
			}
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
	}
	
	public static void DBCreation() {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(DATABASE);;
			Utils.consoleLog("Connected to database ");
			Statement statement = conn.createStatement();
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS review (review_id INTEGER PRIMARY KEY AUTOINCREMENT,food_id INTEGER, title TEXT, comment TEXT, user_id INTEGER");
			Utils.consoleLog("Database created ");
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
  

	}

	@Override 
	public ReviewDAO getReviewDAO() {
		return new SQLiteReviewDAOImpl();
	}
}
