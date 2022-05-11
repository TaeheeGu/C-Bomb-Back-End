package com.fireprohibition.CBomb.web.controller;

import com.fireprohibition.CBomb.service.ScreeningMovieService;
import com.fireprohibition.CBomb.service.TheaterService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@Slf4j
public class TheaterController {

	private final TheaterService theaterService;
	private final ScreeningMovieService screeningMovieService;
	@GetMapping("/theater")
	public String selectAllTheaterList(Model model) {
		model.addAttribute("theaters", theaterService.findAll());
		return "theaterList";
	}

	@GetMapping("/theater/{theaterId}")
	public String theaterList(Model model, @PathVariable("theaterId") Long theaterId) {
		model.addAttribute("screeningMovies", screeningMovieService.findByTheaterId(theaterId));
		model.addAttribute("theater", theaterService.findById(theaterId));
		return "screeningMovieList";
	}
}
