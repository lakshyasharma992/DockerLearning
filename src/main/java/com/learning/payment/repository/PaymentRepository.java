package com.learning.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.payment.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

	Payment findByOrderId(Long orderId);
}
