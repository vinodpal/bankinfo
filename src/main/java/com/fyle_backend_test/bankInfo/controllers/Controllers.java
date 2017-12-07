package com.fyle_backend_test.bankInfo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fyle_backend_test.bankInfo.bank.BranchRepository;
import com.fyle_backend_test.bankInfo.model.Bank;

@RestController
public class Controllers {

	private BranchRepository BranchRepository;
	public Controllers(BranchRepository BranchRepository) {
		this.BranchRepository = BranchRepository;
	}
	@RequestMapping("/infobranch")
	public Bank getInfoById(@RequestParam (value="ifsc", defaultValue="ABHY0065001")String ifsc) {
		return BranchRepository.getBankBranchDetails("ABHY0065001");
	}
	@RequestMapping("/infoallbranch")
	public List<Bank> getInfoByCityAndBank(@RequestParam (value="bank_name", defaultValue="ABHYUDAYA COOPERATIVE BANK LIMITED")String bank_name,@RequestParam (value="city", defaultValue="MUMBAI")String city) {
		return BranchRepository.getAllBankBranchDetails("ABHYUDAYA COOPERATIVE BANK LIMITED", "MUMBAI");
		
	}
}
