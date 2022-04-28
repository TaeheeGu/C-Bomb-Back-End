package com.fireprohibition.CBomb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fireprohibition.CBomb.domain.BaseEntity;
import com.fireprohibition.CBomb.domain.movie.ScreeningMovie;
import com.fireprohibition.CBomb.domain.movie.ScreeningMovieRepository;
import com.fireprohibition.CBomb.domain.theater.TheaterRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ScreeningMovieService extends BaseEntity {
	private final ScreeningMovieRepository screeningMovieRepository;
	private final TheaterRepository theaterService;


	public List<ScreeningMovie> findByTheaterId(Long theaterId) {
		return screeningMovieRepository.findByTheater(theaterService.findById(theaterId).get());
	}

	public ScreeningMovie findById(Long screeningMovieId) {
		return screeningMovieRepository.findById(screeningMovieId).get();
	}
}
