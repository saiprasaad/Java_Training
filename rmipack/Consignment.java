package rmipack;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

interface interval{
	public int getInvoiceday(String date);
	public String getInvoicedate(String date);
	public float morntime(float remtime);
	public float afternoontime(float remtime);
	public float eveningtime(float remtime);
	public String getDeliveryDate(int count);
}
public class Consignment implements interval{
	Date date;

	@Override
	public int getInvoiceday(String date) {
		int temp=0;
		try {
		Date d=new SimpleDateFormat("yyyy-MM-dd").parse(date);
		System.out.println(d);
		this.date=d;
		temp=d.getDay();
		}catch(Exception e) {}
		return temp;
	}
	@Override
	public String getInvoicedate(String date) {
		String temp="";
		Date d = null;
		try {
		d=new SimpleDateFormat("yyyy-MM-dd").parse(date); 
		this.date=d;
		}catch(Exception e) {}
		int mon=d.getMonth()+1;
		return String.valueOf(d.getDate()+"/"+String.valueOf(mon)+"/2021");
	}
	@Override
	public float morntime(float remtime) {
		// TODO Auto-generated method stub
			remtime=remtime-120;
		return remtime;
	}
	@Override
	public float afternoontime(float remtime) {
		// TODO Auto-generated method stub
			remtime=remtime-300;
		return remtime;
	}

	@Override
	public float eveningtime(float remtime) {
			remtime=remtime-300;
		// TODO Auto-generated method stub
		return remtime;
	}

	@Override
	public String getDeliveryDate(int count) {
		Date newdate=date;
		newdate.setDate(date.getDate()+count); 
		int mon=newdate.getMonth()+1;
		return String.valueOf(newdate.getDate()+"/"+String.valueOf(mon)+"/2021");
	}


}
