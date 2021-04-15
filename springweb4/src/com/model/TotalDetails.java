package com.model;

import java.util.List;
import java.util.Set;

public class TotalDetails {
String invdate;
Customer customermasterdto;
List<ItemDetails> itemdetails;
public String getInvdate() {
	return invdate;
}
public void setInvdate(String invdate) {
	this.invdate = invdate;
}
public Customer getCustomermasterdto() {
	return customermasterdto;
}
public void setCustomemasterdto(Customer customemasterdto) {
	this.customermasterdto = customemasterdto;
}
public List<ItemDetails> getItemdetails() {
	return itemdetails;
}
public void setItemdetails(List<ItemDetails> itemdetails) {
	this.itemdetails = itemdetails;
}
@Override
public String toString() {
	return "TotalDetails [invdate=" + invdate + ", customemasterdto=" + customermasterdto + ", itemdetails="
			+ itemdetails + "]";
}

}
