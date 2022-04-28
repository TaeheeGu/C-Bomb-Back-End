package com.fireprohibition.CBomb.domain.theater;

import java.util.ArrayList;
import java.util.List;

import com.fireprohibition.CBomb.domain.BaseEntity;
import com.fireprohibition.CBomb.domain.movie.ScreeningMovie;
import com.fireprohibition.CBomb.domain.user.Role;
import com.fireprohibition.CBomb.domain.valueType.Address;
import com.sun.istack.NotNull;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Theater extends BaseEntity {
	@Builder
	public Theater(String name, Address address, String contactNumber) {
		this.name = name;
		this.address = address;
		this.contactNumber = contactNumber;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "theater_id")
	private Long id;

	private String name;

	@Embedded
	private Address address;

	@Column(name = "contact_number")
	private String contactNumber;

	@OneToMany(mappedBy = "theater")
	private List<ScreeningMovie> screeningMovies = new ArrayList<>();



	public void update(String name, Address address, String contactNumber) {
		this.name = name;
		this.address = address;
		this.contactNumber = contactNumber;
	}
}

