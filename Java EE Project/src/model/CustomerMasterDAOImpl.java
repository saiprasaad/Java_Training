package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class CustomerMasterDAOImpl implements CustomerMasterDAO,Cloneable{
	private static CustomerMasterDAOImpl customermasterdaoimpl;
	private Properties prop;
	private CustomerMasterDAOImpl(Properties prop) {
		this.prop=prop;
	}
	
	synchronized public static CustomerMasterDAOImpl getCustomerMasterDAOImpl(Properties prop) {
		
		if(customermasterdaoimpl==null) {
			 customermasterdaoimpl=new CustomerMasterDAOImpl(prop);
			return customermasterdaoimpl;
		}
		else {
			return customermasterdaoimpl.createClone();
		}
	}
	public CustomerMasterDAOImpl createClone() {
		try {
			return (CustomerMasterDAOImpl)super.clone();
		}catch(Exception e) {
			return null;
		}
	}
	@Override
	public int insertCustomer(CustomerMasterDTO customerMasterDTO) {
		try {
		Connection con=DBUtility.getConnection(prop);
		String query="insert into customermaster (CustomerNo,CustomerName,CustomerAddress,CustomerEmail,CustomerPhone) values(?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, customerMasterDTO.getCustomerno());
        ps.setString(2, customerMasterDTO.getCustomername());
        ps.setString(3, customerMasterDTO.getCustomeraddress());
        ps.setString(4, customerMasterDTO.getCustomeremail());
        ps.setString(5, customerMasterDTO.getCustomerphone());
        ps.execute();
        con.commit();
		}catch(Exception e) {e.printStackTrace();}
		return 0;
	}

	@Override
	public int deleteCustomer(int custno) {
		CustomerMasterDTO customerobj=new CustomerMasterDTO();
		String query="delete from customermaster where CustomerNo=?";
		try {
			Connection con=DBUtility.getConnection(prop);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1,custno);
			ps.execute();
			con.commit();
		}catch(Exception e) {}
		return 0;
	}

	@Override
	public int updateCustomer(CustomerMasterDTO customerMasterDTO) {
		CustomerMasterDTO customerobj=new CustomerMasterDTO();
		String query="update customermaster set CustomerName=?,CustomerAddress=?,CustomerPhone=?,CustomerEmail=? where CustomerNo=?";
		try {
			Connection con=DBUtility.getConnection(prop);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, customerMasterDTO.getCustomername());
			ps.setString(2, customerMasterDTO.getCustomeraddress());
			ps.setString(3, customerMasterDTO.getCustomerphone());
			ps.setString(4, customerMasterDTO.getCustomeremail());
			ps.setInt(5, customerMasterDTO.getCustomerno());
			System.out.println(ps);
			ps.executeUpdate();
			con.commit();
		}catch(Exception e) {e.printStackTrace();}
		return 0;
	}

	@Override
	public CustomerMasterDTO getCustomerMaster(int custno) {

		CustomerMasterDTO customerobj=new CustomerMasterDTO();
		String query="select * from customermaster where CustomerNo=?";
		try {
			Connection con=DBUtility.getConnection(prop);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1,custno);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				customerobj.setCustomerno(rs.getInt("CustomerNo"));
				customerobj.setCustomername(rs.getString("CustomerName"));
				customerobj.setCustomeremail(rs.getString("CustomerEmail"));
				customerobj.setCustomeraddress(rs.getString("CustomerAddress"));
				customerobj.setCustomerphone(rs.getString("CustomerPhone"));
			}
			return customerobj;
		}catch(Exception e) {
			DBUtility.closeConnection(e);
			return null;
		}
	}
	@Override
	public Set<CustomerMasterDTO> getCustomerMasterAll() {
		Set<CustomerMasterDTO> customerdetails=new HashSet<CustomerMasterDTO>();
		Statement stmt;
		try {
			Connection con=DBUtility.getConnection(prop);
			CustomerMasterDTO customerobj;
			stmt = con.createStatement();
		String query="select * from customermaster";
		ResultSet rs=stmt.executeQuery(query);
		while(rs.next()) {
			customerobj=new CustomerMasterDTO();
			customerobj.setCustomerno(rs.getInt("CustomerNo"));
			customerobj.setCustomername(rs.getString("CustomerName"));
			customerobj.setCustomeremail(rs.getString("CustomerEmail"));
			customerobj.setCustomeraddress(rs.getString("CustomerAddress"));
			customerobj.setCustomerphone(rs.getString("CustomerPhone"));
			customerdetails.add(customerobj);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customerdetails;
	}

	@Override
	public String getemail(int custno) {
		try {
		Connection con=DBUtility.getConnection(prop);
		String email="";
		String query="select CustomerEmail from customermaster where CustomerNo=?";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setInt(1, custno);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			email=rs.getString("CustomerEmail");
		}
		return email;
		}catch(Exception e) {e.printStackTrace();}
		return null;
	}
	@Override
	public String getphone(int custno) {
		try {
		Connection con=DBUtility.getConnection(prop);
		String phone="";
		String query="select CustomerPhone from customermaster where CustomerNo=?";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setInt(1, custno);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			phone=rs.getString("CustomerPhone");
		}
		return phone;
		}catch(Exception e) {e.printStackTrace();}
		return null;
	}
}
