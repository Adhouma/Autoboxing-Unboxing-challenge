package com.learnJava;

import java.util.ArrayList;

public class Branch {

	private String name;
	private ArrayList<Customer> customerList;

	// Constructor
	public Branch(String name) {
		this.name = name;
		this.customerList = new ArrayList<Customer>();
	}
	
	// Methods
	public boolean newCustomer(String customerName, double initialAmount) {
		if(findCustomer(customerName) == null) {
			this.customerList.add(new Customer(customerName, initialAmount));
			return true;
		}
		return false;
	}
	
	public boolean addCustomerTransaction(String customerName, double amount) {
		Customer existingCustomer = findCustomer(customerName);
		if(existingCustomer != null) {
			existingCustomer.addTransaction(amount);
			return true;
		}
		return false;
	}
	
	public Customer findCustomer(String customerName) {
		for(int i = 0; i < this.customerList.size(); i++) {
			if(this.customerList.get(i).getName().equals(customerName)) {
				return this.customerList.get(i);
			}
		}
		return null;
	}

	// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(ArrayList<Customer> customerList) {
		this.customerList = customerList;
	}
	
}
