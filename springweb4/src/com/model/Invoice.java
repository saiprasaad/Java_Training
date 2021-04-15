package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Invoice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int invno;
	
	public final int getInvno() {
		return invno;
	}
	public final void setInvno(int invno) {
		this.invno = invno;
	}
	public final String getInvdate() {
		return invdate;
	}
	public final void setInvdate(String string) {
		this.invdate = string;
	}
	public final int getCustomerno() {
		return customerno;
	}
	public final void setCustomerno(int customerno) {
		this.customerno = customerno;
	}
	private String invdate;
	private int customerno;
	
	@Override
	public String toString() {
		return "InvoiceMasterDTO [invno=" + invno + ", invdate=" + invdate + ", customerno=" + customerno + "]";
	}
}
