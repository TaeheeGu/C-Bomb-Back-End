package com.fireprohibition.CBomb.domain.user;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fireprohibition.CBomb.domain.BaseEntity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Manner extends BaseEntity {
	@Builder
	public Manner(Integer mannerRate1, Integer mannerRate2, Integer mannerRate3, Integer mannerRate4,
			Integer mannerTotalRate, User user) {
		this.mannerRate1 = mannerRate1;
		this.mannerRate2 = mannerRate2;
		this.mannerRate3 = mannerRate3;
		this.mannerRate4 = mannerRate4;
		this.mannerTotalRate = mannerTotalRate;
		setUser(user);
	}

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

	public void setUser(User user) {
		this.user = user;
		user.setManner(this);
	}
}
