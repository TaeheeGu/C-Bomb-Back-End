package com.fireprohibition.CBomb.domain.chat;

import javax.persistence.*;

import com.fireprohibition.CBomb.domain.BaseEntity;
import com.fireprohibition.CBomb.domain.user.User;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Message extends BaseEntity {

	public Message(String text, MessageType messageType) {
		this.messageType = messageType;
		this.text = text;
	}

	@GeneratedValue
	@Id
	@Column(name = "message_id")
	private Long Id;
	private String text;

	@Enumerated(EnumType.STRING)
	private MessageType messageType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "chat_room_id")
	private ChatRoom chatRoom;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;

	public void setUser(User user) {
		this.user = user;
	}

	public void setChatRoom(ChatRoom chatRoom) {
		this.chatRoom = chatRoom;
		chatRoom.getMessages().add(this);
	}
}
