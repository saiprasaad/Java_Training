package daytwentyone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCProgram2 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/ey","root","");
		Statement stmt=con.createStatement();
		String query="insert into user_login values('sai','admin')";
		boolean var=stmt.execute(query);
		System.out.println(var);
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
