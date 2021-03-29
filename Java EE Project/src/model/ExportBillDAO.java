package model;

public interface ExportBillDAO {
	public void createXML(int invno,TotalDetails totaldetails);
	public void createPDF(int invno,String invdate);
	public void createExcel(int invno,String invdate);
	public void sendMail(String name,String email,int invno);
	public void sendSMS(String phone,TotalDetails totaldetails);
}
