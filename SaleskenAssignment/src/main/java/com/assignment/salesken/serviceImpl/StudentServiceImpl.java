package com.assignment.salesken.serviceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.salesken.model.MarksReportDTO;
import com.assignment.salesken.model.Semester;
import com.assignment.salesken.model.Student;
import com.assignment.salesken.repository.StudentRepo;
import com.assignment.salesken.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepo sRepo;
	
	@Override
	public Student createStudent(Student student) {
		Semester first=new Semester(1, 0, 0, 0);
		Semester second=new Semester(2, 0, 0, 0);
		student.getSemesters().add(first);
		student.getSemesters().add(second);
		return sRepo.save(student);
	}
	
	@Override
	public void setMarks(Integer studentId,Semester semester) {
		Student student=sRepo.findById(studentId).orElseThrow(()->
													new RuntimeException("student not found with the id: "+studentId));
		
		student.getSemesters().get(semester.getId()-1).setEnglish(semester.getEnglish());
		student.getSemesters().get(semester.getId()-1).setMaths(semester.getMaths());
		student.getSemesters().get(semester.getId()-1).setScience(semester.getScience());
		
		sRepo.save(student);
	}

	@Override
	public MarksReportDTO averageReports(Integer semesterId) {
		List<Student>students=sRepo.findAll();
			int english=0;
			int maths=0;
			int science=0;
			int totalStudents=students.size();
			for(int i=0; i<students.size(); i++) {
					english+=students.get(i).getSemesters().get(semesterId-1).getEnglish();
					maths+=students.get(i).getSemesters().get(semesterId-1).getMaths();
					science+=students.get(i).getSemesters().get(semesterId-1).getScience();
				}
			int totalScoredMarks=english+maths+science;
			int totalMarks=totalStudents*300;
			
			Double percentile=((double)totalScoredMarks/totalMarks)*100;
			
			MarksReportDTO report=new MarksReportDTO();
			report.setEnglish((double)english/totalStudents);
			report.setMaths((double)maths/totalStudents);
			report.setScience((double)science/totalStudents);
			report.setAveragePercentile(percentile);
			return report;
	}
	
	@Override
	public List<Student> topTwoStudents() {
		List<Student>students=sRepo.findAll();
		HashMap<Integer,Student>map=new HashMap<>();
		System.out.println(students);
		for(int i=0; i<students.size(); i++) {
			int sum=0;
			sum+=students.get(i).getSemesters().get(0).getEnglish();
			sum+=students.get(i).getSemesters().get(0).getMaths();
			sum+=students.get(i).getSemesters().get(0).getScience();
			sum+=students.get(i).getSemesters().get(1).getEnglish();
			sum+=students.get(i).getSemesters().get(1).getMaths();
			sum+=students.get(i).getSemesters().get(1).getScience();
			map.put(sum,students.get(i));
		}
		
		Collection<Integer> collection=map.keySet();
		
		List<Integer> list=new ArrayList<>(collection);

		Collections.sort(list);
		
		List<Student>ans=new ArrayList<>();
		
		int first=list.get(list.size()-1);
		int second=list.get(list.size()-2);
		
		for(Map.Entry<Integer, Student> m:map.entrySet()) {
			if(m.getKey()==first) {
				ans.add(m.getValue());
			}
			if(m.getKey()==second) {
				ans.add(m.getValue());
			}
		}
		
		
		return ans;
	}

}
