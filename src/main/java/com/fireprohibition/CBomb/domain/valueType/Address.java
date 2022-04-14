package com.fireprohibition.CBomb.domain.valueType;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import lombok.Getter;

@Embeddable
@Getter
public class Address {
	private String city;
	private String town;
	private String detail;

	public Address(String city, String town, String detail) {
		this.city = city;
		this.town = town;
		this.detail = detail;
	}
}
