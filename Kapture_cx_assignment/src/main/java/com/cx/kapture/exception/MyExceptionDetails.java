package com.cx.kapture.exception;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MyExceptionDetails {

	private LocalDateTime timeStamp;
	
	private String message;
	
	private String description;
}
