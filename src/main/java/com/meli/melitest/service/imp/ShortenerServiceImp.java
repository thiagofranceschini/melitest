package com.meli.melitest.service.imp;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.meli.melitest.configuration.ConfigurationProperties;
import com.meli.melitest.controller.data.UrlInputDto;
import com.meli.melitest.domain.RedirectData;
import com.meli.melitest.repository.RedirectDataRepository;
import com.meli.melitest.service.AccessesService;
import com.meli.melitest.service.ShortenerService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ShortenerServiceImp implements ShortenerService {
	private final RedirectDataRepository repository;
	private final AccessesService accesses;
	private final ConfigurationProperties properties;

	@Override
	public String shortenUrl(UrlInputDto input) {
		RedirectData saved = repository.save(new RedirectData(input));
		return properties.getRedirectHost() + saved.getId() + properties.getSeparator() + input.getCategory();
	}

	@Override
	public String getUrl(Long urlId, String optionalRedirection) {
		try {
			Optional<RedirectData> optional = repository.findById(urlId);

			if (optional.isPresent()) {
				accesses.persistFindedMetric(urlId);
				return optional.get().getOriginalUrl();
			} else {
				accesses.createNotFoundAlert(urlId);
				return optionalRedirection;
			}

		} catch (Exception e) {
			return optionalRedirection;
		}
	}

	@Override
	public void deleteById(long id) {
		repository.deleteById(id);
	}

}
