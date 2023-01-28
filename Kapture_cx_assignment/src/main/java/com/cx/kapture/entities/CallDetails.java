package com.cx.kapture.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CallDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "From_number", nullable = false)
	private Long fromNumber;
	
	@Column(name = "Start_time", nullable= false)
	@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
	private LocalDateTime startTime;

	@Column(name = "End_time", nullable= false)
	@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
	private LocalDateTime endTime;
	
	@Column(name = "Duration", nullable= false)
	private Long duration;
}
