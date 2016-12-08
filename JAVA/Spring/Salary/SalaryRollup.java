package com.naver.sdu0920.entities;

import org.springframework.stereotype.Component;

@Component
public class SalaryRollup {
	private String yyyymm;
	private String no;
	private String dept;
	private String name;
	private String partner;
	private String dependent20;
	private String dependent60;
	private String amount;
	private String insurance;
	private String decisiontax;
	private String receipt;
	public String getReceipt() {
		return receipt;
	}
	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}
	public String getYyyymm() {
		return yyyymm;
	}
	public void setYyyymm(String yyyymm) {
		this.yyyymm = yyyymm;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPartner() {
		return partner;
	}
	public void setPartner(String partner) {
		this.partner = partner;
	}
	public String getDependent20() {
		return dependent20;
	}
	public void setDependent20(String dependent20) {
		this.dependent20 = dependent20;
	}
	public String getDependent60() {
		return dependent60;
	}
	public void setDependent60(String dependent60) {
		this.dependent60 = dependent60;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getInsurance() {
		return insurance;
	}
	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}
	public String getDecisiontax() {
		return decisiontax;
	}
	public void setDecisiontax(String decisiontax) {
		this.decisiontax = decisiontax;
	}
	
	
	
}
