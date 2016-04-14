package xyz.skrishnateja.view;

import java.util.List;

import xyz.skrishnateja.controller.BillManager;
import xyz.skrishnateja.model.Bill;

import com.opensymphony.xwork2.ActionSupport;


public class BillAction extends ActionSupport {

	private static final long serialVersionUID = 9149826260758390091L;
	public Bill bill;
	private int sno;

	private BillManager linkController;

	private List<Bill> billList;
	private List<Bill> ebill;
	
	public void setEbill(List<Bill> ebill) {
		this.ebill = ebill;
	}
	public void setBill(Bill bill) {
		this.bill = bill;
	}
	

	public BillAction() {
		linkController = new BillManager();
	}

	public String execute() {
		System.out.println("BillExecute");
		this.billList = linkController.list();
		return SUCCESS;
	}

	public String edit() {
		System.out.println("BillEdit");
		this.ebill = linkController.edit(getSno());
		return SUCCESS;
	}

	public String add() {
		System.out.println("BillAdd");
		System.out.println(getBill().toString());
		try {
			linkController.add(getBill());
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.billList = linkController.list();
		return SUCCESS;
	}

	public String delete() {
		System.out.println("BillDelete");
		linkController.delete(getSno());
		return SUCCESS;
	}

	public Bill getBill() {
		return bill;
	}

	public List<Bill> getBillList() {
		return billList;
	}


	public List<Bill> getEbill() {
		return ebill;
	}


	public void setBillList(List<Bill> billsList) {
		this.billList = billsList;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}
}
