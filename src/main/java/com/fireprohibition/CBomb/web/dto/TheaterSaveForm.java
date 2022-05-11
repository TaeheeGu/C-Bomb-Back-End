package com.fireprohibition.CBomb.web.dto;

import com.fireprohibition.CBomb.domain.theater.Theater;
import com.fireprohibition.CBomb.domain.valueType.Address;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TheaterSaveForm {

	private String theater_city;
	private String theater_town;
	private String theater_name;
	private String theater_address;
	private String theater_tell;

	@Builder
	public TheaterSaveForm(String theater_city, String theater_town, String theater_name, String theater_address,
			String theater_tell) {
		this.theater_city = theater_city;
		this.theater_town = theater_town;
		this.theater_name = theater_name;
		this.theater_address = theater_address;
		this.theater_tell = theater_tell;
	}

	public Theater toEntity() {
		return Theater.builder()
				.name(theater_name)
				.contactNumber(theater_tell)
				.address(new Address(theater_city, theater_town, theater_address))
				.build();
	}
}
