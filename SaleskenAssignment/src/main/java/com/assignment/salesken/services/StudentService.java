package com.assignment.salesken.services;

import java.util.List;

import com.assignment.salesken.model.MarksReportDTO;
import com.assignment.salesken.model.Semester;
import com.assignment.salesken.model.Student;

public interface StudentService {

	public Student createStudent(Student student);
	
	public MarksReportDTO averageReports(Integer semesterId);
	
	public void setMarks(Integer studentId,Semester semester);
	
	public List<Student> topTwoStudents();
}
