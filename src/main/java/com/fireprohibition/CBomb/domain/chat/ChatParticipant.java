package com.fireprohibition.CBomb.domain.chat;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fireprohibition.CBomb.domain.BaseEntity;
import com.fireprohibition.CBomb.domain.user.User;

import lombok.Getter;

@Entity
@Getter
public class ChatParticipant extends BaseEntity {
	@Id
	@GeneratedValue
	@Column(name = "chat_participant_id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "chat_room_id")
	private ChatRoom chatRoom;

	@OneToMany(mappedBy = "evaluationTo")
	private List<Evaluation> evaluationToList = new ArrayList<>();
	@OneToMany(mappedBy = "evaluationFrom")
	private List<Evaluation> evaluationFromList = new ArrayList<>();
}
