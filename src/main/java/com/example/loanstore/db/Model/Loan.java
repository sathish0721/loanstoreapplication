package com.example.loanstore.db.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import org.hibernate.annotations.GenericGenerator;

import com.example.loanstore.db.Convertor.LoanStatusConvertor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="Loan")
public class Loan
{
	@Id
	@GeneratedValue(generator = "loan-id")
	@GenericGenerator(name = "loan-id",strategy = "com.example.loanstore.db.Model.CustomeIdGenerator.LoanCustomIdGenerator")
	@Column(name="loan_id")
	private String loanId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="customer_id")
	public Customer customer;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="lender_id")
	public Lender lender;

	@Column(name="loan_amount")
	private Long loanAmount;

	@Column(name="remaining_amount")
	private Long remainingAmount;

	@Column(name="due_date")
	private Long dueDateForLoan;

	@Column(name="interest_amount")
	private int interestAmount;

	@Column(name="status")
	@Convert(converter = LoanStatusConvertor.class)
	private Status status;

	//	jacoco
}
