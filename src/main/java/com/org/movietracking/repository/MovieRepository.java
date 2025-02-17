package com.org.movietracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.movietracking.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

}
