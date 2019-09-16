package com.meli.melitest.service.imp;

import org.springframework.stereotype.Service;

import com.meli.melitest.configuration.ConfigurationProperties;
import com.meli.melitest.service.RedirectDeterminatorService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RedirectDeterminatorServiceImp implements RedirectDeterminatorService {
	private final ConfigurationProperties properties;
	
	@Override
	public String chose(String urlMini) {
		String redirectLocal;
		try {
			String[] strings = urlMini.split(properties.getSeparator());
			redirectLocal = properties.getRedirectSearch() + "/" + strings[1] + "#D[:" + strings[1] + "]";
		} catch (Exception e) {
			redirectLocal = properties.getRedirectDefault();
		}
		return redirectLocal;
	}

}
