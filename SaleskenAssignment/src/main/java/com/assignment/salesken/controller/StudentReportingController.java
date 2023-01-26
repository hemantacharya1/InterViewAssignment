package com.assignment.salesken.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.assignment.salesken.model.MarksReportDTO;
import com.assignment.salesken.model.Semester;
import com.assignment.salesken.model.Student;
import com.assignment.salesken.services.StudentService;

@Controller
public class StudentReportingController {
	
	
	/*
	 * Hello, to use this application first please configure the mysql database configuration according to 
	 * your local system.
	 * then just run the project as a spring boot project and go to the local host server
	 * Ex. http://localhost:8080/
	 * and after that the front end jsp will open and you can perform the operations.
	 * Thank you.
	 */
	
	
	
	@Autowired
	private StudentService sService;
	
	@RequestMapping("/")
	private String homePage() {
		return "home.jsp";
	}
	
	
	@RequestMapping(value = "add-student", method = RequestMethod.POST)
	public String saveStudent(HttpServletRequest request) {
		Student student=new Student(Integer.parseInt(request.getParameter("rollNumber")), request.getParameter("name")
									,request.getParameter("gender"), request.getParameter("address")
									,request.getParameter("email"));
		sService.createStudent(student);
		
		return "home.jsp";
	}
	
	@RequestMapping(value = "add-marks", method = RequestMethod.POST)
	public String editMarks(HttpServletRequest request) {
		Integer roll=Integer.parseInt(request.getParameter("rollNumber"));
		
		Semester semester=new Semester(Integer.parseInt(request.getParameter("id")),Integer.parseInt(request.getParameter("english")), 
											Integer.parseInt(request.getParameter("maths")) , Integer.parseInt(request.getParameter("science")));
		
		sService.setMarks(roll, semester);
		
		return "home.jsp";
	}
	
	
	@RequestMapping("/topstudents")
	public ModelAndView topTwoStudents() {
		List<Student> list=sService.topTwoStudents();
		ModelAndView model=new ModelAndView();
		model.addObject("list",list);
		model.setViewName("TopStudent.jsp");
		
		return model;
	}
	
	@RequestMapping(value = "choose-semester", method = RequestMethod.POST)
	public ModelAndView averageReport(HttpServletRequest request) {
		Integer semester=Integer.parseInt(request.getParameter("semester"));
		
		MarksReportDTO report=sService.averageReports(semester);
		
		List<MarksReportDTO>list=new ArrayList<>();
		list.add(report);
		
		ModelAndView model=new ModelAndView();
		model.addObject("list",list);
		model.setViewName("averageReport.jsp");
		
		return model;
	}
	
}
