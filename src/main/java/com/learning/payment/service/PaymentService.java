package com.learning.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learning.payment.model.Payment;
import com.learning.payment.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	@Transactional
	public Payment processPayment(Payment payment) {
		return paymentRepository.save(payment);
	}

	public Payment fetchPaymentDetailsByOrderId(Long orderId) {

		return paymentRepository.findByOrderId(orderId);

	}
}