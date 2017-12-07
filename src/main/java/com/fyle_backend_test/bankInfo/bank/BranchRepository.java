package com.fyle_backend_test.bankInfo.bank;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fyle_backend_test.bankInfo.model.Bank;

@Repository
public class BranchRepository implements Branch {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public String getInfo(int id) {
		return "Hello";
	}

	
	@Transactional(readOnly = true)
	@Override
	public List<Bank> getAllBankBranchDetails(String name, String city) {
		return (List<Bank>) jdbcTemplate.query("select * from bank where bank_name like ('%" + name
				+ "%')  AND city like ('%" + city + "%') order by address", new BankRowMapper());
	}
	@Transactional(readOnly = true)
	@Override
	public Bank getBankBranchDetails(String ifsc) {
		return jdbcTemplate.queryForObject("select * from bank where ifsc=?", new Object[] { ifsc },
				new BeanPropertyRowMapper<Bank>(Bank.class));
	}

}

class BankRowMapper implements RowMapper<Bank> {
	@Override
	public Bank mapRow(ResultSet rs, int rowNum) throws SQLException {
		Bank bank = new Bank();
		bank.setIfsc(rs.getString("ifsc"));
		bank.setBank_id(rs.getString("bank_id"));
		bank.setBranch(rs.getString("branch"));
		bank.setAddress(rs.getString("address"));
		bank.setCity(rs.getString("city"));
		bank.setDistrict(rs.getString("district"));
		bank.setState(rs.getString("state"));
		bank.setBank_name(rs.getString("bank_name"));
		return bank;
	}
}