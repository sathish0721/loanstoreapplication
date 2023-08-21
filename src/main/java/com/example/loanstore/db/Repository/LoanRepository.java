package com.example.loanstore.db.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.loanstore.db.Model.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan,String>
{
//	@Query(value = "Select * from loan where lender_id = ?",nativeQuery = true)
//	List<Loan> getAllLoanForLender(String lenderId);

//	@Query(value = "Select * from loan where loan_id = ?",nativeQuery = true)
//	Loan getLoanDetail(String loanId);
}
