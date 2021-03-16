package rmipack;
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface Invoice extends Remote{
	public void createInvoice()throws RemoteException;
}