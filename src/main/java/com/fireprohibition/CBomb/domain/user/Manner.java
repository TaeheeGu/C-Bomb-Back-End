package com.fireprohibition.CBomb.domain.user;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fireprohibition.CBomb.domain.BaseEntity;

import lombok.Getter;

@Entity
@Getter
public class Manner extends BaseEntity {
	@Id
	@GeneratedValue
	@Column(name = "manner_id")
	private Long id;

	@Column(name = "manner_rate1")
	private Integer mannerRate1;

	@Column(name = "manner_rate2")
	private Integer mannerRate2;

	@Column(name = "manner_rate3")
	private Integer mannerRate3;

	@Column(name = "manner_rate4")
	private Integer mannerRate4;

	@Column(name = "manner_total_rate")
	private Integer mannerTotalRate;

	@OneToOne(
			mappedBy = "manner",
			fetch = FetchType.LAZY,
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private User user;
}
