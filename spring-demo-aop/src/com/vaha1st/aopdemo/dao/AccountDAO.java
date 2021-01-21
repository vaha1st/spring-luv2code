package com.vaha1st.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.vaha1st.aopdemo.Account;

@Component
public class AccountDAO {
	
	public void addAccount(Account account, boolean vipFlag) {
		System.out.println(getClass()+": DOING MY DB WORK: ADD AN ACCOUNT");
	}
	
	public boolean doWork() {
		System.out.println(getClass()+": DOING SOME WORK");
		return true;
	}
	
}
