package com.vaha1st.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.vaha1st.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	
	private String serviceCode;
	
	public void addAccount(Account account, boolean vipFlag) {
		System.out.println(getClass()+": DOING MY DB WORK: ADD AN ACCOUNT");
	}
	
	public boolean doWork() {
		System.out.println(getClass()+": DOING SOME WORK");
		return true;
	}
	
	public List<Account> findAccounts(boolean tripWire) {
		List<Account> myAccounts = new ArrayList<>();
		
		// for academic purposes ... simulate an exception
		if(tripWire) {
			throw new RuntimeException("No Soup For You!");
		}
		
		// create sample accounts
		Account acc1 = new Account("John", "Silver");
		Account acc2 = new Account("Watson", "Gold");
		Account acc3 = new Account("Bobr", "Platinum");
		
		// add this account to list
		myAccounts.add(acc1);
		myAccounts.add(acc2);
		myAccounts.add(acc3);
		
		return myAccounts;
	}

	public String getName() {
		System.out.println(getClass()+": in getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass()+": in setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass()+": in getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass()+": in setServiceCode()");
		this.serviceCode = serviceCode;
	}
	
	
}
