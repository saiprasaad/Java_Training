package daytwentyone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCProgram4 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/<dbname>","root","");
		PreparedStatement ps=con.prepareStatement("insert into user_login values ( ? ,?, ? ) ");
		ps.setInt(1,1004);
		ps.setString(2,"rohith"); 
		ps.setString(3,"drv"); 
		ps.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
