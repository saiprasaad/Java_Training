package model;

import java.util.List;
import java.util.Set;

public class TotalDetails {
String invdate;
CustomerMasterDTO customemasterdto;
Set<ItemDetails> itemdetails;
public String getInvdate() {
	return invdate;
}
public void setInvdate(String invdate) {
	this.invdate = invdate;
}
public CustomerMasterDTO getCustomemasterdto() {
	return customemasterdto;
}
public void setCustomemasterdto(CustomerMasterDTO customemasterdto) {
	this.customemasterdto = customemasterdto;
}
public Set<ItemDetails> getItemdetails() {
	return itemdetails;
}
public void setItemdetails(Set<ItemDetails> itemdetails) {
	this.itemdetails = itemdetails;
}
@Override
public String toString() {
	return "TotalDetails [invdate=" + invdate + ", customemasterdto=" + customemasterdto + ", itemdetails="
			+ itemdetails + "]";
}

}
