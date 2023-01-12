package com.payment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.entity.PaymentMethods;
import com.payment.entity.PaymentPlans;
import com.payment.repository.PaymentMethodsRepo;
import com.payment.repository.PaymentPlansRepo;

@Service
public class PaymentService {

	@Autowired
	private PaymentMethodsRepo methodsRepo;
	@Autowired
	private PaymentPlansRepo plansRepo;
	
	public void addPayments(List<PaymentMethods> paymentMethods) {
		List<PaymentMethods> pms = methodsRepo.saveAll(paymentMethods);
		for(PaymentMethods m : pms) {
			if(m.getPaymentPlans() != null) {
				for(PaymentPlans p : m.getPaymentPlans()) {
					p.setPaymentMethods(m);
				}
				plansRepo.saveAll(m.getPaymentPlans());
			}
		}
	}
	
	public List<PaymentMethods> getPayments() {
		return methodsRepo.findAll();
	}
	
	public void updatePayments(PaymentMethods paymentMethods, Integer id) {
		PaymentMethods entity = methodsRepo.findById(id).get();
		entity.setName(paymentMethods.getName());
		entity.setDisplayName(paymentMethods.getDisplayName());
		entity.setName(paymentMethods.getName());
		entity.setPaymentType(paymentMethods.getPaymentType());
		
		List<PaymentPlans> paymentPlans = paymentMethods.getPaymentPlans();
		int i=0;
		
		for(PaymentPlans p : entity.getPaymentPlans()) {
			p.setNetAmount(paymentPlans.get(i).getNetAmount());
			p.setTax(paymentPlans.get(i).getTax());
			p.setGrossAmount(paymentPlans.get(i).getGrossAmount());
			p.setCurrency(paymentPlans.get(i).getCurrency());
			p.setDuration(paymentPlans.get(i++).getDuration());
		}
		methodsRepo.save(entity);
	}

	public PaymentMethods getPaymentById(Integer id) {
		Optional<PaymentMethods> payment = methodsRepo.findById(id);
		return payment.orElseThrow(IllegalArgumentException::new);
	}

	public PaymentMethods getPaymentByName(String name) {
		return methodsRepo.findByName(name);
	}
}
