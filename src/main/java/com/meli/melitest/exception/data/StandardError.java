package com.meli.melitest.exception.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StandardError {
	private Long timestamp;
	private Integer status;
	private String error;
	private String message;
	private String path;
}
