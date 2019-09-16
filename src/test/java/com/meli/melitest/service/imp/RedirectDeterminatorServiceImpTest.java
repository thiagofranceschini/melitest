package com.meli.melitest.service.imp;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.meli.melitest.configuration.ConfigurationProperties;

@RunWith(MockitoJUnitRunner.class)
public class RedirectDeterminatorServiceImpTest {

	@InjectMocks
	private RedirectDeterminatorServiceImp target;
	
	@Mock
	private ConfigurationProperties properties;
	
	@Test
	public void shouldChooseInformedUrl() {

		//given
		Mockito.when(properties.getSeparator()).thenReturn("!");
		Mockito.when(properties.getRedirectSearch()).thenReturn("https://lista.mercadolivre.com.br");
		
		//when
		String result = target.chose("http://localhost:8080/123456789!marvelcomics");
		
		//then
		Assertions.assertThat(result).isEqualTo("https://lista.mercadolivre.com.br/marvelcomics#D[:marvelcomics]");
	}
	
	@Test
	public void shouldChooseDefaultRedirectLocal() {

		//given
		Mockito.when(properties.getSeparator()).thenReturn("!");
		Mockito.when(properties.getRedirectSearch()).thenThrow(new RuntimeException());
		Mockito.when(properties.getRedirectDefault()).thenReturn("https://www.mercadolivre.com.br/");
		
		//when
		String result = target.chose("http://localhost:8080/123456789!marvelcomics");
		
		//then
		Assertions.assertThat(result).isEqualTo("https://www.mercadolivre.com.br/");
	}

}
