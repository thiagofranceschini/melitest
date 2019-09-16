package com.meli.melitest.controller.helper;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.meli.melitest.configuration.ConfigurationProperties;
import com.meli.melitest.controller.exception.BadFormatException;

@RunWith(MockitoJUnitRunner.class)
public class UrlIdExtractorTest {
	
	@InjectMocks
	private UrlIdExtractor target;
	
	@Mock
	private ConfigurationProperties properties;
	
	@Test
	public void shouldHaveSuccessWhenParseUrl() {
		//given
		Mockito.when(properties.getSeparator()).thenReturn("!");
		
		//when
		Long result = target.checkUrlId("3!marvel");
		
		//then
		Assertions.assertThat(result).isEqualTo(3l);
	}
	
	@Test(expected = BadFormatException.class)
	public void shouldThrowBadExceptionWhenUrlNotFormated() {
		//given
		Mockito.when(properties.getSeparator()).thenReturn("!");
		
		//when
		target.checkUrlId("www.meulink/injecao/ddos3!marvel");
		
	}

}
