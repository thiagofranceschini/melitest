package com.meli.melitest.service;

public interface AccessesService {

	void persistFindedMetric(Long urlId);

	void createNotFoundAlert(Long urlId);

}
