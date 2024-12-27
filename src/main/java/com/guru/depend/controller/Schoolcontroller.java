package com.guru.depend.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.guru.depend.entity.School;
import com.guru.depend.service.SchoolService;
@RestController
@RequestMapping("api/school")
public class SchoolController {
	@Autowired 
	private SchoolService schoolservice;
	//to create the school
	@PostMapping("/")
	public School createschool(@RequestBody School school) {
		return schoolservice.createRecord(school);
	}
	// to get all the schools
	@GetMapping("/")
    public List<School> allData(){ 
		 return schoolservice.allData();
	 }
	//to view the particular student details by the help of studentid
	@GetMapping("{id}")
	public School getSchoolDetails(@PathVariable Long id) {
		return schoolservice.getSchoolDetailsById(id);
	}
	//to get the teacher and student for an school
	@GetMapping("all/{id}")
	public List<Object> getallstudentandteacherbyschoolname(@PathVariable Long id){
		return schoolservice.getallstudentandteacherbyschoolname(id);
	}
	//to get all students count by school id
	@GetMapping("/student_count/{id}")
	public Map<String, Long> getStudentCountById(@PathVariable Long id){
		return schoolservice.getStudentCountById(id);
	}
	//to get all teachers count by school id
	@GetMapping("/teacher_count/{id}")
	public Map<String, Long> getTeachersById(@PathVariable Long id){
		return schoolservice.getTeachersById(id);			
	}
	//to update the school details by school id
	@PutMapping("/update/{id}")
	public Object updateSchool(@PathVariable Long id,@RequestBody School school) {
		return schoolservice.updateSchool(id, school);
	}
	//to delete the school
	@DeleteMapping("/delete/{id}")
	public String deleteByIdRecord(@PathVariable Long id)
	{
		return schoolservice.DeleteById(id);
	}
	//sorting the page 
	@GetMapping("/page")
	public Page<School> getSchoolByPage(@RequestParam int pageIndex,@RequestParam int pageSize,@RequestParam String field){
		return schoolservice.getSchoolByPage(pageIndex, pageSize, field);
	}
}
