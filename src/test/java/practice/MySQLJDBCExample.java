package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * MySQLJDBCExample - A simple Java program to demonstrate JDBC connection to a MySQL database.
 * This program connects to a MySQL database, executes a query, and prints the result.
 * 
 * Created on: April 3, 2025
 * 
 * @author Hitesh
 * 
 */
public class MySQLJDBCExample {

	public static void main(String[] args) throws SQLException, Throwable {

		// Step 1: Register the MySQL JDBC driver (optional for newer versions)
        // This step ensures that the JDBC driver is loaded into memory
		Class.forName("com.mysql.jdbc.Driver");

		// Step 2: Establish connection with DataBase -- give DB name
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "root");
        
        //Create a Statement object to send SQL queries to the database
		Statement stmt = con.createStatement();
        //Query to retrieve the MySQL server version
        String versionQuery = "SELECT VERSION()"; 
        ResultSet rs = stmt.executeQuery(versionQuery);
        //Process and print the MySQL version
        if (rs.next()) {
            String mysqlVersion = rs.getString(1); // Retrieve the version from the result set
            System.out.println("Connected to MySQL Server. Version: " + mysqlVersion+"\n");
        }

        System.out.println("=========================================================");
        		
		// Step 3: Issue create statement
		Statement state = con.createStatement();

		// Step 4:Execute the query -- give table name
		ResultSet result = state.executeQuery("select * from customerinfo;");

		while (result.next()) {
			System.out.println(result.getString(1) + "\t\t" + result.getInt(2) + "\t" + result.getString(3));
		}
		
        System.out.println("=========================================================");
		
		
	}
}
