package com.fireprohibition.CBomb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fireprohibition.CBomb.domain.theater.Theater;
import com.fireprohibition.CBomb.service.ChatRoomService;
import com.fireprohibition.CBomb.service.ScreeningMovieService;
import com.fireprohibition.CBomb.service.TheaterService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ChatRoomController {

	private final TheaterService theaterService;
	private final ChatRoomService chatRoomService;
	private final ScreeningMovieService screeningMovieService;

	@GetMapping("/theater/{theaterId}/{screeningMovieId}/chatRooms")
	public String chatRooms(
			@PathVariable("theaterId") Long theaterId,
			@PathVariable("screeningMovieId") Long screeningMovieId,
			Model model) {
		model.addAttribute("theater", theaterService.findById(theaterId));
		model.addAttribute("screeningMovie", screeningMovieService.findById(screeningMovieId));
		model.addAttribute("chatRooms", chatRoomService.findByScreeningMovie(screeningMovieId));
		return "chatList";
	}
}
