package com.payment.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


public class PaymentMethodsBean {

	private String name;
	private String displayName;
	private String paymentType;
	private List<PaymentPlansBean> paymentPlans = new ArrayList<PaymentPlansBean>();
	
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
	public List<PaymentPlansBean> getPaymentPlans() {
		return paymentPlans;
	}
	public void setPaymentPlans(List<PaymentPlansBean> paymentPlans) {
		this.paymentPlans = paymentPlans;
	}
}
