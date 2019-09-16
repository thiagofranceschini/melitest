package com.meli.melitest.controller.helper;

import org.springframework.stereotype.Component;

import com.meli.melitest.configuration.ConfigurationProperties;
import com.meli.melitest.controller.exception.BadFormatException;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UrlIdExtractor {
	private ConfigurationProperties properties;
	
	public Long checkUrlId(String urlToCheck) {
		try {
			String[] strings = urlToCheck.split(properties.getSeparator());
			return Long.parseLong(strings[0]);
		} catch (NumberFormatException e) {
			throw new BadFormatException(properties.getErroUrlIdMessage());
		}
	}

}