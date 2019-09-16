package com.meli.melitest.service.imp;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.meli.melitest.domain.AccessesMetrics;
import com.meli.melitest.repository.AccessesRepository;
import com.meli.melitest.service.AccessesService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class AccessesServiceImp implements AccessesService {
	private final AccessesRepository logRepository;
	
	@Override
	public void persistFindedMetric(Long urlId) {
		AccessesMetrics metrics = new AccessesMetrics(LocalDateTime.now(), true, urlId);
		log.info(logRepository.save(metrics).toString());
	}

	@Override
	public void createNotFoundAlert(Long urlId) {
		AccessesMetrics metrics = new AccessesMetrics(LocalDateTime.now(), false, urlId);
		log.info(logRepository.save(metrics).toString());
	}

}
