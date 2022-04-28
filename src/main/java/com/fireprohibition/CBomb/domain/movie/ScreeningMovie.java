package com.fireprohibition.CBomb.domain.movie;

import java.time.LocalDateTime;
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
import com.fireprohibition.CBomb.domain.chat.ChatRoom;
import com.fireprohibition.CBomb.domain.theater.Theater;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ScreeningMovie extends BaseEntity {
	@Builder
	public ScreeningMovie(LocalDateTime startTime, LocalDateTime endTime, Integer theaterNumber, Movie movie,
			Theater theater) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.theaterNumber = theaterNumber;
		setMovie(movie);
		setTheater(theater);
	}

	@Id
	@GeneratedValue
	@Column(name = "screening_movie_id")
	private Long id;

	@Column(name = "start_time")
	private LocalDateTime startTime;

	@Column(name = "end_time")
	private LocalDateTime endTime;

	@Column(name = "theater_number")
	private Integer theaterNumber;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "movie_id")
	private Movie movie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "theater_id")
	private Theater theater;

	@OneToMany(mappedBy = "screeningMovie")
	private List<ChatRoom> chatRooms = new ArrayList<>();

	public void addChatRoom(ChatRoom chatRoom) {
		chatRoom.setScreeningMovie(this);
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
		theater.getScreeningMovies().add(this);
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
		movie.getScreeningMovies().add(this);
	}
}
