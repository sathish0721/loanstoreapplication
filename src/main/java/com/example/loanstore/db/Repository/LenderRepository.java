package com.example.loanstore.db.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.loanstore.db.Model.Customer;
import com.example.loanstore.db.Model.Lender;

@Repository
public interface LenderRepository extends JpaRepository<Lender,Integer>
{
//	Boolean existsByEmail(String lenderEmail);

	@Query(value = "Select * from lender where lenderEmail=? and lenderPassword=?" ,nativeQuery = true)
	Lender loginLender(String lenderEmail,String lenderPassword);
}
