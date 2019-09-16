package com.meli.melitest.controller.data;

import java.util.List;

import com.meli.melitest.domain.AccessesMetrics;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetricOutputData {
	private Long requestsToUrl;
	private Long found;
	private Long notFound;
	private List<AccessesMetrics> accessesList;
}
