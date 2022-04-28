package com.fireprohibition.CBomb.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fireprohibition.CBomb.domain.chat.ChatParticipantRepository;
import com.fireprohibition.CBomb.domain.chat.ChatRoom;
import com.fireprohibition.CBomb.domain.chat.ChatRoomRepository;
import com.fireprohibition.CBomb.domain.movie.ScreeningMovieRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ChatRoomService {

	private final ChatRoomRepository chatRoomRepository;
	private final ScreeningMovieRepository screeningMovieRepository;
	private final ChatParticipantRepository chatParticipantRepository;

	public List<ChatRoom> findByScreeningMovie(Long screeningMovieId) {
		return chatRoomRepository.findByScreeningMovie(screeningMovieRepository.findById(screeningMovieId).get());
	}
}
