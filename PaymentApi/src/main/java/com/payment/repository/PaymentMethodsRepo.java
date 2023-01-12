package com.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.payment.entity.PaymentMethods;

public interface PaymentMethodsRepo extends JpaRepository<PaymentMethods, Integer> {

	PaymentMethods findByName(String name);
}
