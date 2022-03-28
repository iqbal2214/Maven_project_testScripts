package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Sample_NonSelect_Sql_Query_Execution {
	public static void main(String[] args) throws Throwable {
		Connection conn=null;
		try {
		
		//step 1 : load / register the database
		Driver driverRef =new Driver();
		DriverManager.registerDriver(driverRef);
		//step 2: connect to database
		conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/myntra", "root", "root");
		System.out.println("======connected to database=====");
		//step 3: issue sql query
		Statement stat= conn.createStatement();
		
		//step 4: execute query
		String query =("insert into students_info values('1','ram','gowda','h');" +  
				"insert into students_info values('8','shashi','kumar','h');" + 
				"insert into students_info values('3','zam','christ','h');" + 
				"insert into students_info values('4','shakir','muslim','h');" + 
				"\r\n" + 
				"insert into students_info values('6','bibhu','datta','h');" +
				"");
		
		int result = stat.executeUpdate(query);
		
		if(result==1)
		{
			System.out.println("inserted succusfully===Pass");
		}
		}
		catch (Exception e){
			System.out.println("failed to create ===Fail");
		}finally {
		//step 5: close the db connection
		conn.close();

	}
}
}