package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
public class InvoiceMasterDAOImpl implements InvoiceMasterDAO,Cloneable {
	private static InvoiceMasterDAOImpl invoicemasterdaoimpl;
	private Properties prop;
	private InvoiceMasterDAOImpl(Properties prop) {
		this.prop=prop;
	}
	
	synchronized public static InvoiceMasterDAOImpl getInvoiceMasterDAOImpl(Properties prop) {
		
		if(invoicemasterdaoimpl==null) {
			 invoicemasterdaoimpl=new InvoiceMasterDAOImpl(prop);
			return  invoicemasterdaoimpl;
		}
		else {
			return invoicemasterdaoimpl.createClone();
		}
	}
	public InvoiceMasterDAOImpl createClone() {
		try {
			return (InvoiceMasterDAOImpl)super.clone();
		}catch(Exception e) {
			return null;
		}
	}
	@Override
	public int insertInvoice(InvoiceMasterDTO invMasterDTO) {
		ResultSet rs;
        int ans=0;
		try {
			Connection con=DBUtility.getConnection(prop);
			String query="insert into invoicemaster (invdate,customerno) values(?,?)";
			PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setDate(1, java.sql.Date.valueOf(invMasterDTO.getInvdate()));
	        ps.setInt(2, invMasterDTO.getCustomerno());
	        ps.execute();
	        rs =ps.getGeneratedKeys();
	        if (rs.next()) {
	        	ans=rs.getInt(1);
			}
	        DBUtility.closeConnection(null);
			return ans;
		}catch(Exception e) {
			DBUtility.closeConnection(e);
			return 0;
		}
	}

	@Override
	public int deleteInvoice(int invno) {
		InvoiceMasterDTO invoiceobj=new InvoiceMasterDTO();
		String query="delete from invoicemaster where invno=?";
		try {
			Connection con=DBUtility.getConnection(prop);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1,invno);
			ps.execute();
			con.commit();
			 DBUtility.closeConnection(null);
				return 1;
			}catch(Exception e) {
				DBUtility.closeConnection(e);
				return 0;
			}
	}
	@Override
	public int updateInvoice(InvoiceMasterDTO invMasterDTO) {
		InvoiceMasterDTO invoiceobj=new InvoiceMasterDTO();
		String query="update invoicemaster set invdate=?,custno=? where invno=?";
		try {
			Connection con=DBUtility.getConnection(prop);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, invMasterDTO.getInvdate());
			ps.setInt(2, invMasterDTO.getCustomerno());
			ps.setInt(3, invMasterDTO.getInvno());
			System.out.println(ps);
			ps.executeUpdate();
			con.commit();
			 DBUtility.closeConnection(null);
				return 1;
			}catch(Exception e) {
				DBUtility.closeConnection(e);
				return 0;
			}
	}
	@Override
	public InvoiceMasterDTO getInvoiceMaster(int invno) {
		InvoiceMasterDTO invoiceobj=new InvoiceMasterDTO();
		String query="select * from invoicemaster where invno=?";
		try {
			Connection con=DBUtility.getConnection(prop);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1,invno);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				invoiceobj.setCustomerno(rs.getInt("customerno"));
				invoiceobj.setInvdate(String.valueOf(rs.getDate("invdate")));
				invoiceobj.setInvno(rs.getInt("invno"));
			}
			 DBUtility.closeConnection(null);
				return invoiceobj;
			}catch(Exception e) {
				DBUtility.closeConnection(e);
				return null;
			}
	}
	@Override
	public Set<InvoiceMasterDTO> getInvoiceMasterAll() {
		Set<InvoiceMasterDTO> invoicedetails=new HashSet<InvoiceMasterDTO>();
		Statement stmt;
		try {
			Connection con=DBUtility.getConnection(prop);
			InvoiceMasterDTO invoiceobj;
			stmt = con.createStatement();
		String query="select * from invoicemaster";
		ResultSet rs=stmt.executeQuery(query);
		while(rs.next()) {
			invoiceobj=new InvoiceMasterDTO();
			invoiceobj.setCustomerno(rs.getInt("customerno"));
			invoiceobj.setInvdate(String.valueOf(rs.getDate("invdate")));
			invoiceobj.setInvno(rs.getInt("invno"));
			invoicedetails.add(invoiceobj);
		}
		 DBUtility.closeConnection(null);
			return invoicedetails;
		}catch(Exception e) {
			DBUtility.closeConnection(e);
			return null;
		}
	}
}