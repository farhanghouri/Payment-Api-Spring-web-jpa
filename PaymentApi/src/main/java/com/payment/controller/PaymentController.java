package com.payment.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.payment.beans.PaymentMethodsBean;
import com.payment.beans.PaymentPlansBean;
import com.payment.entity.PaymentMethods;
import com.payment.entity.PaymentPlans;
import com.payment.service.PaymentService;

@RestController
@RequestMapping("/api/v1.0/configuration")
public class PaymentController {

	@Autowired
	private PaymentService service;
	
	@PostMapping(path = "/payment-methods")
	public void create(@RequestBody List<PaymentMethods> paymentMethods) {
		service.addPayments(paymentMethods);
	}

	@GetMapping(path = "/payment-methods")
	public List<PaymentMethodsBean> fetch(@RequestParam(required=false) Integer id, @RequestParam(required=false) String name) {
		if(id != null) {
			PaymentMethods paymentById = service.getPaymentById(id);
			return toBean(Arrays.asList(paymentById));
		}
		else if(name != null) {
			PaymentMethods paymentByName = service.getPaymentByName(name);
			return toBean(Arrays.asList(paymentByName));
		}
		
		List<PaymentMethods> payments = service.getPayments();
		return toBean(payments);
	}

	private List<PaymentMethodsBean> toBean(List<PaymentMethods> payments) {
		List<PaymentMethodsBean> beans = new ArrayList<>();
		for(PaymentMethods m : payments) {
			PaymentMethodsBean mb = new PaymentMethodsBean();
			mb.setName(m.getName());
			mb.setDisplayName(m.getDisplayName());
			mb.setName(m.getName());
			mb.setPaymentType(m.getPaymentType());
			for(PaymentPlans p : m.getPaymentPlans()) {
				PaymentPlansBean pb = new PaymentPlansBean();
				pb.setNetAmount(p.getNetAmount());
				pb.setTax(p.getTax());
				pb.setGrossAmount(p.getGrossAmount());
				pb.setCurrency(p.getCurrency());
				pb.setDuration(p.getDuration());
				mb.getPaymentPlans().add(pb);
			}
			beans.add(mb);
		}
		return beans;
	}
	
	@PutMapping(path = "/payment-methods")
	public void update(@RequestParam("payment-methods") Integer id, @RequestBody PaymentMethods paymentMethods) {
		service.updatePayments(paymentMethods, id);
	}
}
