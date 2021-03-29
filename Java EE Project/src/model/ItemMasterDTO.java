package model;

import java.io.Serializable;

public class ItemMasterDTO implements Serializable{
	private int itemno;
	private String itemdescription;
	private int itemprice;
	private String itemunit;
	private String category;
	private String image;
	public final int getItemno() {
		return itemno;
	}
	public final void setItemno(int itemno) {
		this.itemno = itemno;
	}
	public final String getItemdescription() {
		return itemdescription;
	}
	public final void setItemdescription(String itemdescription) {
		this.itemdescription = itemdescription;
	}
	public final int getItemprice() {
		return itemprice;
	}
	public final void setItemprice(int itemprice) {
		this.itemprice = itemprice;
	}
	public final String getItemunit() {
		return itemunit;
	}
	public final void setItemunit(String itemunit) {
		this.itemunit = itemunit;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "ItemMasterDTO [itemno=" + itemno + ", itemdescription=" + itemdescription + ", itemprice=" + itemprice
				+ ", itemunit=" + itemunit + ", category=" + category + ", image=" + image + "]";
	}

	
}