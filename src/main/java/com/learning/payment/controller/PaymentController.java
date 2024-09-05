package com.learning.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.payment.model.Payment;
import com.learning.payment.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@PostMapping
	public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {

		Payment updatedPayment = paymentService.processPayment(payment);
		return ResponseEntity.status(HttpStatus.CREATED).body(updatedPayment);

	}

	@GetMapping("/order/{orderId}")
	public ResponseEntity<Payment> fetchPaymentDetailsByOrderId(@PathVariable Long orderId) {

		Payment payment = paymentService.fetchPaymentDetailsByOrderId(orderId);
		return ResponseEntity.ok(payment);
	}

}
