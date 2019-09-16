package com.meli.melitest.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Component
@NoArgsConstructor
public class ConfigurationProperties {
	
	@Value("${business.settings.redirect.host}")
	private String redirectHost;
	
	@Value("${business.settings.redirect.separator}")
	private String separator;
	
	@Value("${business.settings.redirect.search}")
	private String redirectSearch;
	
	@Value("${business.settings.redirect.default}")
	private String redirectDefault;
	
	@Value("${business.settings.message.error.urlid}")
	private String erroUrlIdMessage;

}
