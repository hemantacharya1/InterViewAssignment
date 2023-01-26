package com.assignment.salesken.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MarksReportDTO {
	
	private Double english;
	private Double maths;
	private Double science;
	
	private Double averagePercentile;
}
