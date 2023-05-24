package com.sbi.bank;

public class Bank {
	public String bankName;
	public String branchName;
	public int branchCode;

	public Bank(String bankName, String branchName, int branchCode) {

		this.bankName = bankName;
		this.branchName = branchName;
		this.branchCode = branchCode;
	}

	public String getBankName() {
		return bankName;
	}

	public String getBranchName() {
		return branchName;
	}

	public int getBranchCode() {
		return branchCode;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public void setBranchCode(int branchCode) {
		this.branchCode = branchCode;
	}

	@Override
	public String toString() {
		return "Bank [bankName=" + bankName + ", branchName=" + branchName + ", branchCode=" + branchCode + "]";
	}

}
