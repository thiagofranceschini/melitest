package com.meli.melitest.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import com.meli.melitest.controller.data.UrlInputDto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "redirect_bind")
public class RedirectData {
	@Id
	@GeneratedValue
	private Long id;
	
	@Lob
	@Column(name = "url", nullable = false)
	private String originalUrl;
	
	public RedirectData(UrlInputDto input) {
		this.originalUrl = input.getLongUrl();
	}
}
