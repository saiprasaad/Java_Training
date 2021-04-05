package basicpack;

import javax.xml.bind.annotation.XmlRootElement;

public class Employee {
	
	private int eid;
	private String ename;
	private int esal;	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Employee(int eid, String ename, int esal) {
		this.eid = eid;
		this.ename = ename;
		this.esal = esal;
	}
	public final int getEid() {
		return eid;
	}
	public final void setEid(int eid) {
		this.eid = eid;
	}
	public final String getEname() {
		return ename;
	}
	public final void setEname(String ename) {
		this.ename = ename;
	}
	public final int getEsal() {
		return esal;
	}
	public final void setEsal(int esal) {
		this.esal = esal;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", esal=" + esal + "]";
	}
	
}
