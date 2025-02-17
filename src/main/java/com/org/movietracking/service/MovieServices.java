package com.org.movietracking.service;

import java.util.List;

import com.org.movietracking.dto.MovieDTO;

public interface MovieServices {

	/**
	 * Adds a new movie to the database.
	 *
	 * @param movieDto the movie details to be added.
	 * @return the added MovieDTO object.
	 */
	MovieDTO addMovie(MovieDTO movieDto);

	/**
	 * Fetches all movies from the database.
	 *
	 * @return a list of all MovieDTO objects.
	 */
	List<MovieDTO> getAllMovies();

	/**
	 * Fetches a specific movie by its ID.
	 *
	 * @param movieId the ID of the movie to retrieve.
	 * @return the MovieDTO object with the specified ID.
	 */
	MovieDTO getMovieById(Long movieId);
}
