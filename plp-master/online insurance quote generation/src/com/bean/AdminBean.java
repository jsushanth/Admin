package com.bean;

public class AdminBean {
	private String insuredName;
	private long policyNumber;
	private long accountNumber;
	private double policyPremium;
	public String getInsuredName() {
		return insuredName;
	}
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}
	public long getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(long policyNumber) {
		this.policyNumber = policyNumber;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getPolicyPremium() {
		return policyPremium;
	}
	public void setPolicyPremium(double policyPremium) {
		this.policyPremium = policyPremium;
	}
	@Override
	public String toString() {
		return "AdimBean [insuredName=" + insuredName + ", policyNumber=" + policyNumber + ", accountNumber="
				+ accountNumber + ", policyPremium=" + policyPremium + "]";
	}
	
	
	
	

}
