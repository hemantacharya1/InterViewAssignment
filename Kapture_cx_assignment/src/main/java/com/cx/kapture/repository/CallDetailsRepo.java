package com.cx.kapture.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cx.kapture.entities.CallDetails;

@Repository
public interface CallDetailsRepo extends JpaRepository<CallDetails, Long>{

	@Query("select Hour(c.startTime) as Hour, Count(*) as data from CallDetails c Group by Hour order by data desc")
	public List<Object[]> highestCallByHour();
	
	@Query("select Hour(c.startTime) as startTime, Sum(c.duration) as totalTime from CallDetails c group by startTime order by totalTime desc")
	public List<Object[]> longestCallByHour();
	
	@Query("select DayName(c.startTime) as day, count(*) as data from CallDetails c group by day order by data desc")
	public List<Object[]> highestCallByDay();
	
	@Query("select DayName(c.startTime) as day, Sum(c.duration) as totalTime from CallDetails c group by day order by totalTime desc")
	public List<Object[]> longestCallByDay();
}
