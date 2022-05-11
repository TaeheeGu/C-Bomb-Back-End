package com.fireprohibition.CBomb.web.dto;

import com.fireprohibition.CBomb.domain.theater.Theater;
import com.fireprohibition.CBomb.domain.valueType.Address;

import lombok.Getter;

@Getter
public class TheaterResponseForm {

	private Long id;
	private String theater_city;
	private String theater_town;
	private String theater_name;
	private String theater_address;
	private String theater_tell;

	public TheaterResponseForm(Theater entity) {
		Address address = entity.getAddress();
		this.id = entity.getId();
		this.theater_city = address.getCity();
		this.theater_town = address.getTown();
		this.theater_name = entity.getName();
		this.theater_address = address.getDetail();
		this.theater_tell = entity.getContactNumber();
	}
}
