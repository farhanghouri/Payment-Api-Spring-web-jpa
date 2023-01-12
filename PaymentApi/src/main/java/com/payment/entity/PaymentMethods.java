package com.payment.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class PaymentMethods {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String displayName;
	private String paymentType;
	@OneToMany(mappedBy = "paymentMethods", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	private List<PaymentPlans> paymentPlans;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public List<PaymentPlans> getPaymentPlans() {
		return paymentPlans;
	}
	public void setPaymentPlans(List<PaymentPlans> paymentPlans) {
		this.paymentPlans = paymentPlans;
	}
}
