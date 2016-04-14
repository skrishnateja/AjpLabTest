package xyz.skrishnateja.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Bills")
public class Bill implements Serializable{
	
	private static final long serialVersionUID = -8767337896773261247L;

	private int sno;
	private int invoice;
	private String item;
	private int qty;
	private int price;
	
	
	@Id
	@GeneratedValue
	@Column(name="sno")
	public int getSno() {
		return sno;
	}
	@Column(name="invoice")
	public int getInvoice() {
		return invoice;
	}
	@Column(name="item")
	public String getItem() {
		return item;
	}
	@Column(name="qty")
	public int getQty() {
		return qty;
	}
	@Column(name="price")
	public int getPrice() {
		return price;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public void setInvoice(int invoice) {
		this.invoice = invoice;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String toString(){
		return this.sno+this.invoice+this.item+this.qty+this.price;
	}
}
