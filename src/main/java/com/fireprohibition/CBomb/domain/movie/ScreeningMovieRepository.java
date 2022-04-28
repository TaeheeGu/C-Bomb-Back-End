package com.fireprohibition.CBomb.domain.movie;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fireprohibition.CBomb.domain.theater.Theater;

@Repository
public interface ScreeningMovieRepository extends JpaRepository<ScreeningMovie, Long> {

	@Query(value = "SELECT sm FROM ScreeningMovie sm LEFT JOIN FETCH sm.movie")
	List<ScreeningMovie> findByTheater(Theater theater);
}
