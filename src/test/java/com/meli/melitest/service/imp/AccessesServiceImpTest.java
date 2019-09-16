package com.meli.melitest.service.imp;

import static org.mockito.Mockito.times;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.meli.melitest.domain.AccessesMetrics;
import com.meli.melitest.repository.AccessesRepository;

@RunWith(MockitoJUnitRunner.class)
public class AccessesServiceImpTest {

	@InjectMocks
	private AccessesServiceImp target;
	
	@Mock
	private AccessesRepository repo;
	
	
	@Test
	public void shouldPersistAFoundedUrlAccesse() {
		//given
		AccessesMetrics metricMock = new AccessesMetrics(LocalDateTime.now(), true, 123456l);
		metricMock.setId(987654321l);
		Mockito.when(repo.save(Mockito.any())).thenReturn(metricMock);
		
		//when
		target.persistFindedMetric(123456l);
		
		//then
		Mockito.verify(repo, times(1)).save(Mockito.any());
	}
	
	@Test
	public void shouldPersistNotFoundUrlAccesses() {
		//given
		AccessesMetrics metricMock = new AccessesMetrics(LocalDateTime.now(), false, 123456l);
		metricMock.setId(987654321l);
		Mockito.when(repo.save(Mockito.any())).thenReturn(metricMock);
		
		//when
		target.createNotFoundAlert(123456l);
		
		//then
		Mockito.verify(repo, times(1)).save(Mockito.any());
	}
}
