package com.dao;

import java.util.List;
import java.util.Set;

import com.model.Invoice;
public interface InvoiceMasterDAO {
	public int insertInvoice(Invoice invMasterDTO);
	public int deleteInvoice(int invno);
	public int updateInvoice(Invoice invMasterDTO);
	public Invoice getInvoiceMaster(int invo);
	public List<Invoice> getInvoiceMasterAll();
	public String getDate(int invno);
	public void test();
}

