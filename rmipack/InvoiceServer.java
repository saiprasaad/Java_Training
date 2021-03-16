package rmipack;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import daytwentytwo.DBUtility;
import daytwentytwo.InvoiceMasterDAOImpl;
import daytwentytwo.InvoiceMasterDTO;
import daytwentytwo.ItemTransactionMasterDAOImpl;
import daytwentytwo.ItemTransactionMasterDTO;
public class InvoiceServer extends UnicastRemoteObject implements Invoice{
	


public InvoiceServer() throws RemoteException{
}
public void createInvoice() throws RemoteException{
	System.out.println("Creating Invoice");
	Scanner scan=new Scanner(System.in);
	int custno;
	int itemno;
	int itemqty;
	int invno;
	HashMap<Integer,Integer> itemmap=new HashMap<Integer,Integer>();
//	HashMap<Integer, HashMap<Integer, Integer>> invmap=new HashMap<Integer, HashMap<Integer, Integer>>();
	System.out.println("Enter Customer Number");
	custno=scan.nextInt();
	System.out.println("Enter itemno and item quantity");
	while(true)
	{
		System.out.print("itemno: ");
		itemno=scan.nextInt();
		if(itemno==-1)
			break;
		System.out.print("quantity: ");
		itemqty=scan.nextInt();
		itemmap.put(itemno,itemqty);
	}
	InvoiceMasterDAOImpl invoicemasterdaoimpl=new InvoiceMasterDAOImpl(DBUtility.getConnection());
	InvoiceMasterDTO invoicemasterdto=new InvoiceMasterDTO();
	invoicemasterdto.setCustomerno(custno);
	invoicemasterdto.setInvdate("2021-03-14");
//	invoicemasterdto.setInvno(103);
	invno= invoicemasterdaoimpl.insertInvoice(invoicemasterdto);
	for (Map.Entry<Integer,Integer> entry : itemmap.entrySet())  {
		ItemTransactionMasterDTO itemtransactionmasterdto=new ItemTransactionMasterDTO();
		itemtransactionmasterdto.setInvno(invno);
		itemtransactionmasterdto.setItemno(entry.getKey());
		itemtransactionmasterdto.setItemqty(entry.getValue());
		ItemTransactionMasterDAOImpl itemtransactionmasterdaoimpl=new ItemTransactionMasterDAOImpl(DBUtility.getConnection());
		itemtransactionmasterdaoimpl.insertItem(itemtransactionmasterdto);
	}
//public void calculateDate() {
//	System.out.println("delivery date is so and so....");
//}
}
}