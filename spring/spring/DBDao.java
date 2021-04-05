package spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import javax.swing.tree.TreePath;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class DBDao {
private DataSource dataSource;

public DataSource getDataSource() {
	return dataSource;
}

public void setDataSource(DataSource dataSource) {
	this.dataSource = dataSource;
}
JdbcTemplate jdbcTemplate;
public void getNoofrows() {
	jdbcTemplate=new JdbcTemplate(dataSource);
	int no=jdbcTemplate.queryForInt("select count(*) from users");
	System.out.println("No of rows is "+no);
}
public void getUID(String username) {
	jdbcTemplate=new JdbcTemplate(dataSource);
	int uid=jdbcTemplate.queryForInt("select uid from users where uname=?",username);
	System.out.println("UID of "+username+" is "+uid);
}
public UserDTO getUserByUID(int uid) {
	jdbcTemplate=new JdbcTemplate(dataSource);
	UserDTO user=new UserDTO();
	return user=jdbcTemplate.queryForObject("select * from users where uid=?",new Object[] {uid},new RowMapper<UserDTO>() {
		@Override
		public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserDTO userdto=new UserDTO();
			userdto.setUname(rs.getString("uname"));
			userdto.setUpass(rs.getString("upass"));
			userdto.setFlag(rs.getInt("flag"));
			userdto.setUid(uid);
			return userdto;
		}
	});				
}
public List<UserDTO> getUsersByFlag(int flag){
	jdbcTemplate=new JdbcTemplate(dataSource);
	List<Map<String, Object>> ans=jdbcTemplate.queryForList("select * from users where flag=?",new Object[] {flag});
	List<UserDTO> userslist=new ArrayList<UserDTO>();
	for (Map<String, Object> rowMap :ans) {
		UserDTO userdto=new UserDTO();
		userdto.setUid((int)rowMap.get("uid"));
		userdto.setFlag((int)rowMap.get("flag"));
		userdto.setUname((String)rowMap.get("uname"));
		userdto.setUpass((String)rowMap.get("upass"));
		userslist.add(userdto);
		
	}
	return userslist;
		
}
}
