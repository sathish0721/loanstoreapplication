package com.example.loanstore.db.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.loanstore.db.Model.Payment;

public interface PaymentRepository extends JpaRepository<Payment,String>
{
}
