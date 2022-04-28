package com.fireprohibition.CBomb.domain.movie;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fireprohibition.CBomb.domain.theater.Theater;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
	Optional<Movie> findByName(String name);
}
