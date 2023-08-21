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
@Table(name="Customer")
public class Customer
{
	@Id
	@GeneratedValue(generator = "customer-id")
	@GenericGenerator(name = "customer-id",strategy = "com.example.loanstore.db.Model.CustomeIdGenerator.CustomerCustomeIdGenerator")
	@Column(name="customer_id")
	private String customerId;

	@Column(name="customer_name")
	private String customerName;

	@Column(name="customer_email")
	private String customerEmail;

	@Column(name="customer_password")
	private String customerPassword;
}
