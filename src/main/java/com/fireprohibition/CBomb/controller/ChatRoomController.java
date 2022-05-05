package com.fireprohibition.CBomb.controller;

import com.fireprohibition.CBomb.repository.ChatRoomRepo;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.fireprohibition.CBomb.domain.theater.Theater;
import com.fireprohibition.CBomb.service.ChatRoomService;
import com.fireprohibition.CBomb.service.MessageService;
import com.fireprohibition.CBomb.service.ScreeningMovieService;
import com.fireprohibition.CBomb.service.TheaterService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class ChatRoomController {

  private final ChatRoomRepo repository;
	private final TheaterService theaterService;
	private final ChatRoomService chatRoomService;
	private final ScreeningMovieService screeningMovieService;
	private final MessageService messageService;

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
  
	@PostMapping("/theater/{theaterId}/{screeningMovieId}/chatRooms")
	public String createChatRoom(
			@PathVariable("theaterId") Long theaterId,
			@PathVariable("screeningMovieId") Long screeningMovieId) {
		Long chatRoomId = chatRoomService.createChatRoom(screeningMovieId);
		return "redirect:/theater/" + theaterId + "/" + screeningMovieId + "/chatRooms/" + chatRoomId;
	}

	@GetMapping("/theater/{theaterId}/{screeningMovieId}/chatRooms/{chatRoomId}")
	public String detailChatRoom(@PathVariable Long chatRoomId, Model model) {
		model.addAttribute("lastMessages", messageService.findByChatRoom(chatRoomId));
		model.addAttribute("room", chatRoomService.findById(chatRoomId));
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String name = authentication.getName();
		model.addAttribute("userName", name);
		return "chatRoom";
	}
}
