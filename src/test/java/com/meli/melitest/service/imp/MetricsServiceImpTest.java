package com.meli.melitest.service.imp;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.meli.melitest.controller.data.MetricOutputData;
import com.meli.melitest.domain.AccessesMetrics;
import com.meli.melitest.repository.AccessesRepository;
import com.meli.melitest.service.data.MetricsQueryInput;

@RunWith(MockitoJUnitRunner.class)
public class MetricsServiceImpTest {

	@InjectMocks
	private MetricsServiceImp target;

	@Mock
	private AccessesRepository repo;

	@Test
	public void shouldGetMetricsFromUrls() {
		// given
		Mockito.when(repo.countByFoundAndTimeBetween(Mockito.anyBoolean(), Mockito.any(), Mockito.any())).thenReturn(325l);

		Mockito.when(repo.countByUrlMiniAndTimeBetween(Mockito.anyLong(), Mockito.any(), Mockito.any())).thenReturn(1l);

		List<AccessesMetrics> list = Arrays.asList(new AccessesMetrics(null, true, 192837645l));
		Mockito.when(repo.findAllByUrlMiniAndTimeBetween(Mockito.anyLong(), Mockito.any(), Mockito.any()))
				.thenReturn(list);
		
		MetricsQueryInput mockQuery = new MetricsQueryInput(LocalDateTime.now().minusHours(1l), LocalDateTime.now(), 192837645l);
		// when
		MetricOutputData result = target.getMetrics(mockQuery);
		
		// then
		Assertions.assertThat(result.getFound()).isEqualTo(325l);
		Assertions.assertThat(result.getNotFound()).isEqualTo(325l);
		Assertions.assertThat(result.getRequestsToUrl()).isEqualTo(1);
		Assertions.assertThat(result.getAccessesList().get(0).getUrlMini()).isEqualTo(192837645l);
		Assertions.assertThat(result.getAccessesList().get(0).getTime()).isNull();
		
	}
}
