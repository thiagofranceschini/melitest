package com.meli.melitest.service.imp;

import static org.mockito.Mockito.doNothing;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.meli.melitest.configuration.ConfigurationProperties;
import com.meli.melitest.controller.data.UrlInputDto;
import com.meli.melitest.domain.RedirectData;
import com.meli.melitest.repository.RedirectDataRepository;
import com.meli.melitest.service.AccessesService;

@RunWith(MockitoJUnitRunner.class)
public class ShortenerServiceImpTest {
	
	@InjectMocks
	private ShortenerServiceImp target;
	
	@Mock
	private RedirectDataRepository repository;
	
	@Mock
	private AccessesService accesses;
	
	@Mock
	private ConfigurationProperties properties;
	
	
	@Test
	public void shouldShortenUrl() {
		//given
		UrlInputDto urlInputDto = new UrlInputDto();
		urlInputDto.setCategory("mockCategory");
		urlInputDto.setLongUrl("https://lista.mercadolivre.com.br/dohko-de-libra#D[A:dohko%20de%20libra]");
		
		RedirectData redirectDataMock = new RedirectData(urlInputDto);
		redirectDataMock.setId(123456l);
		
		Mockito.when(properties.getRedirectHost()).thenReturn("http://localhost:8080/");
		Mockito.when(properties.getSeparator()).thenReturn("!");
		Mockito.when(repository.save(Mockito.any())).thenReturn(redirectDataMock);
		
		//when
		String result = target.shortenUrl(urlInputDto);
		
		//then
		Assertions.assertThat(result).isEqualTo("http://localhost:8080/123456!mockCategory");
	}
	
	@Test
	public void ShouldFindAUrlOnDataBase() {
		//given
		UrlInputDto urlInputDto = new UrlInputDto();
		urlInputDto.setCategory("mockCategory");
		urlInputDto.setLongUrl("https://lista.mercadolivre.com.br/dohko-de-libra#D[A:dohko%20de%20libra]");
		
		Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(Optional.of(new RedirectData(urlInputDto)));
		
		//when
		String result = target.getUrl(123456l, "CDZ");
		
		//then
		Assertions.assertThat(result).isEqualTo("https://lista.mercadolivre.com.br/dohko-de-libra#D[A:dohko%20de%20libra]");
		
	}

	
	@Test
	public void cantFindUrl() {
		//given
		UrlInputDto urlInputDto = new UrlInputDto();
		urlInputDto.setCategory("mockCategory");
		urlInputDto.setLongUrl("https://lista.mercadolivre.com.br/dohko-de-libra#D[A:dohko%20de%20libra]");
		
		Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
		
		//when
		String result = target.getUrl(123456l, "CDZ");
		
		//then
		Assertions.assertThat(result).isEqualTo("CDZ");
		
	}
	
	@Test
	public void lastCaseCallDefaultRedirection() {
		//given
		UrlInputDto urlInputDto = new UrlInputDto();
		urlInputDto.setCategory("mockCategory");
		urlInputDto.setLongUrl("https://lista.mercadolivre.com.br/dohko-de-libra#D[A:dohko%20de%20libra]");
		
		Mockito.when(repository.findById(Mockito.anyLong())).thenThrow(new RuntimeException());
		//when
		String result = target.getUrl(123456l, "https://www.mercadolivre.com.br/");
		
		//then
		Assertions.assertThat(result).isEqualTo("https://www.mercadolivre.com.br/");
		
	}
	
	@Test
	public void shouldDelet() {
		doNothing().when(repository).deleteById(Mockito.anyLong());
		target.deleteById(123456789l);
	}
	
}
