package com.org.movietracking.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.movietracking.dto.MovieDTO;
import com.org.movietracking.dto.ReviewDTO;
import com.org.movietracking.entity.Movie;
import com.org.movietracking.repository.MovieRepository;
import com.org.movietracking.service.MovieServices;

@Transactional
@Service
public class MovieServicesImpl implements MovieServices {

	private final MovieRepository movieRepo;

	public MovieServicesImpl(MovieRepository movieRepo) {
		this.movieRepo = movieRepo;
	}

	@Override
	public MovieDTO addMovie(MovieDTO movieDto) {
		Movie movie = new Movie();
		movie.setTitle(movieDto.getTitle());
		movie.setGenre(movieDto.getGenre());
		movie.setReleaseYear(movieDto.getReleaseYear());
		Movie savedMovie = movieRepo.save(movie);
		return new MovieDTO(savedMovie.getId(), savedMovie.getTitle(), savedMovie.getGenre(),
				savedMovie.getReleaseYear(), Collections.emptyList());

	}

	@Override
	public List<MovieDTO> getAllMovies() {
		List<Movie> movies = movieRepo.findAll();
		return movies.stream()
				.map(movie -> new MovieDTO(movie.getId(), movie.getTitle(), movie.getGenre(), movie.getReleaseYear(),
						movie.getReviews().stream()
								.map(review -> new ReviewDTO(review.getId(), review.getReviewerName(),
										review.getComment(), review.getRating()))
								.collect(Collectors.toList())))
				.collect(Collectors.toList());
	}

	@Override
	public MovieDTO getMovieById(Long movieId) {

		Movie movie = movieRepo.findById(movieId).orElseThrow(() -> new RuntimeException("Movie not found!"));

		List<ReviewDTO> reviewDto = movie.getReviews().stream()
				.map(review -> new ReviewDTO(review.getReviewerName(), review.getComment(), review.getRating()))
				.collect(Collectors.toList());

		return new MovieDTO(movie.getTitle(), movie.getGenre(), movie.getReleaseYear(), reviewDto);

	}

}
