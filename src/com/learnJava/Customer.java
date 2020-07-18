package com.learnJava;

import java.util.ArrayList;

public class Customer {
	
	private String name;
	private ArrayList<Double> transactions;

	// Constructor
	public Customer(String name, double initialAmount) {
		this.name = name;
		this.transactions = new ArrayList<Double>();
		addTransaction(initialAmount);
	}
	
	// Methods
	public void addTransaction(double amount) {
		this.transactions.add(amount);
	}

	// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<Double> getTransactions() {
		return transactions;
	}

	public void setTransactions(ArrayList<Double> transactions) {
		this.transactions = transactions;
	}
	
}
