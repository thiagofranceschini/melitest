package com.meli.melitest.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meli.melitest.domain.AccessesMetrics;

public interface AccessesRepository extends JpaRepository<AccessesMetrics, Long> {

	long countByFoundAndTimeBetween(Boolean found, LocalDateTime start, LocalDateTime end);

	long countByUrlMiniAndTimeBetween(long urlMini, LocalDateTime start, LocalDateTime end);

	List<AccessesMetrics> findAllByUrlMiniAndTimeBetween(Long urlMini, LocalDateTime start, LocalDateTime end);

}
