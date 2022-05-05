package com.fireprohibition.CBomb.domain.chat;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fireprohibition.CBomb.domain.movie.ScreeningMovie;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {

	@Query(value = "SELECT cr FROM ChatRoom cr LEFT JOIN FETCH cr.screeningMovie sm WHERE cr.screeningMovie = ?1")
	List<ChatRoom> findByScreeningMovie(ScreeningMovie screeningMovie);
}
