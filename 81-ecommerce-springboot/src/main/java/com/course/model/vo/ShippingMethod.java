package com.course.model.vo;

/**
 * 運送方式
 */
public class ShippingMethod {

	/** 運送方式(宅配, 店取...) */
	private String shippingType;
	
	/** 收件人 */
	private String recipient;
	
	/** 電話 */
	private String phone;
	
	/** 收件地址 */
	private String address;

	public String getShippingType() {
		return shippingType;
	}

	public void setShippingType(String shippingType) {
		this.shippingType = shippingType;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
