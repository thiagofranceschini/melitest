package com.meli.melitest.service;

import com.meli.melitest.controller.data.UrlInputDto;

public interface ShortenerService {

	String shortenUrl(UrlInputDto input);

	String getUrl(Long urlId, String originalUrl);

	void deleteById(long parseLong);
	
}
