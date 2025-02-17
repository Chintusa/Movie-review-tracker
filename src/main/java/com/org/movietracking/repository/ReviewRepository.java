package com.org.movietracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.movietracking.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
