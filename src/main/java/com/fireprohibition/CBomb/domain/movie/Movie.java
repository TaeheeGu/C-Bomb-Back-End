package com.fireprohibition.CBomb.domain.movie;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fireprohibition.CBomb.domain.BaseEntity;

import lombok.Getter;

@Entity
@Getter
public class Movie extends BaseEntity {
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

	private LocalDateTime opendate;

	@OneToMany(mappedBy = "movie")
	private List<ScreeningMovie> screeningMovies = new ArrayList<>();
}
