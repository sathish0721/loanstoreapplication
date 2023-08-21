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

import com.example.loanstore.db.Convertor.PaymentModeConvertor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="Payment")
public class Payment
{

	@Id
	@GeneratedValue(generator = "payment-id")
	@GenericGenerator(name = "payment-id",strategy = "com.example.loanstore.db.Model.CustomeIdGenerator.PaymentCustomIdGenerator")
	@Column(name = "payment_id")
	private String paymentId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "loan_id")
	private Loan loan;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@Convert(converter = PaymentModeConvertor.class)
	@Column(name = "payment_mode")
	private PaymentMode paymentMode;

	@Column(name = "payment_amount")
	private Long paymentAmount;
}
