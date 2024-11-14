package com.dsa360.api.constants;

public enum ReviewType {
	APPLICATION("application"), 
	KYC("kyc");

	private final String value;

	ReviewType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
