package com.fireprohibition.CBomb.domain.movie;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fireprohibition.CBomb.domain.BaseEntity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Movie extends BaseEntity {
	@Builder
	public Movie(String name, String posterPath, String infoLink, Integer runningTime, LocalDate openDate) {
		this.name = name;
		this.posterPath = posterPath;
		this.infoLink = infoLink;
		this.runningTime = runningTime;
		this.openDate = openDate;
	}

	@Id
	@GeneratedValue
	@Column(name = "movie_id")
	private Long id;

	private String name;

	@Column(name = "poster_path")
	private String posterPath;

	@Column(name = "info_link")
	private String infoLink;

	@Column(name = "running_time")
	private Integer runningTime;

	private LocalDate openDate;

	@OneToMany(mappedBy = "movie")
	private List<ScreeningMovie> screeningMovies = new ArrayList<>();

	public void addScreeningMovie(ScreeningMovie screeningMovie) {
		screeningMovie.setMovie(this);
	}
}
