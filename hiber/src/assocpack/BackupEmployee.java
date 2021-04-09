package assocpack;

import java.util.Set;

public class BackupEmployee {
	private int eid;
	private String empname;
	private int empsal;
	private Set<Address> addresses;
	public final int getEid() {
		return eid;
	}
	public final void setEid(int eid) {
		this.eid = eid;
	}
	public final String getEmpname() {
		return empname;
	}
	public final void setEmpname(String empname) {
		this.empname = empname;
	}
	public final int getEmpsal() {
		return empsal;
	}
	public final void setEmpsal(int empsal) {
		this.empsal = empsal;
	}
	public final Set<Address> getAddresses() {
		return addresses;
	}
	public final void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}
	public BackupEmployee() {
		// TODO Auto-generated constructor stub
	}
}
