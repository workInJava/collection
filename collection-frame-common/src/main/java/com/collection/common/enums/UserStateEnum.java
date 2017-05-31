package com.collection.common.enums;

public enum UserStateEnum {

	LOCK("����")
	,NORM("����")
	;
	private String dec;

	private UserStateEnum(String dec) {
		this.dec = dec;
	}

	public String getDec() {
		return dec;
	}

	public void setDec(String dec) {
		this.dec = dec;
	}
	
	
}
