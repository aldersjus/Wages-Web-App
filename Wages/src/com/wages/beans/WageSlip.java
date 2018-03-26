package com.wages.beans;

/**
 * Bean to represent a month's wage slip.
 * @author Justin Alderson
 *
 */
public class WageSlip {
	
	private String name = "";
	private String month = "";
	private int health;
	private int tax;
	private int overtime;
	private int hoursWorked;
	private int overtimeWorked;
	private int shift;
	private int regularity;
	private int basePay;
	private int totalPay;
	private int actualPay;
	
	public WageSlip() {
		
	}
	
	public WageSlip(String name, String month, int health, int tax, int overtime, int hoursWorked, int overtimeWorked,
			int shift, int regularity, int basePay, int totalPay, int actualPay) {
		super();
		this.name = name;
		this.month = month;
		this.health = health;
		this.tax = tax;
		this.overtime = overtime;
		this.hoursWorked = hoursWorked;
		this.overtimeWorked = overtimeWorked;
		this.shift = shift;
		this.regularity = regularity;
		this.basePay = basePay;
		this.totalPay = totalPay;
		this.actualPay = actualPay;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getTax() {
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

	public int getOvertime() {
		return overtime;
	}

	public void setOvertime(int overtime) {
		this.overtime = overtime;
	}

	public int getHoursWorked() {
		return hoursWorked;
	}

	public void setHoursWorked(int hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	public int getOvertimeWorked() {
		return overtimeWorked;
	}

	public void setOvertimeWorked(int overtimeWorked) {
		this.overtimeWorked = overtimeWorked;
	}

	public int getShift() {
		return shift;
	}

	public void setShift(int shift) {
		this.shift = shift;
	}

	public int getRegularity() {
		return regularity;
	}

	public void setRegularity(int regularity) {
		this.regularity = regularity;
	}

	public int getBasePay() {
		return basePay;
	}

	public void setBasePay(int basePay) {
		this.basePay = basePay;
	}

	public int getTotalPay() {
		return totalPay;
	}

	public void setTotalPay(int totalPay) {
		this.totalPay = totalPay;
	}

	public int getActualPay() {
		return actualPay;
	}

	public void setActualPay(int actualPay) {
		this.actualPay = actualPay;
	}
	

}
