package daytwentyone;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class JDBCProgram5 {
	public static void main(String[] args) {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/<dbname>","root","");
		CallableStatement cstmt = null;
		String SQL = "{call insertproc (?, ? ,?)}";
		
		cstmt = con.prepareCall (SQL);
		cstmt.setInt(1, 1005);
		cstmt.setString(2, "ranjith");
		cstmt.setString(3, "sanjith");
		cstmt.execute();
		System.out.println("success");
		}catch(Exception e) {e.printStackTrace();}
	}
}
