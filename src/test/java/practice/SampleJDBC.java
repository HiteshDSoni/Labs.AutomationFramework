package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.testng.annotations.Test;
import com.mysql.jdbc.Driver;

/**
 * SampleJDBC - A simple Java program to demonstrate JDBC connection to a MySQL database.
 * This program has two test cases:
 * 1-connects to a MySQL database, executes a query, and prints the result.
 * 2-connects to a MySQL database, updates a query, and prints the result.
 * 
 * Created on: April 3, 2025
 * 
 * @author Hitesh
 * 
 */

public class SampleJDBC {

	@Test
	public void jdbcExecuteQuery() throws SQLException {
		
		Driver ref = new Driver();

		//Step 1: register Driver
		DriverManager.registerDriver(ref);

		//Step 2: get connection
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "root");

		//Step 3: create statement
		Statement state=con.createStatement();
				
		//Step 4: execute the query
		ResultSet result=state.executeQuery("select * from customerinfo;");

		while(result.next())
		{
		System.out.println(result.getString(1)+"-"+result.getInt(2)+"-"+result.getString(3));
		}

		//Step 5:
		con.close();
	}	
	
	
	@Test
	public void jdbcExecuteUpdate() throws SQLException {
		
		Driver ref = new Driver();

		//Step 1: register Driver
		DriverManager.registerDriver(ref);

		//Step 2: get connection
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "root");

		//Step 3: create statement
		Statement state=con.createStatement();
				
		//Step 4: execute the query
		int result=state.executeUpdate("insert into customerinfo values('Pankaj',28,'Delhi')");

		if(result==1)
		{
		System.out.println("data added");
		}

		//Step 5:
		con.close();
	}	
	
}
