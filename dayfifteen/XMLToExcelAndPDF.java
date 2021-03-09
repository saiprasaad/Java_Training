package dayfifteen;
import java.io.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import  org.apache.poi.hssf.usermodel.HSSFSheet;  
import  org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import  org.apache.poi.hssf.usermodel.HSSFRow;  
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
public class XMLToExcelAndPDF   
{   
public static void main(String[] args)
{   	
	try {
	
		HSSFWorkbook wb = new HSSFWorkbook();   
		OutputStream fileOut = new FileOutputStream("C:\\Java\\java_training\\eycorejava\\src\\DayFifteen\\Bill.xls");   
		HSSFWorkbook workbook = new HSSFWorkbook();  
		HSSFSheet sheet = workbook.createSheet("Bill_Sheet");   
		
		HSSFCellStyle style = workbook.createCellStyle();
		HSSFFont font = workbook.createFont();
		font.setFontName(HSSFFont.FONT_ARIAL);
		font.setFontHeightInPoints((short)10);
		font.setBold(true);
		style.setFont(font);
		
		sheet.addMergedRegion(new CellRangeAddress(0,0,0,2));
		sheet.addMergedRegion(new CellRangeAddress(0,0,3,4));
		sheet.addMergedRegion(new CellRangeAddress(0,0,5,6));
		
		HSSFRow rowhead = sheet.createRow((short)0);  
		rowhead.createCell(0).setCellValue("Customer Name : Saiprasaad");  
		rowhead.createCell(3).setCellValue("Bill No : 31243");  
		rowhead.createCell(5).setCellValue("Bill Date : 08/03/2021");
		
		HSSFRow row0 = sheet.createRow((short)1);  
		row0.createCell(0).setCellValue("S.No.");  
		row0.createCell(1).setCellValue("Item Name");  
		row0.createCell(2).setCellValue("Price");  
		row0.createCell(3).setCellValue("Quantity");  
		row0.createCell(4).setCellValue("Amount");
		
		for(int j = 0; j<=4; j++)
		row0.getCell(j).setCellStyle(style);

	
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		dbf.setIgnoringElementContentWhitespace(true);
		dbf.setValidating(true);
		
		
		DocumentBuilder db=dbf.newDocumentBuilder();
		Document doc=db.parse("C:\\Java\\java_training\\eycorejava\\src\\dayfifteen\\items.xml");
		
		Element rootElement=doc.getDocumentElement();
		
		//pdf
		com.itextpdf.text.Document document=new com.itextpdf.text.Document();
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:\\Java\\java_training\\eycorejava\\src\\dayfifteen\\Bill.pdf"));
        document.open();
        
        Font boldheadFont = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
        
        Paragraph para1 = new Paragraph("Customer Name: Saiprasaad    Bill No : 31243    Bill Date : 08/03/2021",boldheadFont);
        para1.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(para1);
        
        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100);
        table.setSpacingBefore(10f); 
        table.setSpacingAfter(10f); 
 
        float[] columnWidths = {1f,1f,1f,1f,1f};
        table.setWidths(columnWidths);
        PdfPCell cells[]=new PdfPCell[5];
        Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
        
        cells[0] = new PdfPCell(new Paragraph("S.NO",boldFont));
        cells[1] = new PdfPCell(new Paragraph("Item Name",boldFont));
        cells[2] = new PdfPCell(new Paragraph("Price",boldFont));
        cells[3] = new PdfPCell(new Paragraph("Quantity",boldFont));
        cells[4] = new PdfPCell(new Paragraph("Amount",boldFont));
        for(int i=0;i<5;i++)
		{
        	cells[i].setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
	        table.addCell(cells[i]);
		}
        for(int i=0;i<5;i++)
        {
        	  cells[i].setBorderColor(BaseColor.BLACK);
	          cells[i].setPaddingLeft(10);
	          cells[i].setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
	          cells[i].setVerticalAlignment(com.itextpdf.text.Element.ALIGN_MIDDLE);
        }

		for(int i=0;i<rootElement.getChildNodes().getLength();i++) {
			HSSFRow row = sheet.createRow((short)(i+2));
			for(int j=0;j<rootElement.getChildNodes().item(i).getChildNodes().getLength();j++) {
				row.createCell(j).setCellValue(rootElement.getChildNodes().item(i).getChildNodes().item(j).getFirstChild().getNodeValue());  
				  cells[j] = new PdfPCell(new Paragraph(rootElement.getChildNodes().item(i).getChildNodes().item(j).getFirstChild().getNodeValue()));
			      cells[j].setBorderColor(BaseColor.BLACK);
			      cells[j].setPaddingLeft(10);
			      cells[j].setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
			      cells[j].setVerticalAlignment(com.itextpdf.text.Element.ALIGN_MIDDLE);
			}
			for(int j=0;j<rootElement.getChildNodes().item(i).getChildNodes().getLength();j++)
			{
//				System.out.println(cells[j]);
		        table.addCell(cells[j]);
			}
		}
		
		
		workbook.write(fileOut);
		wb.write(fileOut);   
		wb.close();
		fileOut.close();  
		
        document.add(table);
        document.close();
		


		
	}

	catch(Exception e) {e.printStackTrace();}
}   

}  