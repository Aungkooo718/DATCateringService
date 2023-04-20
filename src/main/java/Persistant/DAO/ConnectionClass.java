package Persistant.DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass 
{
	static Connection con = null;
	public static Connection myConnection()
	{
		try {
		Class.forName("com.mysql.jdbc.Driver");
		con= DriverManager.getConnection("jdbc:mysql://localhost:3306/person", "root", "root");
		} catch (ClassNotFoundException e) {
		System.out.println("Driver class not found");
		} catch (SQLException e) {
		System.out.println("Database Coonectin not found"); 
		}
		return con;
		
	}
}
