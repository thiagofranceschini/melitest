package com.meli.melitest.service;

import com.meli.melitest.controller.data.MetricOutputData;
import com.meli.melitest.service.data.MetricsQueryInput;

public interface MetricsService {

	public MetricOutputData getMetrics(MetricsQueryInput searchInput);
}
