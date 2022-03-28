package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Sample_Select_Sql_Query_Execution {

	public static void main(String[] args) throws Throwable {
		Connection conn=null;
		try {
		//step 1 : load / register the database
		Driver driverRef =new Driver();
		DriverManager.registerDriver(driverRef);
		//step 2: connect to database
		conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra", "root", "root");
		System.out.println("======done=====");
		//step 3: issue sql query
		Statement stat= conn.createStatement();
		
		//step 4: execute query
		String query ="select * from students_info";
		ResultSet result = stat.executeQuery(query);
		
		while(result.next())
		{
			System.out.println(result.getInt(1) + "\t" + result.getString(2) + "\t" + result.getString(3) + "\t" + result.getString(4));
		}
		}catch (Exception e) {
		
		}finally {
		//step 5: close the db connection
		conn.close();
		System.out.println("working");
	}
	}
}

