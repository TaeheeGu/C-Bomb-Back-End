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

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatParticipant extends BaseEntity {
	@Builder
	public ChatParticipant(User user, ChatRoom chatRoom) {
		setUser(user);
		setChatRoom(chatRoom);
	}

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

	public void setUser(User user) {
		this.user = user;
		user.getChatParticipants().add(this);
	}

	public void setChatRoom(ChatRoom chatRoom) {
		this.chatRoom = chatRoom;
		chatRoom.getChatParticipants().add(this);
	}

	public void addEvaluationToList(Evaluation evaluation) {
		evaluation.setEvaluationTo(this);
	}

	public void addEvaluationFromList(Evaluation evaluation) {
		evaluation.setEvaluationFrom(this);
	}
}
