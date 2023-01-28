package com.cx.kapture.entities;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class CallDetailsDTO {

	private Long fromNumber;
	
	@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
	private LocalDateTime startTime;

	@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
	private LocalDateTime endTime;
}
