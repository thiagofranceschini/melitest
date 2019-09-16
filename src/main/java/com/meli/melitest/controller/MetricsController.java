package com.meli.melitest.controller;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.meli.melitest.controller.data.MetricOutputData;
import com.meli.melitest.controller.helper.UrlIdExtractor;
import com.meli.melitest.service.MetricsService;
import com.meli.melitest.service.data.MetricsQueryInput;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class MetricsController {
	private final MetricsService service;
	private final UrlIdExtractor extractor;
	
	@GetMapping("/metrics")
	public ResponseEntity<MetricOutputData> getUrlShortenerMetrics(
			@RequestParam(name = "start-interval", required = false)
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "dd-MM-yyyy:HH:mm") LocalDateTime start, 
			@RequestParam(name = "final-interval", required = false)
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "dd-MM-yyyy:HH:mm") LocalDateTime end, 
			@RequestParam(name = "url-inspection", required = true) String urlId){
		
		MetricOutputData outputData = service.getMetrics(new MetricsQueryInput(start, end, extractor.checkUrlId(urlId)));
		
		return ResponseEntity.ok(outputData);
		
	}

}
