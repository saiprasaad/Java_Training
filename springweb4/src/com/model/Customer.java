package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerno;
	
	public final int getCustomerno() {
		return customerno;
	}
	public final void setCustomerno(int customerno) {
		this.customerno = customerno;
	}
	public final String getCustomername() {
		return customername;
	}
	public final void setCustomername(String customername) {
		this.customername = customername;
	}
	public final String getCustomeremail() {
		return customeremail;
	}
	public final void setCustomeremail(String customeremail) {
		this.customeremail = customeremail;
	}
	public final String getCustomerphone() {
		return customerphone;
	}
	public final void setCustomerphone(String customerphone) {
		this.customerphone = customerphone;
	}
	public final String getCustomeraddress() {
		return customeraddress;
	}
	public final void setCustomeraddress(String customeraddress) {
		this.customeraddress = customeraddress;
	}
	@Override
	public String toString() {
		return "CustomerMasterDTO [customerno=" + customerno + ", customername=" + customername + ", customeraddress="
				+ customeraddress + ", customeremail=" + customeremail + ", customerphone=" + customerphone + "]";
	}
	private String customername;
	private String customeraddress;
	private String customeremail;
	private String customerphone;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerno", referencedColumnName = "uid")
    private Users user;

	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	
	
}
