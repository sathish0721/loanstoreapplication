package com.example.loanstore.db.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import org.hibernate.annotations.GenericGenerator;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="Lender")
public class Lender
{
	@Id
	@GeneratedValue(generator = "lender-id")
	@GenericGenerator(name = "lender-id",strategy = "com.example.loanstore.db.Model.CustomeIdGenerator.LenderCustomerIdGenerator")
	@Column(name="lender_id")
	private String lenderId;

	@Column(name="lender_name")
	private String lenderName;

	@Column(name="lender_email")
	private String lenderEmail;

	@Column(name="lender_password")
	private String lenderPassword;
}
