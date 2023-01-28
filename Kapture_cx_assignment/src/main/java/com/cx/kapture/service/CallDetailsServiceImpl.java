package com.cx.kapture.service;

import java.time.Duration;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.kapture.entities.CallDetailsDTO;
import com.cx.kapture.entities.CallDetails;
import com.cx.kapture.exception.CallDetailsException;
import com.cx.kapture.repository.CallDetailsRepo;

@Service
public class CallDetailsServiceImpl implements CallDetailsService{

	@Autowired
	private CallDetailsRepo callDetailsRepo;
	
	@Override
	public CallDetails addCallData(CallDetailsDTO dto) {
		CallDetails data=new CallDetails();
		data.setStartTime(dto.getStartTime());
		data.setEndTime(dto.getEndTime());
		data.setFromNumber(dto.getFromNumber());

		long seconds= Duration.between(dto.getStartTime(), dto.getEndTime()).getSeconds();
		
		data.setDuration(seconds);
		
		return callDetailsRepo.save(data);
	}

	@Override
	public String highestCallVolumeByHour() {
	
		List<Object[]> list=callDetailsRepo.highestCallByHour();
		if(list==null)
			throw new CallDetailsException("data not found");
		
		Object[] data=list.get(0);
		
		Integer start=(int)data[0];
		if(start==0) {
			return "Hour of the day when the call volume is highest is 12-1 AM";
		}
		if(start>=1 && start<=10) {
			return "Hour of the day when the call volume is highest is "+start+"-"+(start+1)+" AM";
		}
		if(start==11) {
			return "Hour of the day when the call volume is highest is "+start+"AM - "+(start+1)+"PM";
		}
		else {
			return "Hour of the day when the call volume is highest is "+start+"-"+(start-11)+"PM";
		}
	}

	@Override
	public String longestCallVolumeByHour() {

		List<Object[]> list=callDetailsRepo.longestCallByHour();
		if(list==null)
			throw new CallDetailsException("data not found");
		
		Object[] data=list.get(0);
		
		Integer start=(int)data[0];
		
		if(start==0) {
			return "Hour of the day when the call volume is longest is 12-1 AM";
		}
		if(start>=1 && start<=10) {
			return "Hour of the day when the call volume is longest is "+start+"-"+(start+1)+" AM";
		}
		if(start==11) {
			return "Hour of the day when the call volume is longest is "+start+"AM - "+(start+1)+"PM";
		}
		else {
			return "Hour of the day when the call volume is longest is "+start+"-"+(start-11)+"PM";
		}
		
	}

	@Override
	public String highestCallVolumeByDay() {
		List<Object[]> list=callDetailsRepo.highestCallByDay();
		if(list==null)
			throw new CallDetailsException("No data found");
		
		Object[] data=list.get(0);
		String day=(String)data[0];
		
		return "Day of the week when the call volume is highest is "+day;
	}

	@Override
	public String longestCallVolumeByDay() {
		List<Object[]> list=callDetailsRepo.longestCallByDay();
		if(list==null)
			throw new CallDetailsException("No data found");
		
		Object[] data=list.get(0);
		String day=(String)data[0];
		
		return "Day of the week when the call volume is longest is "+day;
	}

}
