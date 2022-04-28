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
import com.fireprohibition.CBomb.domain.movie.ScreeningMovie;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatRoom extends BaseEntity {
	@Builder
	public ChatRoom(Integer maxParticipant, ScreeningMovie screeningMovie) {
		this.maxParticipant = maxParticipant;
		setScreeningMovie(screeningMovie);
	}

	@Id
	@GeneratedValue
	@Column(name = "chat_room_id")
	private Long id;

	@Column(name = "max_participant")
	private Integer maxParticipant;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "screening_movie_id")
	private ScreeningMovie screeningMovie;

	@OneToMany(mappedBy = "chatRoom")
	private List<ChatParticipant> chatParticipants = new ArrayList<>();

	public void addChatParticipant(ChatParticipant chatParticipant) {
		chatParticipant.setChatRoom(this);
	}

	public void setScreeningMovie(ScreeningMovie screeningMovie) {
		this.screeningMovie = screeningMovie;
		screeningMovie.getChatRooms().add(this);
	}
}
