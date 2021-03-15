package daytwentyone;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Savepoint;
import java.sql.Statement;
public class TransactionDemo {
	public static void main(String[] args)throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/ey","root","");
		con.setAutoCommit(false);
		Statement st=con.createStatement();
		Savepoint spFirst=null;
		try {
			st.executeUpdate("update user_login set username='rohith vigneshwar' where userid=1004");
			spFirst=con.setSavepoint("first");
			st.executeUpdate("update user_login set username='rohith vig' where user_id=1004");
			con.commit();
		}catch(Exception e) {
			con.rollback(spFirst);
			con.commit();
		}
		
		
	}
}