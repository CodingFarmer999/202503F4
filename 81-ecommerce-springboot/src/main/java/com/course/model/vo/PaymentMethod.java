package com.course.model.vo;

/**
 * 付款方式
 */
public class PaymentMethod {

	/** 付款方式(貨到付款、信用卡...) */
	private String paymentType;

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

}
