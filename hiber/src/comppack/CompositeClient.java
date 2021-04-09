package comppack;

import org.hibernate.Session;

import utility.HibernateUtility;

public class CompositeClient {
	public static void main(String[] args) {
	Session session=HibernateUtility.getSession();
	CompKey compkey=new CompKey();
	Invoice invoice=new Invoice();
	compkey.setInv_id(101);
	compkey.setItem_id(1001);
	invoice.setCompkey(compkey);
	invoice.setQuantity(2);
	
	session.save(invoice);
	HibernateUtility.closeSession(null);
	}
}
