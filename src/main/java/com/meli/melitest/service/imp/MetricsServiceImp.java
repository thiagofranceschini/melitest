package com.meli.melitest.service.imp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.meli.melitest.controller.data.MetricOutputData;
import com.meli.melitest.domain.AccessesMetrics;
import com.meli.melitest.repository.AccessesRepository;
import com.meli.melitest.service.MetricsService;
import com.meli.melitest.service.data.MetricsQueryInput;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MetricsServiceImp implements MetricsService {
	private final AccessesRepository repository;
	
	
	@Override
	public MetricOutputData getMetrics(MetricsQueryInput input) {
		
		
		long totalFounded = repository.countByFoundAndTimeBetween(true, input.getStart(), input.getEnd());
		
		long totalNotFounded = repository.countByFoundAndTimeBetween(false, input.getStart(), input.getEnd());
		
		long byUrlId = repository.countByUrlMiniAndTimeBetween(input.getUrlid(), input.getStart(), input.getEnd());
		
		List<AccessesMetrics> list = repository.findAllByUrlMiniAndTimeBetween(input.getUrlid(), input.getStart(), input.getEnd());
		
		return new MetricOutputData(byUrlId, totalFounded, totalNotFounded, list);
		
	}

}
