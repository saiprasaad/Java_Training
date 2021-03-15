package daytwentyone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCProgram3 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/ey","root","");
		Statement stmt=con.createStatement();
		String query="select * from user_login";
		ResultSet rs=stmt.executeQuery(query);
		System.out.println("userid"+" "+"username"+" "+"password");
		while(rs.next()) {
			System.out.println(rs.getString("userid")+"\t"+rs.getString("username")+"\t"+rs.getString("password"));
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
