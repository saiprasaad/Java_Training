package rmipack;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.parser.Path;
import com.itextpdf.text.pdf.parser.clipper.Paths;

import daytwentytwo.CustomerMasterDAOImpl;
import daytwentytwo.CustomerMasterDTO;
import daytwentytwo.DBUtility;
import daytwentytwo.InvoiceMasterDAOImpl;
import daytwentytwo.InvoiceMasterDTO;
import daytwentytwo.ItemMasterDAOImpl;
import daytwentytwo.ItemMasterDTO;
import daytwentytwo.ItemTransactionMasterDAOImpl;
import daytwentytwo.ItemTransactionMasterDTO;
public class InvoiceServer extends UnicastRemoteObject implements Invoice{


public InvoiceServer() throws RemoteException{
}
public boolean createInvoice(int custno,int invno,HashMap<Integer,Integer> itemmap) throws RemoteException{
	System.out.println("Creating Invoice");
	
	InvoiceMasterDAOImpl invoicemasterdaoimpl=new InvoiceMasterDAOImpl(DBUtility.getConnection());
	InvoiceMasterDTO invoicemasterdto=new InvoiceMasterDTO();
	invoicemasterdto.setCustomerno(custno);
	invoicemasterdto.setInvdate(String.valueOf(java.time.LocalDate.now()));
	invno= invoicemasterdaoimpl.insertInvoice(invoicemasterdto);
	for (Map.Entry<Integer,Integer> entry : itemmap.entrySet())  {
		ItemTransactionMasterDTO itemtransactionmasterdto=new ItemTransactionMasterDTO();
		itemtransactionmasterdto.setInvno(invno);
		itemtransactionmasterdto.setItemno(entry.getKey());
		itemtransactionmasterdto.setItemqty(entry.getValue());
		ItemTransactionMasterDAOImpl itemtransactionmasterdaoimpl=new ItemTransactionMasterDAOImpl(DBUtility.getConnection());
		itemtransactionmasterdaoimpl.insertItem(itemtransactionmasterdto);
	}
	return true;
}
@Override
public boolean createPDF(int invoiceno) throws RemoteException {
	String date="";
	StringBuilder sb=new StringBuilder();
	int custno;
	InvoiceMasterDTO invoicedetails=new InvoiceMasterDTO();
	InvoiceMasterDAOImpl invoicemasterdaoimpl=new InvoiceMasterDAOImpl(DBUtility.getConnection());
	invoicedetails=invoicemasterdaoimpl.getInvoiceMaster(invoiceno);
	date=invoicedetails.getInvdate();
	custno=invoicedetails.getCustomerno();
	ItemTransactionMasterDAOImpl itemtransactionmasterdaoimpl=new ItemTransactionMasterDAOImpl(DBUtility.getConnection());
	Set<ItemTransactionMasterDTO> itemtransactiondetails=new HashSet<ItemTransactionMasterDTO>();
	itemtransactiondetails=itemtransactionmasterdaoimpl.getItemTransactionMasterAllByInvno(invoiceno);
	CustomerMasterDAOImpl customermasterdaoimpl=new CustomerMasterDAOImpl(DBUtility.getConnection());
	CustomerMasterDTO customerobj=new CustomerMasterDTO();
	customerobj=customermasterdaoimpl.getCustomerMaster(custno);
	sb.append("<!DOCTYPE invoice SYSTEM \"invoice.dtd\"><invoice><customer>");
	sb.append("<customerno>"+custno+"</customerno><customername>"+customerobj.getCustomername()+"</customername><customeraddress>"+
	customerobj.getCustomeraddress()+"</customeraddress><customeremail>"+customerobj.getCustomeremail()+"</customeremail><customerphone>"+
			customerobj.getCustomerphone()+"</customerphone><invoiceno>"+invoiceno+"</invoiceno></customer>");
	sb.append("<items>");
	for (ItemTransactionMasterDTO i : itemtransactiondetails) {
		sb.append("<item>"); 
       sb.append("<itemno>"+i.getItemno()+"</itemno>");       
       ItemMasterDAOImpl itemmasterdaoimpl=new ItemMasterDAOImpl(DBUtility.getConnection());
       ItemMasterDTO itemdetails=new ItemMasterDTO();
       itemdetails=itemmasterdaoimpl.getItemMaster(i.getItemno());
       sb.append("<itemdescription>"+itemdetails.getItemdescription()+"</itemdescription>"
       		+ "<itemprice>"+itemdetails.getItemprice()+"</itemprice><itemqty>"+i.getItemqty()+"</itemqty><itemunit>"+
    		   itemdetails.getItemunit()+"</itemunit><itemtotal>"+itemdetails.getItemprice()*i.getItemqty()+"</itemtotal>");
       sb.append("</item>");
	}
	sb.append("</items></invoice>");
    try {
	File output = new File("C:\\Java\\java_training\\eycorejava\\src\\rmipack\\"+invoiceno+".xml");
	FileWriter fwriter = new FileWriter(output);
	fwriter.write(sb.toString());
	fwriter.flush();
	fwriter.close();
	String[] arr=new String[100];
	com.itextpdf.text.Document document=new com.itextpdf.text.Document();
	PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:\\Java\\java_training\\eycorejava\\src\\rmipack\\"+invoiceno+".pdf"));
    document.open();
    Font boldheadFont = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
    Font boldheadFont1 = new Font(Font.FontFamily.TIMES_ROMAN, 20, Font.BOLD);
    Font boldheadFont2 = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    Paragraph parahead = new Paragraph("ABC Stores"+"\n",boldheadFont1);
    Paragraph parahead1 = new Paragraph("123 Madison drive, Seattle,WA,7829Q"+"\n"+"www.abcstores.com"+"\n"+"990-120-4560"+"\n\n",boldheadFont2);
	Paragraph datepara=new Paragraph("Invoice Date : "+date);
	datepara.setAlignment(Paragraph.ALIGN_RIGHT);
    DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
	DocumentBuilder db=dbf.newDocumentBuilder();
	Document doc=db.parse("C:\\Java\\java_training\\eycorejava\\src\\rmipack\\"+invoiceno+".xml");
    Element rootElement=doc.getDocumentElement();
    PdfPTable table = new PdfPTable(6);
    table.setWidthPercentage(100);
    table.setSpacingBefore(10f); 
    table.setSpacingAfter(10f); 
    float[] columnWidths = {1f,1f,1f,1f,1f,1f};
    table.setWidths(columnWidths);
    PdfPCell cells[]=new PdfPCell[6];
    Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
    cells[0] = new PdfPCell(new Paragraph("Item No",boldFont));
    cells[1] = new PdfPCell(new Paragraph("Desription",boldFont));
    cells[2] = new PdfPCell(new Paragraph("Price",boldFont));
    cells[3] = new PdfPCell(new Paragraph("Quantity",boldFont));
    cells[4] = new PdfPCell(new Paragraph("Unit",boldFont));
    cells[5] = new PdfPCell(new Paragraph("Total",boldFont));
    for(int i=0;i<6;i++)
	{
    	cells[i].setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
        table.addCell(cells[i]);
	}
	for(int i=0;i<rootElement.getChildNodes().getLength();i++) {
		if(i==0)
		{
		for(int j=0;j<rootElement.getChildNodes().item(i).getChildNodes().getLength();j++) {  
			arr[j]=rootElement.getChildNodes().item(i).getChildNodes().item(j).getFirstChild().getNodeValue();
		}
		}
		else
		{
			for(int j=0;j<rootElement.getChildNodes().item(i).getChildNodes().getLength();j++) {  
				for(int k=0;k<rootElement.getChildNodes().item(i).getChildNodes().item(j).getChildNodes().getLength();k++)
				{
					  cells[k] = new PdfPCell(new Paragraph(rootElement.getChildNodes().item(i).getChildNodes().item(j).getChildNodes().item(k).getFirstChild().getNodeValue()));
				      cells[k].setBorderColor(BaseColor.BLACK);
				      cells[k].setPaddingLeft(10);
				      cells[k].setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
				      cells[k].setVerticalAlignment(com.itextpdf.text.Element.ALIGN_MIDDLE);
				}
				for(int k=0;k<rootElement.getChildNodes().item(i).getChildNodes().item(j).getChildNodes().getLength();k++)
				{
			        table.addCell(cells[k]);
				}
				}
		}
	}
    Paragraph para1 = new Paragraph("BILL TO:\n"+"________________________"+"\n",boldheadFont);
    Paragraph para2 = new Paragraph(arr[1]+"\n"+arr[2]+"\n"+arr[3]+"\n"+arr[4]+"\n\n");
    document.add(parahead);
    document.add(parahead1);
    document.add(datepara);
    document.add(para1);
    document.add(para2);
    document.add(table);
    System.out.println("done");
    document.close();  
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return true;
	
}
@Override
public boolean createExcel(int invoiceno) throws RemoteException {
	String date="";
	StringBuilder sb=new StringBuilder();
	int custno;
	InvoiceMasterDTO invoicedetails=new InvoiceMasterDTO();
	InvoiceMasterDAOImpl invoicemasterdaoimpl=new InvoiceMasterDAOImpl(DBUtility.getConnection());
	invoicedetails=invoicemasterdaoimpl.getInvoiceMaster(invoiceno);
	date=invoicedetails.getInvdate();
	custno=invoicedetails.getCustomerno();
	ItemTransactionMasterDAOImpl itemtransactionmasterdaoimpl=new ItemTransactionMasterDAOImpl(DBUtility.getConnection());
	Set<ItemTransactionMasterDTO> itemtransactiondetails=new HashSet<ItemTransactionMasterDTO>();
	itemtransactiondetails=itemtransactionmasterdaoimpl.getItemTransactionMasterAllByInvno(invoiceno);
	CustomerMasterDAOImpl customermasterdaoimpl=new CustomerMasterDAOImpl(DBUtility.getConnection());
	CustomerMasterDTO customerobj=new CustomerMasterDTO();
	System.out.println(custno);
	customerobj=customermasterdaoimpl.getCustomerMaster(custno);
	sb.append("<!DOCTYPE invoice SYSTEM \"invoice.dtd\"><invoice><customer>");
	sb.append("<customerno>"+custno+"</customerno><customername>"+customerobj.getCustomername()+"</customername><customeraddress>"+
	customerobj.getCustomeraddress()+"</customeraddress><customeremail>"+customerobj.getCustomeremail()+"</customeremail><customerphone>"+
			customerobj.getCustomerphone()+"</customerphone><invoiceno>"+invoiceno+"</invoiceno></customer>");
	sb.append("<items>");
	for (ItemTransactionMasterDTO i : itemtransactiondetails) {
		sb.append("<item>"); 
       sb.append("<itemno>"+i.getItemno()+"</itemno>");       
       ItemMasterDAOImpl itemmasterdaoimpl=new ItemMasterDAOImpl(DBUtility.getConnection());
       ItemMasterDTO itemdetails=new ItemMasterDTO();
       itemdetails=itemmasterdaoimpl.getItemMaster(i.getItemno());
       sb.append("<itemdescription>"+itemdetails.getItemdescription()+"</itemdescription>"
       		+ "<itemprice>"+itemdetails.getItemprice()+"</itemprice><itemqty>"+i.getItemqty()+"</itemqty><itemunit>"+
    		   itemdetails.getItemunit()+"</itemunit><itemtotal>"+itemdetails.getItemprice()*i.getItemqty()+"</itemtotal>");
       sb.append("</item>");
	}
	sb.append("</items></invoice>");
    try {
	File output = new File("C:\\Java\\java_training\\eycorejava\\src\\rmipack\\"+invoiceno+".xml");
	FileWriter fwriter = new FileWriter(output);
	fwriter.write(sb.toString());
	fwriter.flush();
	fwriter.close();
	String[] arr=new String[100];
	HSSFWorkbook wb = new HSSFWorkbook();   
	OutputStream fileOut = new FileOutputStream("C:\\Java\\java_training\\eycorejava\\src\\rmipack\\"+invoiceno+".xls");   
	HSSFWorkbook workbook = new HSSFWorkbook();  
	HSSFSheet sheet = workbook.createSheet("Bill_Sheet");   
	HSSFCellStyle style = workbook.createCellStyle();
	HSSFFont font = workbook.createFont();
	font.setFontName(HSSFFont.FONT_ARIAL);
	font.setFontHeightInPoints((short)10);
	font.setBold(true);
	style.setFont(font);
	HSSFCellStyle style1 = workbook.createCellStyle();
	HSSFFont font1 = workbook.createFont();
	font1.setFontName(HSSFFont.FONT_ARIAL);
	font1.setFontHeightInPoints((short)14);
	font1.setBold(true);
	style1.setFont(font);
	sheet.addMergedRegion(new CellRangeAddress(0,0,2,4));
	HSSFRow rowhead = sheet.createRow((short)0);  
	rowhead.setRowStyle(style1);
	rowhead.createCell(2).setCellValue("ABC Stores");
	DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
	dbf.setIgnoringElementContentWhitespace(true);
	dbf.setValidating(true);
	sheet.addMergedRegion(new CellRangeAddress(1,1,1,2));
	sheet.addMergedRegion(new CellRangeAddress(1,1,3,4));
	sheet.addMergedRegion(new CellRangeAddress(2,2,1,2));
	sheet.addMergedRegion(new CellRangeAddress(2,2,3,4));
	sheet.addMergedRegion(new CellRangeAddress(3,3,1,2));
	sheet.addMergedRegion(new CellRangeAddress(3,3,3,4));
	sheet.addMergedRegion(new CellRangeAddress(4,4,1,2));
	sheet.addMergedRegion(new CellRangeAddress(4,4,3,4));
	sheet.addMergedRegion(new CellRangeAddress(5,5,1,2));
	sheet.addMergedRegion(new CellRangeAddress(5,5,3,4));
	sheet.addMergedRegion(new CellRangeAddress(6,6,1,2));
	sheet.addMergedRegion(new CellRangeAddress(6,6,3,4));
	DocumentBuilder db=dbf.newDocumentBuilder();
	Document doc=db.parse("C:\\Java\\java_training\\eycorejava\\src\\rmipack\\"+invoiceno+".xml");
	Element rootElement=doc.getDocumentElement();
	HSSFRow row1 = sheet.createRow((short)(1));
	row1.createCell(1).setCellValue("Customer No");
	row1.createCell(3).setCellValue(rootElement.getChildNodes().item(0).getChildNodes().item(0).getFirstChild().getNodeValue());  
	HSSFRow row2 = sheet.createRow((short)(2));
	row2.createCell(3).setCellValue(rootElement.getChildNodes().item(0).getChildNodes().item(1).getFirstChild().getNodeValue());
	row2.createCell(1).setCellValue("Customer Name");
	HSSFRow row3 = sheet.createRow((short)(3));
	row3.createCell(3).setCellValue(rootElement.getChildNodes().item(0).getChildNodes().item(2).getFirstChild().getNodeValue());
	row3.createCell(1).setCellValue("Customer Address");
	HSSFRow row4 = sheet.createRow((short)(4));
	row4.createCell(3).setCellValue(rootElement.getChildNodes().item(0).getChildNodes().item(3).getFirstChild().getNodeValue()); 
	row4.createCell(1).setCellValue("Customer Email");
	HSSFRow row5 = sheet.createRow((short)(5));
	row5.createCell(3).setCellValue(rootElement.getChildNodes().item(0).getChildNodes().item(4).getFirstChild().getNodeValue()); 
	row5.createCell(1).setCellValue("Customer Phone");
	HSSFRow row6 = sheet.createRow((short)(6));
	row6.createCell(3).setCellValue(rootElement.getChildNodes().item(0).getChildNodes().item(5).getFirstChild().getNodeValue()); 
	row6.createCell(1).setCellValue("Invoice No");
	HSSFRow row0 = sheet.createRow((short)7);  
	row0.createCell(0).setCellValue("Item No");  
	row0.createCell(1).setCellValue("Description");  
	row0.createCell(2).setCellValue("Price");  
	row0.createCell(3).setCellValue("Quantity");  
	row0.createCell(4).setCellValue("Unit");
	row0.createCell(5).setCellValue("Total");
	for(int j = 0; j<=5; j++)
	row0.getCell(j).setCellStyle(style);
	for(int i=1;i<rootElement.getChildNodes().getLength();i++) {
		for(int j=0;j<rootElement.getChildNodes().item(i).getChildNodes().getLength();j++) {  
			HSSFRow row = sheet.createRow((short)(j+8));
			for(int k=0;k<rootElement.getChildNodes().item(i).getChildNodes().item(j).getChildNodes().getLength();k++)
			{
				row.createCell(k).setCellValue(rootElement.getChildNodes().item(i).getChildNodes().item(j).getChildNodes().item(k).getFirstChild().getNodeValue());  
			}
		}
	}
	System.out.println("Excel Created Successfully");
	workbook.write(fileOut);
	wb.write(fileOut);   
	wb.close();
	fileOut.close();  
	
    }catch(Exception e) {e.printStackTrace();}
    return true;
}
@Override
public boolean enterItem(String itemdescription, String itemunit, int price) throws RemoteException {
	ItemMasterDTO itemmasterdto=new ItemMasterDTO();
	itemmasterdto.setItemdescription(itemdescription);
	itemmasterdto.setItemprice(price);
	itemmasterdto.setItemunit(itemunit);
	ItemMasterDAOImpl itemmasterdaoimpl=new ItemMasterDAOImpl(DBUtility.getConnection());
	itemmasterdaoimpl.insertItemDetails(itemmasterdto);
	return true;
}
@Override
public String calculateDelivery(int invno) throws RemoteException {
	try {
	String ans="";
	HashMap<Integer,String> datemap=new HashMap<Integer,String>();
	datemap.put(0, "sunday");datemap.put(1, "monday");datemap.put(2, "tuesday");datemap.put(3, "wednesday");datemap.put(4, "thursday");datemap.put(5, "friday");datemap.put(6, "saturday");
	InvoiceMasterDAOImpl invoicemasterdaoimpl=new InvoiceMasterDAOImpl(DBUtility.getConnection());
	String date="";String invdate="";String deldate="";String location="";int speed=30;float totaltime=0;float totaltimef=0;
	int custno;int invdateno=0;int distance=0,count=0;float remtime=0;float afttime=0;float morntime=0;float evetime=0;
	date=invoicemasterdaoimpl.getInvoiceMaster(invno).getInvdate();
	custno=invoicemasterdaoimpl.getInvoiceMaster(invno).getCustomerno();
	Consignment c=new Consignment();
	invdateno=c.getInvoiceday(date);
	invdate=datemap.get(invdateno);
	ans+="Date of order: "+c.getInvoicedate(date)+"\n";
	Properties prop=new Properties();
	prop.load(new FileInputStream("C:\\Java\\java_training\\eycorejava\\src\\rmipack\\location.properties"));
	CustomerMasterDAOImpl customermasterdaoimpl=new CustomerMasterDAOImpl(DBUtility.getConnection());
	location=customermasterdaoimpl.getCustomerMaster(custno).getCustomeraddress();
	distance=Integer.parseInt((String) prop.getProperty(location));
	ans+="Delivery Location: "+location+"\n";
	totaltimef=((float)distance/speed);
	totaltime=totaltimef*60;
	while(totaltime>720)
	{
		totaltime=totaltime-720;
		count++;
	}
	count++;
	int count1=0,ctemp=count;
	int i=invdateno;
	while(ctemp>0){
		if(datemap.get(i%7)=="saturday"||datemap.get(i%7)=="sunday") {
			count1++;
		}
		i++;
		ctemp--;
	}
	count+=count1;
	
	ans+="Delivery Date: "+c.getDeliveryDate(count)+"\n";
	ans+="Delivery day: "+datemap.get((invdateno+count)%7).toUpperCase()+"\n";
	morntime=c.morntime(totaltime);
	DateTimeFormatter df = DateTimeFormatter.ofPattern("HH:mm");
	if(morntime<0) {
		LocalTime lt = LocalTime.parse("06:00");
	    ans+="Time of Delivery: "+df.format(lt.plusMinutes((int)totaltime));
	    return ans;
	}
	// 08:00 - 09:00 Breakfast
	afttime=c.afternoontime(morntime);
	if(afttime<0) {
		LocalTime lt = LocalTime.parse("09:00");
	    ans+="Time of Delivery: "+df.format(lt.plusMinutes((int)(morntime)));
	    return ans;
	}
	// 14:00 - 15:00 Lunch
	evetime=c.eveningtime(afttime);
	LocalTime lt = LocalTime.parse("15:00");
    ans+="Time of Delivery: "+df.format(lt.plusMinutes((int)(afttime)));
    return ans;
	}catch(Exception e){e.printStackTrace();}
	return "";
}
}