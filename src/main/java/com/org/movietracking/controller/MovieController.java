package com.org.movietracking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.movietracking.dto.MovieDTO;
import com.org.movietracking.service.impl.MovieServicesImpl;

@RestController
@RequestMapping("/movies")
public class MovieController {
	@Autowired
	private MovieServicesImpl movieServices;

	@GetMapping("/allmovies")
	public ResponseEntity<List<MovieDTO>> getAllMovies() {
		List<MovieDTO> movies = movieServices.getAllMovies();
		return ResponseEntity.ok(movies);
	}

	@PostMapping("/add")
	public ResponseEntity<MovieDTO> addMovie(@RequestBody MovieDTO movie) {
		MovieDTO moviedto = movieServices.addMovie(movie);
		return ResponseEntity.ok(moviedto);
	}

}
