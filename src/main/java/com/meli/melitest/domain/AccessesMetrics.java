package com.meli.melitest.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "accesses")
public class AccessesMetrics {
	@Id
	@GeneratedValue
	private Long id;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime time;
	private Boolean found;
	private Long urlMini;

	public AccessesMetrics(LocalDateTime now, Boolean found, Long urlId) {
		this.time = now;
		this.found = found;
		this.urlMini = urlId;
	}

}
