package com.meli.melitest.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.meli.melitest.controller.data.UrlInputDto;
import com.meli.melitest.controller.helper.UrlIdExtractor;
import com.meli.melitest.service.RedirectDeterminatorService;
import com.meli.melitest.service.ShortenerService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ShortenerController {
	private final UrlIdExtractor extractor;
	private final ShortenerService service;
	private final RedirectDeterminatorService redirectDeterminator;
	
	@PostMapping(value = "/shorten")
	public ResponseEntity<String> shorten(@RequestBody UrlInputDto input) {
		return ResponseEntity.ok(service.shortenUrl(input));
	}
	
	@GetMapping("/{urlMini}")
	public void toLongUrl(@PathVariable String urlMini, HttpServletResponse response) throws IOException {
		response.sendRedirect(service.getUrl(extractor.checkUrlId(urlMini), redirectDeterminator.chose(urlMini)));
	}
	
	@DeleteMapping("/{urlMini}")
	public ResponseEntity<Void> deleteUrlData(@PathVariable String urlMini) {
		service.deleteById(extractor.checkUrlId(urlMini));
		return ResponseEntity.noContent().build();
	}
	
}
