package com.learnJava;

import java.util.ArrayList;

public class Bank {

	private String name;
	private ArrayList<Branch> branchList;

	// Constructor
	public Bank(String name) {
		this.name = name;
		this.branchList = new ArrayList<Branch>();
	}
	
	// Methods
	public boolean addBranch(String branchName) {
		if(findBranch(branchName) == null) {
			this.branchList.add(new Branch(branchName));
			return true;
		}
		return false;
	}
	
	public boolean addCustomerToBranch(String branchName, String customerName, double initialAmount) {
		Branch existingBranch = findBranch(branchName);
		if(existingBranch != null) {
			return existingBranch.newCustomer(customerName, initialAmount);
		}
		return false;
	}
	
	public boolean addCustomerTransaction(String branchName, String customerName, double amount) {
		Branch existingBranch = findBranch(branchName);
		if(existingBranch != null) {
			return existingBranch.addCustomerTransaction(customerName, amount);
		}
		return false;
	}
	
	public boolean listCustomer(String branchName, boolean showTransaction) {
		Branch existingBranch = findBranch(branchName);
		if(existingBranch != null) {
			System.out.println("/*--- Customer details for branch " + existingBranch.getName() + " ---*/");
			ArrayList<Customer> branchCustomers = existingBranch.getCustomerList();
			for(int i = 0; i < branchCustomers.size(); i++) {
				System.out.println("Customer: " + branchCustomers.get(i).getName() + "[" + (i+1) + "]");
				if(showTransaction) {
					System.out.println("/*--- Transactions ---*/");
					ArrayList<Double> transactions = branchCustomers.get(i).getTransactions();
					for(int j = 0; j < transactions.size(); j++) {
						System.out.println("[" + (j+1) + "] Amount " + transactions.get(j));
					}
				}
			}
			return true;
			
		} else {
			return false;
		}
	}
	
	private Branch findBranch(String branchName) {
		for(int i = 0; i < this.branchList.size(); i++) {
			if(this.branchList.get(i).getName().equals(branchName)) {
				return this.branchList.get(i);
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
	
	public ArrayList<Branch> getBranchList() {
		return branchList;
	}

	public void setBranchList(ArrayList<Branch> branchList) {
		this.branchList = branchList;
	}
	
}
