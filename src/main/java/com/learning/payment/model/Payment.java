package com.learning.payment.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "payment")
@Getter
@Setter
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "customer_id")
	private Long customerId;

	@Column(name = "order_id")
	private Long orderId;

	@Column(name = "payment_amount")
	private Double paymentAmount;

	@Column(name = "currency")
	private String currency;

	@Column(name = "payment_status")
	private String paymentStatus;

	@Column(name = "payment_time")
	private LocalDateTime paymentTime;
}
