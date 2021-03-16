package rmipack;
import java.rmi.Naming;
import java.util.Scanner;
public class InvoiceClient {
	public static void main(String[] args) throws Exception{
		Invoice inv=(Invoice)Naming.lookup("rmi://localhost:1099/myinvoiceapp");
		Scanner scan=new Scanner(System.in);
		System.out.println("Please select your choice...");
		System.out.println("1-Create new Invoice");
		System.out.println("2-Calculate Delivery date and time");
		
		int choice=scan.nextInt();
		switch(choice) {
		case 1:{
			inv.createInvoice();
			break;
		}
		case 2:{
//			inv.startInvoiceApp();
			break;
		}
		default:
			System.out.println("wrong choice...");
		}
		
	}
}