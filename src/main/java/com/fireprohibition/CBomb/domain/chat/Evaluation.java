package com.fireprohibition.CBomb.domain.chat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fireprohibition.CBomb.domain.BaseEntity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Evaluation extends BaseEntity {
	@Builder
	public Evaluation(Integer mannerRate1, Integer mannerRate2, Integer mannerRate3, Integer mannerRate4,
			Integer mannerTotalRate, ChatParticipant evaluationFrom, ChatParticipant evaluationTo) {
		this.mannerRate1 = mannerRate1;
		this.mannerRate2 = mannerRate2;
		this.mannerRate3 = mannerRate3;
		this.mannerRate4 = mannerRate4;
		this.mannerTotalRate = mannerTotalRate;
		setEvaluationFrom(evaluationFrom);
		setEvaluationTo(evaluationTo);
	}

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

	public void setEvaluationFrom(ChatParticipant chatParticipant) {
		this.evaluationFrom = chatParticipant;
		chatParticipant.getEvaluationFromList().add(this);
	}

	public void setEvaluationTo(ChatParticipant chatParticipant) {
		this.evaluationFrom = chatParticipant;
		chatParticipant.getEvaluationToList().add(this);
	}
}
