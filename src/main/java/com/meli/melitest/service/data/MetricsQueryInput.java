package com.meli.melitest.service.data;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MetricsQueryInput {
	private LocalDateTime start;
	private LocalDateTime end;
	private Long urlid;

	public MetricsQueryInput(LocalDateTime start, LocalDateTime end, Long urlId) {
		LocalDateTime now = LocalDateTime.now();
		this.start = (null==start) ? now.minusDays(1) : start;
		this.end = (null == end) ? now : end;
		this.urlid = urlId;
	}

}
