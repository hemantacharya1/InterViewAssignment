package com.cx.kapture.service;

import com.cx.kapture.entities.CallDetailsDTO;
import com.cx.kapture.entities.CallDetails;

public interface CallDetailsService {

	public CallDetails addCallData(CallDetailsDTO dto);
	
	public String highestCallVolumeByHour();
	
	public String longestCallVolumeByHour();
	
	public String highestCallVolumeByDay();
	
	public String longestCallVolumeByDay();
	
}
