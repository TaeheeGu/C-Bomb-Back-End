package com.fireprohibition.CBomb.domain.chat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fireprohibition.CBomb.domain.BaseEntity;

import lombok.Getter;

@Entity
@Getter
public class Evaluation extends BaseEntity {
	@Id
	@GeneratedValue
	@Column(name = "evaluation_id")
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "evaluation_from_id")
	private ChatParticipant evaluationFrom;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "evaluation_to_id")
	private ChatParticipant evaluationTo;
}
