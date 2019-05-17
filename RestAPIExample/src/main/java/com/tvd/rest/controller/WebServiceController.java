package com.tvd.rest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tvd.rest.dto.Student;

@RestController
public class WebServiceController {
	
	List<Student> student= new ArrayList<Student>();
	
	WebServiceController(){
		Student  st1= new Student("Virat", "kohli", "govt");	
		Student  st2= new Student("anushka", "Sharma", "govt");
		Student  st3= new Student("AB", "Devillier", "govt");
		 student.add(st1);
		student.add(st2);
		student.add(st3);
	}
	
	@RequestMapping("/home")
	public String home() {
		return "home page created...";
		
	}
	
	
	/* @RequestMapping("/getAllStudent") */
	@GetMapping("/getAllStudent")
	public  List<Student> getAll(){
		return student;
		
	}
	
	@PostMapping(value="/saveStudent",consumes=MediaType.APPLICATION_JSON)
	public List<Student> Save(@RequestBody Student s) {
		
		student.add(s);
		return student;
		
	}
	
	@GetMapping("/getStudent/{name}")
	public List<Student> getStudent(@PathVariable("name") String name) {
		return student.stream().
				filter((a->a.getName().equals(name))).collect(Collectors.toList());
	}
	
	@DeleteMapping("/deleteStudent/{name}")
	public List<Student> deleteStudent(@PathVariable("name") String name) {
		return student.stream().
				filter((a->!a.getName().equals(name))).collect(Collectors.toList());
	}
	
}
