package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DatabaseConnection {
	
	//method to initialize database
	public static void initialize() throws Exception{
		try{
			createTables();
		}catch(Exception e){System.out.println(e);}
		finally{
			System.out.println("Database Initialized Successfully!");
		}
	}
	
	//method to initialize database with tables
	public static void createTables() throws Exception{
		try{
			Connection con = getdbConnection();
			//System.out.println("Connected. Creating database tables...");
			//user table
			PreparedStatement createUsers = con.prepareStatement(""
					+ "CREATE TABLE IF NOT EXISTS test_users("
					+ "id int NOT NULL AUTO_INCREMENT,"
					+ "fname varchar(30),"
					+ "lname varchar(30),"
					+ "email varchar(30),"
					+ "PRIMARY KEY(id))");
			//items table
			PreparedStatement createItems = con.prepareStatement(""
					+ "CREATE TABLE IF NOT EXISTS test_items("
					+ "id int NOT NULL AUTO_INCREMENT,"
					+ "name varchar(30),"
					+ "owner varchar(30),"
					+ "category varchar(30),"
					+ "status varchar(30),"
					+ "borrowDate date,"
					+ "returnDate date,"
					+ "PRIMARY KEY(id))");
			//execute statements
			createUsers.executeUpdate();
			createItems.executeUpdate();
			
		}catch(Exception e){System.out.println(e);}
		finally{System.out.println("Tables created.");};
	}
	
	//MySQL database connection
	public static Connection getdbConnection() throws Exception{
		try{
			String driver = "com.mysql.jdbc.Driver";
			String database = "test_db";                  //change to production database
			String url = "jdbc:mysql://localhost/" + database;
			String username = "root";
			String password = "mypass";
			//Load JDBC driver
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url,username,password);
		
			return conn;
		}catch(Exception e){System.out.println(e);}
		
		return null;
	}

}


