package com.techmania.remoteservice.bean;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class KeyAndValue implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4564972767479393072L;
	
	private String label;
	private String value;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
