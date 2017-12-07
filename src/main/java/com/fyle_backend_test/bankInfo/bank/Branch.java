package com.fyle_backend_test.bankInfo.bank;

import java.util.List;

import com.fyle_backend_test.bankInfo.model.Bank;


public interface Branch {
	public List<Bank> getAllBankBranchDetails(String name, String city);
	public Bank getBankBranchDetails(String ifsc);
}
